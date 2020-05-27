package com.company;

public class SmartDevice {
    String name = "defaultName";
    Double location = 0.0;
    Boolean switchedOn = false;

    public SmartDevice(String parameterName, Double parameterLocation, Boolean parameterSwitchedOn) {
        name = parameterName;
        location = parameterLocation;
        switchedOn = parameterSwitchedOn;
    }


    public static void switchOn(SmartDevice smartDevice) { smartDevice.switchedOn = true; }

    public static void switchOff(SmartDevice smartDevice) { smartDevice.switchedOn = false; }

    public static SmartDevice createSmartDevice(String name, Double location, Boolean switchedOn){
            SmartDevice device = new SmartDevice(name, location, switchedOn);
        return device;
    }

    public String toString(){

        String returnValue = "";

        returnValue += "Name:        " + name + "\n";
        returnValue += "Location:    " + location + "\n";
        returnValue += "Power State: " + switchedOn+ "\n";

        return returnValue;
    }



}

