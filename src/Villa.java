//Java Assignment 2 - Oisin Quinn - 16314071

/*
 *  This file contains the Villa class for creating villas for the system
 */

/* The class extends the Property class - so it inherits the methods and variables of that class */
class Villa extends Property {
	/* These are the class-specific variables that are not part of the Property class */
	private int roomServiceRate;
	private int luxuryTaxRate;
	
	/**
	 * Constructs a villa class with the user's entered variables
	 * @param enteredRegNum the register number of the property
	 * @param enteredName the name of the owner
	 * @param enteredAddress the address of the property
	 * @param enteredCost the daily cost of the property
	 * @param enteredDays the total number seasons rental days
	 * @param enteredRoomServiceRate the cost of room service per day
	 * @param enteredLuxuryTaxRate the luxury tax per day
	 */
	Villa (int enteredRegNum, String enteredName, String enteredAddress, int enteredCost, int enteredDays, int enteredRoomServiceRate, int enteredLuxuryTaxRate) {
		/* This line inherits the constructor from the Property class */
		super(enteredRegNum, enteredName, enteredAddress, enteredCost, enteredDays);
		roomServiceRate = enteredRoomServiceRate;
		luxuryTaxRate = enteredLuxuryTaxRate;
	}
	
	/**
	 * This method returns the cost of room service per day
	 * @return the cost of room service per day
	 */
    int getRoomServiceRate()
	{
		return roomServiceRate;
	}
	
	/**
	 * This method returns the luxury tax per day
	 * @return the cost of luxury tax per day
	 */
    int getLuxuryTaxRate()
	{
		return luxuryTaxRate;
	}
	
	/**
	 * This method changes the cost of room service per day
	 * @param enteredRoomServiceRate the new cost of room service per day
	 */
    void setRoomServiceRate(int enteredRoomServiceRate)
	{
		roomServiceRate = enteredRoomServiceRate;
	}
	
	/**
	 * This method changes the luxury tax cost per day
	 * @param enteredLuxuryTaxRate the new daily luxury tax cost
	 */
    void setLuxuryTaxRate(int enteredLuxuryTaxRate)
	{
		luxuryTaxRate = enteredLuxuryTaxRate;
	}
}