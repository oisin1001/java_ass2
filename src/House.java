//Java Assignment 2 - Oisin Quinn - 16314071

/*
 *  This file contains the House class for creating houses for the system
 */

/* The class extends the Property class - so it inherits the methods and variables of that class */
class House extends Property {
	/* These are the class-specific variables that are not part of the Property class */
	private int numOfStories;
	private int clearingFees;
	
	/**
	* Constructs a property class with the user's entered variables
	* @param enteredRegNum the register number of the property
	* @param enteredName the name of the owner
	* @param enteredAddress the address of the property
	* @param enteredCost the daily cost of the property
	* @param enteredDays the total number seasons rental days 
	* @param enteredNumOfStories the number of stories in the house
	* @param enteredClearingFees the clearing fees
	*/
    House(int enteredRegNum, String enteredName, String enteredAddress, int enteredCost, int enteredDays, int enteredNumOfStories, int enteredClearingFees) {
		/* This line inherits the constructor from the Property class */
		super(enteredRegNum, enteredName, enteredAddress, enteredCost, enteredDays);
		numOfStories = enteredNumOfStories;
		clearingFees = enteredClearingFees;
	}
	
	/**
	 * This method returns the number of stories in the house
	 * @return the number of stories in the house
	 */
    int getNumOfStories()
	{
		return numOfStories;
	}
	
	/**
	 * This method returns the clearing fees for the house
	 * @return the clearing fees for the house
	 */
    int getClearingFees()
	{
		return clearingFees;
	}
	
	/**
	 * This method changes the number of stories in the apartment
	 * @param enteredNumOfStories the new number of stories
	 */
    void setNumOfStories(int enteredNumOfStories)
	{
		numOfStories = enteredNumOfStories;
	}
	
	/**
	 * This method changes the clearing fees
	 * @param enteredClearingFees the new clearing fees
	 */
    void setClearingFees(int enteredClearingFees)
	{
		clearingFees = enteredClearingFees;
	}
}