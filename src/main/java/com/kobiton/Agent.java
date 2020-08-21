package com.kobiton;

public class Agent {
    static String hostName = "api.kobiton.com";
    static int timeout = 120;
    static String deviceGroup = "cloud";

    public static boolean waitForDeviceOnline(String hostName, String username, String apiKey, String deviceGroup, String udid, int timeOutInSeconds) {
        return CheckDeviceStatus.waitForDevice(hostName, username, apiKey, deviceGroup, udid, timeOutInSeconds);
    }

    public static boolean waitForDeviceOnline(String username, String apiKey, String deviceGroup, String udid, int timeOutInSeconds) {
        return CheckDeviceStatus.waitForDevice(hostName, username, apiKey, deviceGroup, udid, timeOutInSeconds);
    }

    public static boolean waitForDeviceOnline(String username, String apiKey, String deviceGroup, String udid) {
        return CheckDeviceStatus.waitForDevice(hostName, username, apiKey, deviceGroup, udid, timeout);
    }

    public static boolean waitForDeviceOnline(String username, String apiKey, String udid, int timeOutInSeconds) {
        return CheckDeviceStatus.waitForDevice(hostName, username, apiKey, deviceGroup, udid, timeOutInSeconds);
    }

    public static boolean waitForDeviceOnline(String username, String apiKey, String udid) {
        return CheckDeviceStatus.waitForDevice(hostName, username, apiKey, deviceGroup, udid, timeout);
    }
}
