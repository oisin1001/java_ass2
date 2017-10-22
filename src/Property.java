//Java Assignment 1 - Oisin Quinn - 16314071

/*
 *  This file contains the Property class that is inherited by the Apartment, House and Villa classes
 */


class Property implements RentalItem {
	private int registerNumber;
	private String ownerName = "";
	private String address = "";
	private int costPerDay;
	private int seasonsRentalDays;
	private int totalRentalDays = 0;
	
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
	//	RentProperty(10);
	//	RentProperty(5);
	//	RentProperty(3);
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
}