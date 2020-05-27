package com.company;

import java.util.Scanner;

public class Step4 {
    public static void main(String[] args){

        //STEP 1 - Create SmartHome object - using the first constructor from step 2.
        //Step 1.a - Using console input, allow the user to specify the number of smart devices (size) to be held in a SmartHome object.
        //Step 1.b - Create a SmartHome object using the size value given by the user.
        printString("STEP 1.A");
        printString("STEP 1.B");


        SmartHome smartHome = new SmartHome(
                    safeInputInteger(
                            "Please enter how many devices you would like to have: ",
                              "There was an error with your input, ensure that your input is a positive, whole number")
        );


        //Step 1.c - Using insertDevice(), populate the SmartHome object using a loop and user input for each value with a mixture of SmartDevice and SmartFridge objects.
        printString("STEP 1.C");

        for (int i = 1; i <= smartHome.arrayOfSmartDeviceObjects.length; i++) {
            if (i % 2==0) {
                printString("SmartFridge here");

                SmartFridge fridge = new SmartFridge(
                        safeInputString("Please enter the name of the fridge you would like to create: "),
                        safeInputDouble("Please the value representing the location of the device: ",
                                "There was an error - enter the value in format room.socket number."),
                        safeInputDouble("Please the value representing the temperature of the device: ",
                                "There was an error - enter a decimal number representing temperature.")
                );
                smartHome.insertDevice(fridge);

            } else {
                printString("SmartDevice here");

                SmartDevice device = SmartDevice.createSmartDevice(
                        safeInputString(
                                "Please enter the name of the device"),
                        safeInputDouble(
                                "Please the value representing the location of the device: ",
                                "There was an error - enter the value in format room.socket number."),
                        safeInputBoolean("Please enter the power state of the device",
                                "There was an error with your input - ensure you enter either true or false.")
                );
                smartHome.insertDevice(device);
            }
        }



        //Step 1.d - Verify that the SmartHome is correctly populated using the SmartHome object’s toString() method.
        printString("STEP 1.D");
        printString(smartHome.toString());



        //STEP 2 - Create SmartHome object - using the second constructor.
        //Step 2.a - Using console input, allow the user to specify the number of items to be held in an array.
        // Create an array in  main(). Populate each item in the array using a loop and user input for each value with a mixture of SmartDevice and SmartFridge objects.
        printString("STEP 2.A");
        SmartDevice[] arrayOfSmartDevices = new SmartDevice[safeInputInteger(
                "Please enter how many devices you would like to have: ",
                "There was an error with your input, ensure that your input is a positive, whole number")];

        for (int i = 1; i <= arrayOfSmartDevices.length; i++) {
            if (i % 2==0) {
                printString("SmartFridge here");

                SmartFridge fridge = new SmartFridge(
                        safeInputString("Please enter the name of the fridge you would like to create: "),
                        safeInputDouble("Please the value representing the location of the device: ",
                                "There was an error - enter the value in format room.socket number."),
                        safeInputDouble("Please the value representing the temperature of the device: ",
                                "There was an error - enter a decimal number representing temperature.")
                );
                arrayOfSmartDevices[i-1] = fridge;
            } else {
                printString("SmartDevice here");

                SmartDevice device = SmartDevice.createSmartDevice(
                        safeInputString(
                                "Please enter the name of the device"),
                        safeInputDouble(
                                "Please the value representing the location of the device: ",
                                "There was an error - enter the value in format room.socket number."),
                        safeInputBoolean("Please enter the power state of the device",
                                "There was an error with your input - ensure you enter either true or false.")
                );
                arrayOfSmartDevices[i-1] = device;
            }
        }

        //Step 2.b - Create a SmartHome object using the populated array.
        printString("STEP 2.B");
        smartHome = new SmartHome(arrayOfSmartDevices);

        //Step 2.c - Verify that the SmartHome object is correctly populated using the SmartHome object’s toString() method.
        printString("STEP 2.C");
        printString(smartHome.toString());


        //STEP 3 - Using the shutdown() method, attempt to switch off a fridge.
        printString("Skipping Part 3");
        //Step 3.a - Using the SmartHome shutdown() method, attempt to shut all devices down.
        //printString("STEP 3.A");

        //Step 3.b - Verify that the SmartFridge(s) remain(s) switched on using the SmartHome object’s toString() method.
        //printString("STEP 3.B");
        //printString(smartHome.toString()); //SmartHome.toString(smartHome);


        //STEP 4 - Increment and decrement temperature.

        //Step 4.a - For a selected fridge (use an approriate index and the getDevice() method), increment the temperature.
        //Verify that the current temperature has been updated using the SmartHome object’s toString() method.
        printString("STEP 4.A");
        SmartFridge.increment((SmartFridge) smartHome.arrayOfSmartDeviceObjects[1]);
        printString(smartHome.toString()); //printString(smartHome.toString()); //SmartHome.toString(smartHome);


        //Step 4.b - For the selected fridge decrement the temperature.
        //Verify that the current temperature has been updated using the SmartHome object toString() method.
        printString("STEP 4.B");
        SmartFridge.decrement((SmartFridge) smartHome.arrayOfSmartDeviceObjects[1]);


        printString(smartHome.toString()); //SmartHome.toString(smartHome);



    }

    public static String safeInputString(String requestString){
        Scanner safeInput = new Scanner(System.in);

        printString(requestString);

        return safeInput.nextLine();

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

    public static void printString(String stringToPrint){  System.out.println(stringToPrint.toString());  }

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

}
