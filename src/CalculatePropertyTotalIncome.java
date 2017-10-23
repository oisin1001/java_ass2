//Java Assignment 1 - Oisin Quinn - 16314071

import java.util.ArrayList;
import javax.swing.JOptionPane;

/* This class is used to calculate the total income of the system */
class CalculatePropertyTotalIncome {

    /* This is an empty constructor for the class */
    CalculatePropertyTotalIncome(){

    }

    /**
     * Calculates the total income generated to date
     * @param apartments the arraylist that contains details about the apartments
     * @param houses the arraylist that contains details about the houses
     * @param villas he arraylist that contains details about the villas
     */
    void CalculatePropertyTotalIncomeAmount(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas)
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
}