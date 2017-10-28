//Java Assignment 1 - Oisin Quinn - 16314071

/*
 *  This file contains the Property class that is inherited by the Apartment, House and Villa classes
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Property implements RentalItem {
	private int registerNumber;
	private String ownerName = "";
	private String address = "";
	private int costPerDay;
	private int seasonsRentalDays;
	private int totalRentalDays = 0;

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
		/* Here I rent each property three times */

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
	Records that the property has been rented for a certain number of days
	@param rentalDays the number of days the property has been rented for
 	*/

	/**
	 * Returns the value for how many days the property was rented for
	 * @return the total number of days the property was rented for
	 */
    int getTotalRentalDays()
	{
		return totalRentalDays;
	}

    void setTotalRentalDays(int enteredRentalDays)
    {
        totalRentalDays = enteredRentalDays;
    }

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

    void readInputPropertyFile(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas)
    {
        String line;
        int regNum = 1;

        try {
            FileReader myFile = new FileReader("src/txt/InputProperty.txt");
            Scanner scanFile = new Scanner(myFile);
            while(scanFile.hasNextLine()){
                line = scanFile.nextLine();

                Scanner getWords = new Scanner(line);
                int PropertyType = getWords.nextInt();
                if (PropertyType == 1) {
                    int StoreyNumber = getWords.nextInt();
                    int BedsNumber= getWords.nextInt();
                    int RentalCostPerDay= getWords.nextInt();
                    int TotalRentalDays= getWords.nextInt();
                    String Owner= getWords.next();
                    String PostalAddress= getWords.next();
                    apartments.add(new Apartment(regNum++, Owner, PostalAddress, RentalCostPerDay, TotalRentalDays, StoreyNumber, BedsNumber ));
                } else if (PropertyType == 2) {
                    int numberOfStories = getWords.nextInt();
                    int clearingFees= getWords.nextInt();
                    int RentalCostPerDay= getWords.nextInt();
                    int TotalRentalDays= getWords.nextInt();
                    String Owner= getWords.next();
                    String PostalAddress= getWords.next();
                    houses.add(new House(regNum++, Owner, PostalAddress, RentalCostPerDay, TotalRentalDays, numberOfStories, clearingFees));
                } else if (PropertyType == 3) {
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
            System.out.println("exception "+ex.getMessage()+" caught");
        }
    }

    void PrintAllProperties(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas)
            throws FileNotFoundException {

        File fileName = new File("src/txt/OutputProperty.txt");

        PrintWriter pw = new PrintWriter(fileName);

        int i;

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
