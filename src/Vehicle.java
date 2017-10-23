import javax.swing.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Vehicle implements RentalItem {

    private int regNum;
    private String ownerName = "";
    private int costPerDay;
    private int totalRentalDays = 0;

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


    public void RentalItem(int enteredRentalDays){
        totalRentalDays = enteredRentalDays - 1;
    }

    /**
     * Calculates the total income generated to date
     *
     * @param apartments the arraylist that contains details about the apartments
     * @param houses     the arraylist that contains details about the houses
     * @param villas     he arraylist that contains details about the villas
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

}
