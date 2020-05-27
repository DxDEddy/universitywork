package com.company;

public class SmartFridge extends SmartDevice {
    double currentTemperature;

    /*
    Design and write a SmartFridge class (SmartFridge.java) which directly inherits (extends) from the SmartDevice class.
    This class has only one private member variable: currentTemperature (double).
    This member variable should only be accessed and updated through standard  get/set methods.
    */

    public void setCurrentTemperature (double newTemperature) { currentTemperature = newTemperature; }

    public double getCurrentTemperature () { return currentTemperature; }



    /*
    Design and write a constructor.
    The constructor takes 3 parameters: currentTemperature, name and location.
    The constructor should call the superclass constructor with
        name, location and a true value for the superclass switchedOn member variable.
    It should set the value of currentTemperature from the parameter value.
    */
    public SmartFridge(String parameterDeviceName, Double parameterDeviceLocation, Double parameterCurrentTemperature){
        super(parameterDeviceName, parameterDeviceLocation, true);
    }


    /*
    Design and write increment() and decrement() methods.
    The increment() method increases the temperature by 1 degree,
    The decrement() method decreases the temperature by 1 degree.
    */
    public static void increment(SmartFridge fridgeToIncrementTemperature){
        fridgeToIncrementTemperature.currentTemperature = fridgeToIncrementTemperature.currentTemperature+1;
    }

    public static void decrement(SmartFridge fridgeToDecrementTemperature){
        fridgeToDecrementTemperature.currentTemperature = fridgeToDecrementTemperature.currentTemperature-1;
    }


    /*
    Design and write a SmartFridge switchOff() method, overriding the one inherited from SmartDevice.
    The switchOff() method should not change the switchedOn variable.
    The SmartFridge should not be switched off ever!
    */
    public void switchOff () {

    }



    /*
    Design and write a toString() method.
    This method uses the superclass toString() method and adds the currentTemperature so it returns:

    Name: fridge 1
    Location: 3.1
    Switched On: true
    Current Temperature: 3
    */

    @Override
    public String toString(){
        String returnValue = "";

        returnValue += super.toString();
        returnValue += "Temperature: "+currentTemperature + "\n";

        return returnValue;
    }





}
