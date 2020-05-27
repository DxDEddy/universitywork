package com.company;

public class SmartHome {

   SmartDevice[] arrayOfSmartDeviceObjects;



    /*
    The first constructor should take one parameter: a size value.
    The constructor should create a new instance of the array using the size parameter.
    The initial array should be unpopulated - it should contain null values at every index.
    */
    public SmartHome(int sizeOfArray) {
        arrayOfSmartDeviceObjects = new SmartDevice[sizeOfArray];
    }

    /*
    The second constructor should take one parameter: an array of pre-populated SmartDevices.
    This parameter should be assigned to the member variable
    */
    public SmartHome(SmartDevice[] prePopulatedSmartDevices){arrayOfSmartDeviceObjects = prePopulatedSmartDevices;}

    //
    //Design and write two insertDevice() methods.
    //

    /*
    The first insertDevice() method should take one parameter: a SmartDevice object.
    It should insert the SmartDevice at the first empty (null) array position and fail if there is no empty position in the array.
    */
    public void insertDevice(SmartDevice deviceToInsertIntoArray) {
        for (int i = 0; i < arrayOfSmartDeviceObjects.length;) {
            if (arrayOfSmartDeviceObjects[i] == null){
                arrayOfSmartDeviceObjects[i] = deviceToInsertIntoArray;
                return;
            }
            else{
                i++;
            }

        }
    }

    /*
    The second insertDevice() method takes 3 parameters: name, location and switchedOn,
    parameters corresponding to the three member variables of the SmartDevice class.
    It creates a SmartDevice from the parameter values.
    It should then insert the SmartDevice at the first empty (null) position in the array and fail if there is no empty position.
    */
    public void insertDevice(String deviceName, Double deviceLocation, Boolean deviceState){
        SmartDevice newlyCreatedDevice = SmartDevice.createSmartDevice(deviceName, deviceLocation, deviceState);
        insertDevice(newlyCreatedDevice);

        for (int i = 0; i < arrayOfSmartDeviceObjects.length;) {
            if (arrayOfSmartDeviceObjects[i] == null){
                arrayOfSmartDeviceObjects[i] = newlyCreatedDevice;
                return;
            }
            else{
                i++;
            }

        }
    }

    //
    //Design and write two getDevice() methods
    //

    /*
    The first getDevice() method should take one parameter: an index value.
    It should return the SmartDevice object at the index of the array.
    If the index is too big or small for the array, or if there is no SmartDevice at the given index, then it should return null.
    */
    public SmartDevice getDevice(Integer indexValue){ return arrayOfSmartDeviceObjects[indexValue]; }

    /*
    The second getDevice() method should also have one parameter:  a location value.
    The method returns the SmartDevice object at the given location.
    If no device is at the given location, then it should return null.
    */
    public SmartDevice getDevice(Double locationToCheck) {
        for (int i = 0; i<arrayOfSmartDeviceObjects.length;i++){

            //I was having issues with comparing doubles using the proper way so I had to use a workaround.
            Double comparisonResult = arrayOfSmartDeviceObjects[i].location-locationToCheck;

            if(comparisonResult == 0){
                return arrayOfSmartDeviceObjects[i];
            }
        }
        return null;
    }

    /*
    Design and write a toggle() method.
    This method takes one parameter: the location (a search parameter).
    The method attempts to locate the SmartDevice using the location parameter.
    If it finds a SmartDevice at the location then it should flip the switchedOn value of the SmartDevice
        -(from false to true, or from true to false)
    */
    public void toggle(Double locationToSearch){
        if (getDevice(locationToSearch).switchedOn) { getDevice(locationToSearch).switchedOn = false; }
        else { getDevice(locationToSearch).switchedOn = true; }
    }

    //I was unsure if we should use the location member variable or array position so I made both.
    /*
    public void toggle(Integer arrayIndexToSearch){
        if (arrayOfSmartDeviceObjects[arrayIndexToSearch].switchedOn){
            arrayOfSmartDeviceObjects[arrayIndexToSearch].switchedOn = false;
        }
        else {
            arrayOfSmartDeviceObjects[arrayIndexToSearch].switchedOn = true;
        }
    }
    */

    @Override
    public String toString(){
        String returnValues = "";
        for(int i = 0; i < arrayOfSmartDeviceObjects.length;i++){
            returnValues += "-------------\n";
            returnValues += "DEVICE: " + (i+1) +"\n";
            Step2.newLinePrint(1);
            returnValues += arrayOfSmartDeviceObjects[i].toString();
        }
        returnValues += "-------------\n";
        return returnValues;
    }


    //
    //STEP 3
    //

    /*
    Design and write an addDevice() method.
    The addDevice takes one parameter: a SmartDevice object.
    This method increases the size of the array by one, using the technique covered in the lectures,
        -if the array is already full. It inserts the new device at the new final (empty) location of the array.
    */
    public void addDevice(SmartDevice deviceToAdd) {
        for (int i = 0; i < arrayOfSmartDeviceObjects.length;){
            if (arrayOfSmartDeviceObjects[i] == null){
                Step3.printString("Null found - inserting: "+deviceToAdd.name);
                arrayOfSmartDeviceObjects[i] = deviceToAdd;
                return;
            }
            else if(arrayOfSmartDeviceObjects[i] != null && i == arrayOfSmartDeviceObjects.length-1){
                Step3.printString("No space found - expanding from " + arrayOfSmartDeviceObjects.length + " to " + arrayOfSmartDeviceObjects.length+"+1");
                SmartDevice[] b = new SmartDevice[arrayOfSmartDeviceObjects.length + 1];
                for (int c=0; c < arrayOfSmartDeviceObjects.length; ++c) {
                    b[c] = arrayOfSmartDeviceObjects[c];
                }
                arrayOfSmartDeviceObjects = b;
                arrayOfSmartDeviceObjects[arrayOfSmartDeviceObjects.length - 1] = deviceToAdd;

                return;
            }
            else{
                Step3.printString("Exception was found - incrementing i");
                i++;
            }
        }
    }

    /*
    Design and write a setAllInRoom() method.
    This method takes two parameters:
        a room location search parameter (an integer corresponding to the room part of the location variable)
        and a new switchedOn value. The setAllInRoom() method attempts to locate a room location using the room parameter.

    If it finds such a room then it updates all the SmartDevices in that room to the new switchedOn value.
    */
    public void setAllInRoom(Integer roomSearchParameter, Boolean updatedParameter){
        for(int i = 0; i < arrayOfSmartDeviceObjects.length-1;i++){
            double deviceLocation = arrayOfSmartDeviceObjects[i].location;
            Integer checkInteger = (int)deviceLocation;
            if (checkInteger == roomSearchParameter){
                arrayOfSmartDeviceObjects[i].switchedOn = updatedParameter;
            }
        }
    }

    /*
    Design and write a shutdown() method.
    This method changes all the switchedOn values of all SmartDevices in the SmartHome array to false
        (i.e. switches them all off).
        (Please note that you will have to override this behaviour if you design and write the SmartFridge in a later step.)
    */
    public void shutdown(){
        for (int i = 0; i < arrayOfSmartDeviceObjects.length; i++){
            arrayOfSmartDeviceObjects[i].switchedOn = false;
        }
    }

}
