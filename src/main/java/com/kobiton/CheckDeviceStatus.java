package com.kobiton;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class CheckDeviceStatus {
    static JSONObject filterDeviceInfo(JSONObject device) {
        JSONObject filteredDeviceInfo = new JSONObject();
        filteredDeviceInfo.put("id", device.get("id"));
        filteredDeviceInfo.put("udid", device.get("udid"));
        filteredDeviceInfo.put("isBooked", device.get("isBooked"));
        filteredDeviceInfo.put("isOnline", device.get("isOnline"));
        filteredDeviceInfo.put("modelName", device.get("modelName"));
        filteredDeviceInfo.put("deviceName", device.get("deviceName"));
        filteredDeviceInfo.put("platformName", device.get("platformName"));
        filteredDeviceInfo.put("platformVersion", device.get("platformVersion"));
        return filteredDeviceInfo;
    }

    static JSONArray getOnlineDevices(String hostName, String username, String apiKey, String deviceGroup) {
        try {
            URL obj = new URL(Utils.getServer(hostName));
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", Utils.generateBasicAuth(username, apiKey));
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer response = new StringBuffer();

            String inputLine;
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            if (responseCode != 200) {
                System.exit(1);
            }

            JSONObject deviceList = new JSONObject(response.toString());
            JSONArray devices = deviceList.getJSONArray(deviceGroup);
            JSONArray filteredDeviceInfo = new JSONArray();

            for(int i = 0; i < devices.length(); ++i) {
                filteredDeviceInfo.put(filterDeviceInfo(devices.getJSONObject(i)));
            }

            return filteredDeviceInfo;
        } catch (Exception var14) {
            var14.printStackTrace();
            return null;
        }
    }

    static boolean fitlterDeviceOnlineByUDID(JSONArray devices, String udid) {
        boolean flag = false;
        if (udid.equals("*") && devices.length() > 0) {
            return true;
        } else {
            for(int i = 0; i < devices.length(); ++i) {
                String data = devices.getJSONObject(i).getString("udid");
                if (data.equals(udid)) {
                    System.out.println(String.format("The device with UDID '%s' is online now.", udid));
                    flag = true;
                    break;
                }
            }

            return flag;
        }
    }

    public static boolean waitForDevice(String hostName, String username, String apiKey, String deviceGroup, String udid, int timeOutInSeconds) {
        deviceGroup = Utils.getDeviceGroup(deviceGroup);
        int loop = timeOutInSeconds;
        int start = 0;

        boolean flag;
        for(flag = false; start < loop; ++start) {
            JSONArray onlineDevices = getOnlineDevices(hostName, username, apiKey, deviceGroup);
            if (fitlterDeviceOnlineByUDID(onlineDevices, udid)) {
                flag = true;
                break;
            }

            Utils.sleep(1);
        }

        return flag;
    }
}

