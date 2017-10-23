

//Java Assignment 1 - Oisin Quinn - 16314071

import java.util.ArrayList;
import javax.swing.JOptionPane;

/* This class is used to calculate the total income of the system */
class CalculateVehicleTotalIncome {

    /* This is an empty constructor for the class */
    CalculateVehicleTotalIncome() {

    }

    /**
     * Calculates the total income generated to date
     *
     * @param apartments the arraylist that contains details about the apartments
     * @param houses     the arraylist that contains details about the houses
     * @param villas     he arraylist that contains details about the villas
     */
    void CalculateVehicleTotalIncomeAmount(ArrayList<Car> cars, ArrayList<Truck> trucks) {
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
