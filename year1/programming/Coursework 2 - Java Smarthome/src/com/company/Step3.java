package com.company;

public class Step3 {
    public static void main(String[] args){

        //STEP 1 - Register a new device
        //Step 1.a - Create a SmartHome object and fully populate it. See Step 2 Test 1 or Step 2 Test 2 for guidance.
        printString("STEP 1.A");

        SmartHome smartHome = new SmartHome(2);

        smartHome.arrayOfSmartDeviceObjects[0] = SmartDevice.createSmartDevice("preMadeDevice1", 1.1, true );
        smartHome.arrayOfSmartDeviceObjects[1] = SmartDevice.createSmartDevice("preMadeDevice2", 1.2, true );

        //Step 1.b - Given the array is now fully populated, create a new SmartDevice and attempt to add it to the SmartHome.
        // This should invoke the addDevice() method and the SmartDevice object should be added,
        // resulting in an increase in the size of the array in the SmartHome object.
        printString("STEP 1.B");

        SmartDevice deviceToInsert = SmartDevice.createSmartDevice("deviceToAdd1",2.1,true);

        smartHome.addDevice(deviceToInsert);


        //Step 1.c - Verify that the additional the object is added and the array is increased using the SmartHome object’s toString() method.

        printString("Step 1.c\n");
        printString(smartHome.toString()); //SmartHome.toString(smartHome);
        printDivider();
        printString("Now toggling all devices in Room 1 to Off");


        //STEP 2 - Room level change

        //Step 2.a - Run setAllInRoom() method for one of the existing rooms  to change all the switchedOn values for the SmartDevices in that room.
        printString("STEP 2.A");

        smartHome.setAllInRoom(1, false);

        //Step 2.b - Verify the changes made using the SmartHome object’s toString() method.
        printString("STEP 2.B");

        printString(smartHome.toString()); //SmartHome.toString(smartHome);
        printDivider();
        printString("Now shutting down all devices");

        //STEP 3 - Shutdown all devices

        //Step 3.a - Run shutdown()
        printString("STEP 3.A");

        smartHome.shutdown();

        //Step 3.b - Verify the changes made using the SmartHome object’s toString() method.
        printString("STEP 3.B");

        printString(smartHome.toString()); //SmartHome.toString(smartHome);
        printDivider();

        /*
        Design and write the following change into the insertDevice() method.
        If the array is fully populated then the method executes (and passes the parameter value to) the addDevice() method.
        */

    }

    public static void printString(String stringToPrint){  System.out.println(stringToPrint.toString());  }

    public static void printDivider(){  printString("----------");  }

}
