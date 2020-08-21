package com.kobiton;

public class Agent {
    public static boolean waitForDeviceOnline(String hostName, String username, String apiKey, String deviceGroup, String udid, int timeOutInSeconds) {
        return CheckDeviceStatus.waitForDevice(hostName, username, apiKey, deviceGroup, udid, timeOutInSeconds);
    }
}
