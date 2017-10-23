//Java Assignment 1 - Oisin Quinn - 16314071

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

class PrintAllVehicles {
    /* This is an empty constructor for the class */
    PrintAllVehicles(){}

    /**
     * This method prints off all of the property details
     * @param cars the arraylist that contains details about the cars
     * @param trucks the arraylist that contains details about the trucks
     */
    void PrintAllVehiclesMethod(ArrayList<Car> cars, ArrayList<Truck> trucks)
            throws FileNotFoundException {

        File fileName = new File("src/txt/OutputVehicle.txt");

        PrintWriter pw = new PrintWriter(fileName);

        System.out.println("printy veh stuff");

        int i;

        pw.println("=============== All Cars ============");
        for(i=0;i<3;i++) {
            pw.println("Car " + (i+1) + ":\n" + "Register Number: "
                    + cars.get(i).getRegNum() + "\nOwner name: " + cars.get(i).getOwnerName() + "\nCost per day: " +
                    cars.get(i).getCostPerDay() + "\nTotal rental days: " + cars.get(i).getTotalRentalDays() +
                    "\nNumber of passengers: " + cars.get(i).getPassengersNumber() + "\n");
        }

        // int enteredRegNum, String enteredName, int enteredCost, int enteredDays, int enteredPassengersNumber

        pw.println("=============== All Trucks ============");
        for(i=0;i<3;i++) {
            pw.println("Truck " + (i+1) + ":\n" + "Register Number: "
                    + trucks.get(i).getRegNum() + "\nOwner name: " + trucks.get(i).getOwnerName() + "\nCost per day: " +
                    trucks.get(i).getCostPerDay() + "\nTotal rental days: " + trucks.get(i).getTotalRentalDays() +
                    "\nCargo weight: " + trucks.get(i).getCargoWeight() + "\n");
        }


        pw.close();
    }
}
