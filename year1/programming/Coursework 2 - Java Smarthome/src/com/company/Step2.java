package com.company;

import java.util.Scanner;

public class Step2 {
    public static void main(String[] args){

    //Step 1.a - Using console input, ask the user to specify the number of smart devices (size) to be held in the SmartHome object.
    //Step 1.b - Create a SmartHome object using the size value given by the user.
        printString("STEP 1.A");
        printString("STEP 1.B");

    SmartHome smartHome = new SmartHome(
            safeInputInteger(
                    "Please enter how many devices you would like to have: ",
                      "There was an error with your input, ensure that your input is a positive, whole number")
    );

    //Step 1.c - Populate the SmartHome object with Smart devices using a loop, user inputs for each new SmartDevice, and the insertDevice() method
        printString("STEP 1.C");
    for (int i = 0; i < smartHome.arrayOfSmartDeviceObjects.length; i++){
        smartHome.insertDevice(
                safeInputString(
                        "Please enter the name of the device"),
                safeInputDouble(
                        "Please the value representing the location of the device: ",
                          "There was an error - enter the value in format room.socket number."),
                safeInputBoolean("Please enter the power state of the device",
                                 "There was an error with your input - ensure you enter either true or false.")
        );
    }

    //Step 1.d - Verify that the SmartHome is correctly populated using the SmartHome object toString() method.
        printString("STEP 1.D");
        printString(smartHome.toString()); //SmartHome.toString(smartHome);

    //STEP 2 - Create SmartHome object - using the second constructor.
    //Step 2.a - Using console input, ask the user to specify the number of items to be held in an array of SmartDevices.
    // Create the array in main(). Populate each item in the array using a loop and user input for each new SmartDevice object.
        printString("STEP 2.A");

    SmartDevice[] smartDeviceArray = new SmartDevice[safeInputInteger(
                "Please enter how many devices you would like to have: ",
                "There was an error with your input, ensure that your input is a positive, whole number")
                ];

    for (int i = 0; i < smartDeviceArray.length; i++){
        newLinePrint(2);
        printDivider();
        smartDeviceArray[i] = SmartDevice.createSmartDevice(
                safeInputString(
                "Please enter the name of the device"),
                safeInputDouble(
                        "Please the value representing the location of the device: ",
                        "There was an error - enter the value in format room.socket number."),
                safeInputBoolean("Please enter the power state of the device",
                        "There was an error with your input - ensure you enter either true or false.")
        );
    }

    //Step 2.b - Create a SmartHome object using the populated array.
        printString("STEP 2.B");
        smartHome = new SmartHome(smartDeviceArray);

    //Step 2.c - Verify that the SmartHome object is correctly populated using the SmartHome object toString() method
        printString("STEP 2.C");
        smartHome.toString();


    //Step 3.a - Ask the user for an index, and using the getDevice() method, return the specific SmartDevice at that index to the main().
        printString("STEP 3.A");

        Integer deviceAccessIndex = safeInputInteger("Please enter the index of the device you would like to access: ",
                                                "There was an error - Enter an integer, remember that device one is referred to as index 0, and so on.");


    //Step 3.b - Execute a switchOn() or switchOff() operation on this SmartDevice to change the switchedOn value (from true to false, or from false to true).
        printString("STEP 3.B");
        if (smartHome.getDevice(deviceAccessIndex).switchedOn == true){
            SmartDevice.switchOff(smartHome.getDevice(deviceAccessIndex));
        }
        else{
            SmartDevice.switchOn(smartHome.getDevice(deviceAccessIndex));
        }

    //Step 3.c - Verify the values are updated using the SmartHome object’s toString() method.
        printString("STEP 3.C");

        //smartHome.getDevice(deviceAccessIndex).toString(smartHome.getDevice(deviceAccessIndex));
        printString(smartHome.toString());


    //Step 4.a - Ask the user for a location and using the getDevice() method, return the specific SmartDevice at that location to the main().
        printString("STEP 4.A");

        Double deviceAccessLocation = safeInputDouble(
                "Please enter the location of the device you would like to access: ",
                "There was an error - enter the value in format room.socket number.");

        //Step 4.b - Execute a switchOn() or switchOff() operation on this SmartDevice to change the switchedOn value.
        printString("STEP 4.B");

        if (smartHome.getDevice(deviceAccessLocation).switchedOn){
            smartHome.getDevice(deviceAccessLocation).switchedOn = false;
        } else {
            smartHome.getDevice(deviceAccessLocation).switchedOn = true;
        }


    //Step 4.c - Verify this using the SmartHome object’s toString() method.
        printString("STEP 4.C");
        printString(smartHome.toString());

        //SmartDevice.toString(fetchedDevice);



    //Step 5.a - Ask the user for a location and using the toggle() method, update the specific SmartDevice at that location to the main().
        printString("STEP 5.A");

        smartHome.toggle(
                safeInputDouble(
                        "Please enter a location value for the device you would like to toggle: ",
                        "There was a problem with your input. Ensure it is a location in form room.socket."));

    //Step 5.b - Verify this using the SmartHome object’s toString() method.
        printString("STEP 5.B");
        printString(smartHome.toString()); //SmartHome.toString(smartHome);




    }



    /*
    These are the functions that print text to the screen
    */

    public static void printString(String stringToPrint){  System.out.println(stringToPrint.toString());  }

    public static void newLinePrint(Integer numberOfNewLines){
        for (int i = 0; i < numberOfNewLines; i++) {  System.out.println();  }
    }

    public static void printDivider(){  printString("----------");  }

    /*
    These are the functions that get user input
    I wanted to easily verify the user's inputs, ensuring that the program would run properly
    safeInputString does not have an error output parameter because it is safe already - having that is a waste of memory.
    */

    public static String safeInputString(String requestString){
        Scanner safeInput = new Scanner(System.in);

        printString(requestString);

        return safeInput.nextLine();

    }

    public static Double safeInputDouble(String requestString, String errorString){
        Scanner safeInput = new Scanner(System.in);

        printString(requestString);

        /*
        I check the contents of the scanner before it passes it's value to the double variable.
        I then check the scanner to make sure that the variable is a double - if it isn't I ask for the user to re-input a value.
        This will loop until a value that meets the requirements is entered.
        */
        while(!safeInput.hasNextDouble()){
            printString(errorString);
            safeInput.next();
        }
        return safeInput.nextDouble();
    }

    public static Boolean safeInputBoolean(String requestString, String errorString){
        Scanner safeInput = new Scanner(System.in);

        printString(requestString);

        while(!safeInput.hasNextBoolean()){
            printString(errorString);
            safeInput.next();
        }
        return safeInput.nextBoolean();
    }

    public static Integer safeInputInteger(String requestString, String errorString){
        Scanner safeInput = new Scanner(System.in);

        printString(requestString);

        while(!safeInput.hasNextInt()){
            printString(errorString);
            safeInput.next();
        }
        return safeInput.nextInt();
    }



}
