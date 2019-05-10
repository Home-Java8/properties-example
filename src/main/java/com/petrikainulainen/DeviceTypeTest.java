package com.petrikainulainen;

import org.apache.commons.lang3.StringUtils;

/**
 * @see https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
 */
public class DeviceTypeTest {

    public static void main(String[] args) {
        String getDeviceType = "01";
        String deviceName = getDeviceName(getDeviceType);
        System.out.println("DeviceType = " + getDeviceType + ";");
        System.out.println("DeviceName = " + deviceName + ";");

        System.out.println();

        getDeviceType = "02";
        deviceName = getDeviceName(getDeviceType);
        System.out.println("DeviceType = " + getDeviceType + ";");
        System.out.println("DeviceName = " + deviceName + ";");

        System.out.println();

        boolean isNumeric = isNumeric(getDeviceType);
        System.out.println("isNumeric = " + isNumeric + ";");

        getDeviceType = "MOBILE_PHONE";
        isNumeric = isNumeric(getDeviceType);
        System.out.println("isNumeric = " + isNumeric + ";");
    }

    static String getDeviceName(String getDeviceType) {
        if (StringUtils.isNotBlank(getDeviceType)) {
            int deviceTypeId = Integer.valueOf(getDeviceType);
            DeviceType deviceType = (0<deviceTypeId && deviceTypeId<=5)
                    ? DeviceType.valueOfType(deviceTypeId)
                    : DeviceType.UNKNOWN;
            return deviceType.name();
        }
        return null;
    }

    static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
