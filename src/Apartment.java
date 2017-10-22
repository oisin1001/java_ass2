//Java Assignment 1 - Oisin Quinn - 16314071

/*
 *  This file contains the Apartment class for creating apartments for the system
 */

/* The class extends the Property class - so it inherits the methods and variables of that class */
class Apartment extends Property {
	/* These are the class-specific variables that are part of the Apartment class */
	private int storeyNumber;
	private int numberOfBeds;
	
	/**
	 * Constructs a apartment class with the user's entered variables
	 * @param enteredRegNum the register number of the property
	 * @param enteredName the name of the owner
	 * @param enteredAddress the address of the property
	 * @param enteredCost the daily cost of the property
	 * @param enteredDays the total number seasons rental days 
	 * @param enteredStorey the storey the apartment is located on
	 * @param enteredBeds the number of beds in the apartment
	 */
	 Apartment(int enteredRegNum, String enteredName, String enteredAddress, int enteredCost, int enteredDays, int enteredStorey, int enteredBeds) {
		/* This line inherits the constructor from the Property class */
		super(enteredRegNum, enteredName, enteredAddress, enteredCost, enteredDays);
		storeyNumber = enteredStorey;
		numberOfBeds = enteredBeds;
	}
	/**
	 * This method returns the storey the apartment is located on
	 * @return the storey the apartment is located on
	 */
	 int getStoreyNumber()
	{
		return storeyNumber;
	}
	
	/**
	 * This method returns the number of beds in the apartment
	 * @return the number of bed in the apartment
	 */
	 int getNumberOfBeds()
	{
		return numberOfBeds;
	}
	
	 /**
	 * This method returns the storey the apartment is located on
	 * @param enteredStorey the new storey number
	 */
	 void setStoreyNumber(int enteredStorey)
	{
		storeyNumber = enteredStorey;
	}
	
	/**
	 * This method returns the number of beds in the apartment
	 * @param enteredNumBeds the new number of beds
	 */
	 void setNumberOfBeds(int enteredNumBeds)
	{
		numberOfBeds = enteredNumBeds;
	}
}