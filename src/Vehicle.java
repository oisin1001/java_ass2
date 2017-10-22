public class Vehicle implements RentalItem {

    private String ownerName = "";
    private int costPerDay;
    private int totalRentalDays = 0;

    Vehicle(String enteredName, int enteredCost, int enteredDays){
        ownerName = enteredName;
        costPerDay = enteredCost;
        totalRentalDays = enteredDays;
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


    public void RentalItem(int enteredRentalDays){
        totalRentalDays = enteredRentalDays - 1;
    }
}
