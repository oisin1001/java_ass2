//Java Assignment 2 - Oisin Quinn - 16314071

/*
 *  This file contains the Property class that is inherited by the Apartment, House and Villa classes
 */

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// This is the property class used for each property created
class Property implements Rentable {
	private int registerNumber;
	private String ownerName = "";
	private String address = "";
	private int costPerDay;
	private int seasonsRentalDays;
	private int totalRentalDays = 0;

	// I use an empty constructor so I can create a Property class without any parameters
    Property(){}

    /**
     Constructs a property class with the user's entered variables
     @param enteredRegNum the register number of the property
     @param enteredName the name of the owner
     @param enteredAddress the address of the property
     @param enteredCost the daily cost of the property
     @param enteredDays the total number seasons rental days
     */
    Property(int enteredRegNum, String enteredName, String enteredAddress, int enteredCost, int enteredDays){
		registerNumber = enteredRegNum;
		ownerName = enteredName;
		address = enteredAddress;
		costPerDay = enteredCost;
		seasonsRentalDays = enteredDays;

	}
	
	/**
 	Returns the property register number
	@return the property register number
 	*/
    int getRegNum()
	{
		return registerNumber;
	}
	
	/**
 	Returns the property's owner name
	@return the property's owner name
 	*/
    String getOwnerName()
	{
		return ownerName;
	}
	
	/**
 	Gets the address of the property
	@return the property's address
 	*/
    String getAddress()
	{
		return address;
	}
	
	/**
 	Gets the cost of renting the property for one day
	@return the cost of renting the property for one day
 	*/
    int getCostPerDay()
	{
		return costPerDay;
	}
	
	/**
 	Gets the number of days the property is available for renting
	@return the number of days the property is available for renting
 	*/
    int getSeasonsRentalDays()
	{
		return seasonsRentalDays;
	}
	
	/**
 	Changes the register number for the property
	@param enteredRegNum the new register number
 	*/
    void setRegNum(int enteredRegNum)
	{
		registerNumber = enteredRegNum;
	}
	
	/**
 	Changes the owner's name for the property
	@param enteredName the new owner's name
 	*/
    void setOwnerName(String enteredName)
	{
		ownerName = enteredName;
	}
	
	/**
 	Changes the property's address
	@param enteredAddress the new address
 	*/
    void setAddress(String enteredAddress)
	{
		address = enteredAddress;
	}
	
	/**
 	Changes the cost of renting the property for one day
	@param enteredCost the new cost of renting for one day
 	*/
    void setCostPerDay(int enteredCost)
	{
		costPerDay = enteredCost;
	}
	
	/**
 	Gets the number of days the property is available for renting
	@param enteredDays the new number of days the property is available for renting
 	*/
    void setSeasonsRentalDays(int enteredDays)
	{
		seasonsRentalDays = enteredDays;
	}

	/**
	 * Returns the value for how many days the property was rented for
	 * @return the total number of days the property was rented for
	 */
    int getTotalRentalDays()
	{
		return totalRentalDays;
	}

    /**
     * Sets the new value for rentalDays in the class
     * This is required as its a method from the implemented interface "RentalItem"
     * @param enteredRentalDays the number of days entered in the JFrame
     */
    public void RentalItem(int enteredRentalDays){
        totalRentalDays = enteredRentalDays;
    }


    /**
     * Calculates the total income generated to date
     * @param apartments the arraylist that contains details about the apartments
     * @param houses the arraylist that contains details about the houses
     * @param villas he arraylist that contains details about the villas
     */
    void CalculatePropertyTotalIncome(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas)
    {
        int i;
        double totalIncome = 0.0;

    /* This calculates the income for apartments and adds it to the total */
        for(i = 0; i < 3; i++)
        {
            totalIncome += + apartments.get(i).getTotalRentalDays() * apartments.get(i).getCostPerDay();
        }

    /* This calculates the income for houses  and adds it to the total */
        for(i = 0; i < 3; i++)
        {
            if(houses.get(i).getTotalRentalDays() > 0) {
                totalIncome += (houses.get(i).getTotalRentalDays() * houses.get(i).getCostPerDay()) + houses.get(i).getClearingFees();
            }
        }

    /* This calculates the income for villas and adds it to the total */
        for(i = 0; i < 3; i++)
        {
            totalIncome += villas.get(i).getTotalRentalDays() *  (villas.get(i).getCostPerDay() + villas.get(i).getLuxuryTaxRate() + villas.get(i).getRoomServiceRate());
        }

        // This is tells the user the total income
        JOptionPane.showMessageDialog(null, "Total rental income: " + totalIncome);
    }

