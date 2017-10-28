//Java Assignment 2 - Oisin Quinn - 16314071

/*
 *  This file contains the Vehicles class that is inherited by the Car and Truck classes
 */

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// This is the vehicle class used for each vehicle created
public class Vehicle implements Rentable {
    private int regNum;
    private String ownerName = "";
    private int costPerDay;
    private int totalRentalDays = 0;

    // I use an empty constructor so I can create a Vehicle class without any parameters
    Vehicle(){
    }

    /**
     * Constructs a vehicle class with the user's entered variables
     * @param enteredRegNum the register number of the vehicle
     * @param enteredName the name of the person renting the vehicle
     * @param enteredCost the cost of the vehicle per day
     */
    Vehicle(int enteredRegNum, String enteredName, int enteredCost){
        regNum = enteredRegNum;
        ownerName = enteredName;
        costPerDay = enteredCost;
        totalRentalDays = 0;
    }

    /**
     Returns the vehicle owner's name
     @return the vehicle owner's name
     */
    String getOwnerName()
    {
        return ownerName;
    }

    /**
     Gets the cost of renting the vehicle for one day
     @return the cost of renting the vehicle for one day
     */
    int getCostPerDay()
    {
        return costPerDay;
    }

    /**
     * Returns the value for how many days the vehicle was rented for
     * @return the total number of days the vehicle was rented for
     */
    int getTotalRentalDays()
    {
        return totalRentalDays;
    }

    /**
     Changes the owner's name for the vehicle
     @param enteredName the new owner's name
     */
    void setOwnerName(String enteredName)
    {
        ownerName = enteredName;
    }

    /**
     Changes the cost of renting the vehicle for one day
     @param enteredCost the new cost of renting for one day
     */
    void setCostPerDay(int enteredCost)
    {
        costPerDay = enteredCost;
    }

    /**
     * Returns the value the register number of the vehicle
     * @return the register number
     */
    int getRegNum()
    {
        return regNum;
    }

    /**
     Changes the owner's name for the vehicle
     @param enteredRegNum the new owner's name
     */
    void setRegNum(int enteredRegNum)
    {
        regNum = enteredRegNum;
    }


    /**
     * Sets the new value for rentalDays in the class
     * This is required as its a method from the implemented interface "RentalItem"
     * @param enteredRentalDays the number of days entered in the JFrame
     */
    public void RentalItem(int enteredRentalDays){
        totalRentalDays = enteredRentalDays - 1;
    }

    /**
     * This method reads in and parses the information in InputVehicles.txt
     * @param cars the arraylist that contains details about the cars
     * @param trucks the arraylist that contains details about the trucks
     */
    void readInputVehicleFile(ArrayList<Car> cars, ArrayList<Truck> trucks)
    {
        String line;
        int regNum = 1;

        // I use try and catch to catch the FileNotFound exception
        try {
            // This is the file location
            FileReader myFile = new FileReader("src/txt/InputVehicles.txt");
            Scanner scanFile = new Scanner(myFile);

            // This while loop cycles through each line of the file
            while(scanFile.hasNextLine()){
                line = scanFile.nextLine();

                // I create a new scanner to go through each word
                Scanner getWords = new Scanner(line);
                // The first int is related to which kind of vehicle it is
                int VehicleType = getWords.nextInt();

                // If it's a car, this if statement runs and fills in the arraylist with the appropriate info
                if (VehicleType == 1) {
                    int RentalCostPerDay= getWords.nextInt();
                    int passengerNumber= getWords.nextInt();
                    String Owner= getWords.next();
                    // I increment the register number by one each time, so it's unique for each vehicle
                    cars.add(new Car(regNum++, Owner, RentalCostPerDay, passengerNumber));
                    // If it's a vehicle, this if statement runs and fills in the arraylist with the appropriate info
                } else if (VehicleType == 2) {
                    int RentalCostPerDay= getWords.nextInt();
                    int cargoWeight= getWords.nextInt();
                    String Owner= getWords.next();
                    trucks.add(new Truck(regNum++, Owner, RentalCostPerDay, cargoWeight));
                }
            }
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error reading in file");
        }
    }

    /**
     * Calculates the total income generated to date
     * @param cars the arraylist that contains details about the cars
     * @param trucks the arraylist that contains details about the trucks
     */
    void CalculateVehicleTotalIncome(ArrayList<Car> cars, ArrayList<Truck> trucks) {
        int i;
        double totalIncome = 0.0;

		/* This calculates the income for apartments and adds it to the total */
        for (i = 0; i < cars.size(); i++) {
            totalIncome = totalIncome + cars.get(i).getTotalRentalDays() * cars.get(i).getCostPerDay();
        }

		/* This calculates the income for houses  and adds it to the total */
        for (i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getTotalRentalDays() > 0) {
                totalIncome += (trucks.get(i).getTotalRentalDays() * trucks.get(i).getCostPerDay()) + trucks.get(i).getCargoWeight();
            }
        }

        // This is tells the user the total income
        JOptionPane.showMessageDialog(null, "Total rental income: " + totalIncome);
    }

    /**
     * This method prints off all of the vehicle details
     * @param cars the arraylist that contains details about the cars
     * @param trucks the arraylist that contains details about the trucks
     */
    void PrintAllVehicles(ArrayList<Car> cars, ArrayList<Truck> trucks) throws FileNotFoundException {

        // This is the location of the output file
        File fileName = new File("src/txt/OutputVehicles.txt");

        // This is used to write to the file
        PrintWriter pw = new PrintWriter(fileName);

        int i;
        // This is the content of the output file
        pw.println("=============== All Cars ============");
        for(i=0;i<3;i++) {
            pw.println("Car " + (i+1) + ":\n" + "Register Number: "
                    + cars.get(i).getRegNum() + "\nOwner name: " + cars.get(i).getOwnerName() + "\nCost per day: " +
                    cars.get(i).getCostPerDay() + "\nTotal rental days: " + cars.get(i).getTotalRentalDays() +
                    "\nNumber of passengers: " + cars.get(i).getPassengersNumber() + "\n");
        }

        pw.println("=============== All Trucks ============");
        for(i=0;i<3;i++) {
            pw.println("Truck " + (i+1) + ":\n" + "Register Number: "
                    + trucks.get(i).getRegNum() + "\nOwner name: " + trucks.get(i).getOwnerName() + "\nCost per day: " +
                    trucks.get(i).getCostPerDay() + "\nTotal rental days: " + trucks.get(i).getTotalRentalDays() +
                    "\nCargo weight: " + trucks.get(i).getCargoWeight() + "\n");
        }

        // I close the PrintWriter at the end
        pw.close();
    }
}
