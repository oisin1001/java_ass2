//Java Assignment 1 - Oisin Quinn - 16314071

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

class PrintAllProperties {
	/* This is an empty constructor for the class */
	PrintAllProperties(){}

	/**
	 * This method prints off all of the property details
	 * @param apartments the arraylist that contains details about the apartments
	 * @param houses the arraylist that contains details about the houses
	 * @param villas he arraylist that contains details about the villas
	 */
    void PrintAllPropertiesMethod(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas)
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
