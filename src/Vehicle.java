import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Vehicle implements RentalItem {

    private int regNum;
    private String ownerName = "";
    private int costPerDay;
    private int totalRentalDays = 0;

    Vehicle(){
    }

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

    void readInputVehicleFile(ArrayList<Car> cars, ArrayList<Truck> trucks)
    {
        String line;
        int regNum = 1;

        try {
            FileReader myFile = new FileReader("src/txt/InputVehicles.txt");
            Scanner scanFile = new Scanner(myFile);
            while(scanFile.hasNextLine()){
                line = scanFile.nextLine();

                Scanner getWords = new Scanner(line);
                int VehicleType = getWords.nextInt();
                if (VehicleType == 1) {
                    int RentalCostPerDay= getWords.nextInt();
                    int passengerNumber= getWords.nextInt();
                    String Owner= getWords.next();
                    cars.add(new Car(regNum++, Owner, RentalCostPerDay, passengerNumber));
                } else if (VehicleType == 2) {
                    int RentalCostPerDay= getWords.nextInt();
                    int cargoWeight= getWords.nextInt();
                    String Owner= getWords.next();
                    trucks.add(new Truck(regNum++, Owner, RentalCostPerDay, cargoWeight));
                }
            }
        }
        catch(Exception ex) {
            System.out.println("exception "+ex.getMessage()+" caught");
        }
    }

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

    /**
     * This method prints off all of the property details
     * @param cars the arraylist that contains details about the cars
     * @param trucks the arraylist that contains details about the trucks
     */
    void PrintAllVehicles(ArrayList<Car> cars, ArrayList<Truck> trucks)
            throws FileNotFoundException {

        File fileName = new File("src/txt/OutputVehicles.txt");

        PrintWriter pw = new PrintWriter(fileName);

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
