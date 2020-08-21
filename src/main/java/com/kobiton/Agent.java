package com.kobiton;

public class Agent {
    static String hostName = "api.kobiton.com";
    static int timeout = 120;
    static String deviceGroup = "cloud";

    /**
     * Wait for the device online with the specific UDID
     @param hostName The default value is api.kobiton.com
     @param username Your Username
     @param apiKey Your API Key
     @param deviceGroup There are cloud, private and favorite groups
     @param udid The unique udid of the selected device
     @param timeOutInSeconds The timeout to wait the device online
     */
    public static boolean waitForDeviceOnline(String hostName, String username, String apiKey, String deviceGroup, String udid, int timeOutInSeconds) {
        return CheckDeviceStatus.waitForDevice(hostName, username, apiKey, deviceGroup, udid, timeOutInSeconds);
    }

    /**
     * Wait for the device online with the specific UDID
     @param username Your Username
     @param apiKey Your API Key
     @param deviceGroup There are cloud, private and favorite groups
     @param udid The unique udid of the selected device
     @param timeOutInSeconds The timeout to wait the device online
     */
    public static boolean waitForDeviceOnline(String username, String apiKey, String deviceGroup, String udid, int timeOutInSeconds) {
        return CheckDeviceStatus.waitForDevice(hostName, username, apiKey, deviceGroup, udid, timeOutInSeconds);
    }

    /**
     * Wait for the device online with the specific UDID
     @param username Your Username
     @param apiKey Your API Key
     @param deviceGroup There are cloud, private and favorite groups
     @param udid The unique udid of the selected device
     Note: The default timeout 120 seconds
     */
    public static boolean waitForDeviceOnline(String username, String apiKey, String deviceGroup, String udid) {
        return CheckDeviceStatus.waitForDevice(hostName, username, apiKey, deviceGroup, udid, timeout);
    }

    /**
     * Wait for the device online with the specific UDID
     @param username Your Username
     @param apiKey Your API Key
     @param udid The unique udid of the selected device
     @param timeOutInSeconds The timeout to wait the device online
     Note: The default device group is cloud
     */
    public static boolean waitForDeviceOnline(String username, String apiKey, String udid, int timeOutInSeconds) {
        return CheckDeviceStatus.waitForDevice(hostName, username, apiKey, deviceGroup, udid, timeOutInSeconds);
    }

    /**
     * Wait for the device online with the specific UDID
     @param username Your Username
     @param apiKey Your API Key
     @param udid The unique udid of the selected device
     Note: The default device group is cloud with timeout 120 seconds
     */
    public static boolean waitForDeviceOnline(String username, String apiKey, String udid) {
        return CheckDeviceStatus.waitForDevice(hostName, username, apiKey, deviceGroup, udid, timeout);
    }
}
