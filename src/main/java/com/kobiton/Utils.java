package com.kobiton;

import org.apache.commons.codec.binary.Base64;

public class Utils {
    public static void sleep(int seconds) {
        try {
            Thread.sleep((long)(seconds * 1000));
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }

    public static String generateBasicAuth(String username, String apiKey) {
        String authString = username + ":" + apiKey;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        return "Basic " + authStringEnc;
    }

    public static String getServer(String hostname) {
        return String.format("https://%s/v1/devices?isOnline=true&isBooked=false", hostname);
    }

    public static String getDeviceGroup(String deviceGroup) {
        deviceGroup = deviceGroup.toUpperCase();
        String output;
        if (deviceGroup.equals("PRIVATE")) {
            output = "privateDevices";
        } else if (deviceGroup.equals("FAVORITE")) {
            output = "favoriteDevices";
        } else {
            output = "cloudDevices";
        }

        return output;
    }
}
