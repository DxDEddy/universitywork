package com.company;

import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {

        //STEP 1 - Create Object

        //Step 1.a - Create a SmartDevice object with suitable parameter values.
        printString("STEP 1.A");

        SmartDevice userCreatedSmartDevice = SmartDevice.createSmartDevice("exampleSmartDevice1",1.1,false);

        //Step 1.b - Use the toString() method to display the object’s data.
        printString("STEP 1.B");

        printDivider();
        printString(userCreatedSmartDevice.toString());


        //STEP 2 - Create an array of SmartDevices in the main() method

        //Step 2.a - Using console input, allow the user to specify the number of Smart Devices to store in an array.
        //      Create an array with the given size in main().
        //      Populate each element of the array using a loop and user input for each value.
        //      Test that the array is populated correctly by using a loop combined with the toString()
        //      method to display the details of all the SmartDevices.

        printString("STEP 2.A");

        SmartDevice[] smartDeviceArray = new SmartDevice[
                safeInputInteger(
                "Please enter how many devices you would like to add: ",
                  "Please enter an integer that represents how many devices you would like to create.")];

        for (int i = 0; i < smartDeviceArray.length; i++) {
            newLinePrint(1);
            printDivider();
            smartDeviceArray[i] = SmartDevice.createSmartDevice(
                    safeInputString("Please enter the name of the device"),
                    safeInputDouble("Please enter the location of the device: ","There was an error with your input, ensure you entered a decimal with format RoomNumber.SocketNumber. "),
                    safeInputBoolean("Please enter the power state of the device: ","There was an error with your input - ensure you enter either true or false.")
            );
        }

        printString("\nPrinting the devices: \n");
        for (int i = 0; i < smartDeviceArray.length; i++) {
            Integer deviceNumber = i+1;
            System.out.println("\nDevice: "+deviceNumber);

            printString(smartDeviceArray[i].toString());
        }

        //STEP 3 - Update the switchedOn value for one of the devices in the array
        //Step 3.a - Allow the user to select an item (SmartDevice) from the array by entering an index value.
        //Step 3.b - Execute a switchOn() or switchOff() operation on the selected SmartDevice to
        //change the switchedOn value (from true to false, or from false to true).
        Integer deviceAccessIndex = safeInputInteger(
                "Please enter the array index position of the device you would like to toggle.",
                "There was an error - Enter an integer, remember that device one is referred to as index 0, and so on.");
        if (smartDeviceArray[deviceAccessIndex].switchedOn == true){
            smartDeviceArray[deviceAccessIndex].switchedOn = false; }
        else{
            smartDeviceArray[deviceAccessIndex].switchedOn = true; }


        //Step 3.c - Verify that the update procedure worked correctly by using a loop combined
        //with the SmartDevice toString() method to display details of all the SmartDevices.

        printString("\nPrinting the devices: \n");
        for (int i = 0; i < smartDeviceArray.length; i++) {
            Integer deviceNumber = i+1;
            System.out.println("\nDevice: "+deviceNumber);

            printString(smartDeviceArray[i].toString());
        }


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