    /**
     * This method reads in and parses the information in InputProperty.txt
     * @param apartments the arraylist that contains details about the apartments
     * @param houses the arraylist that contains details about the houses
     * @param villas he arraylist that contains details about the villas
     */
    void readInputPropertyFile(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas)
    {
        String line;
        int regNum = 1;

        // I use try and catch to catch the FileNotFound exception
        try {
            // This is the file location
            FileReader myFile = new FileReader("src/txt/InputProperty.txt");
            Scanner scanFile = new Scanner(myFile);

            // This while loop cycles through each line of the file
            while(scanFile.hasNextLine()){
                line = scanFile.nextLine();

                // I create a new scanner to go through each word
                Scanner getWords = new Scanner(line);
                // The first int is related to which kind of property it is
                int PropertyType = getWords.nextInt();

                // If it's an apartment, this if statement runs and fills in the arraylist with the appropriate info
                if (PropertyType == 1) {
                    int StoreyNumber = getWords.nextInt();
                    int BedsNumber= getWords.nextInt();
                    int RentalCostPerDay= getWords.nextInt();
                    int TotalRentalDays= getWords.nextInt();
                    String Owner= getWords.next();
                    String PostalAddress= getWords.next();
                    // I increment the register number by one each time, so it's unique for each property
                    apartments.add(new Apartment(regNum++, Owner, PostalAddress, RentalCostPerDay, TotalRentalDays, StoreyNumber, BedsNumber ));
                    // If it's a house, this if statement runs and fills in the arraylist with the appropriate info
                } else if (PropertyType == 2) {
                    int numberOfStories = getWords.nextInt();
                    int clearingFees= getWords.nextInt();
                    int RentalCostPerDay= getWords.nextInt();
                    int TotalRentalDays= getWords.nextInt();
                    String Owner= getWords.next();
                    String PostalAddress= getWords.next();
                    houses.add(new House(regNum++, Owner, PostalAddress, RentalCostPerDay, TotalRentalDays, numberOfStories, clearingFees));
                } else if (PropertyType == 3) {
                    // If it's a villa, this if statement runs and fills in the arraylist with the appropriate info
                    int numberOfStories = getWords.nextInt();
                    int roomServiceRate = getWords.nextInt();
                    int luxuryTaxRate = getWords.nextInt();
                    int RentalCostPerDay = getWords.nextInt();
                    int TotalRentalDays = getWords.nextInt();
                    String Owner= getWords.next();
                    String PostalAddress= getWords.next();
                    villas.add(new Villa(regNum++, Owner, PostalAddress, RentalCostPerDay, TotalRentalDays, roomServiceRate, luxuryTaxRate));
                }
            }
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error reading in file");
        }
    }

    /**
     * This method prints all of the properties to OutputProperty.txt
     * @param apartments the arraylist that contains details about the apartments
     * @param houses the arraylist that contains details about the houses
     * @param villas he arraylist that contains details about the villas
     * @throws FileNotFoundException This exception is thrown if OutputProperty.txt can not be created or changed
     */
    void PrintAllProperties(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas)
            throws FileNotFoundException {

        // This is the location of the output file
        File fileName = new File("src/txt/OutputProperty.txt");

        // This is used to write to the file
        PrintWriter pw = new PrintWriter(fileName);

        int i;

        // These will print the contents of the arraylists to the output file
        pw.println("=============== All Apartments ============");
        for(i=0;i<3;i++) {
            pw.println("Apartment " + (i+1) + ":\n" + "Register Number: "
                    + apartments.get(i).getRegNum() + "\nOwner name: " + apartments.get(i).getOwnerName() + "\nAddress: "
                    + apartments.get(i).getAddress() + "\nCost per day: " + apartments.get(i).getCostPerDay() +
                    "\nNumber of season's rental days: " + apartments.get(i).getSeasonsRentalDays() + "\nTotal rental days: "
                    + apartments.get(i).getTotalRentalDays() + "\nStorey number: " + apartments.get(i).getStoreyNumber()
                    + "\nNumber of beds: " + apartments.get(i).getNumberOfBeds() + "\n");
        }

        pw.println("=============== All Houses ============");
        for(i=0;i<3;i++) {
            pw.println("House " + (i+1) + ":\n" + "Register Number: " +
                    houses.get(i).getRegNum() + "\nOwner name: " + houses.get(i).getOwnerName() + "\nAddress: " +
                    houses.get(i).getAddress() + "\nCost per day: " + houses.get(i).getCostPerDay() +
                    "\nNumber of season's rental days: " + houses.get(i).getSeasonsRentalDays() + "\nTotal rental days: " +
                    houses.get(i).getTotalRentalDays() + "\nNumber of stories: " + houses.get(i).getNumOfStories() +
                    "\nClearing fees: " + houses.get(i).getClearingFees() + "\n");
        }

        pw.println("=============== All Villas ============");
        for(i=0;i<3;i++) {
            pw.println("Villa " + (i+1) + ":\n" + "Register Number: "
                    + villas.get(i).getRegNum() + "\nOwner name: " + villas.get(i).getOwnerName() + "\nAddress: " +
                    villas.get(i).getAddress() + "\nCost per day: " + villas.get(i).getCostPerDay() +
                    "\nNumber of season's rental days: " + villas.get(i).getSeasonsRentalDays() + "\nTotal rental days: " +
                    villas.get(i).getTotalRentalDays() + "\nRoom service cost per day: " +
                    villas.get(i).getRoomServiceRate() + "\nLuxury tax per day: " + villas.get(i).getLuxuryTaxRate() + "\n");
        }

        pw.close();
    }
}