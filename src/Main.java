//Java Assignment 1 - Oisin Quinn - 16314071


/*
 *   This class runs the program itself, and calls all of the other methods
 */

/* TO-DO
    IMPLEMENT RENTING FOR VEHICLES
    ADD MORE COMMENTS
    CALCULATE TOTAL RENTAL INCOME FOR VEHICLES
    SEE IF IT WORKS
 */

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {

		/* These three arraylists store the information about the different rented properties*/
		ArrayList<Apartment> apartments = new ArrayList<>();
        ArrayList<House> houses = new ArrayList<>();
        ArrayList<Villa> villas = new ArrayList<>();

        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Truck> trucks = new ArrayList<>();
       
        /* I create an object so I can call the FillInPropertiesMethod to add details to the arraylists */
     //   FillInProperties Filler = new FillInProperties();
     //   Filler.FillInPropertiesMethod(apartments, houses, villas);

        ReadInputPropertyFile PropertyReader = new ReadInputPropertyFile();
        PropertyReader.readInputPropertyFileMethod(apartments, houses, villas);

        ReadInputVehicleFile VehicleReader = new ReadInputVehicleFile();
        VehicleReader.readInputVehicleFileMethod(cars, trucks);


        RentProperty PropertyRenter = new RentProperty();
        PropertyRenter.GiveRentalProperty(apartments, houses, villas);


		
        /* I create an object so I can call the PrintAllPropertiesMethod to print the added information */
        PrintAllProperties PropertyPrinter = new PrintAllProperties();
        try {
            PropertyPrinter.PrintAllPropertiesMethod(apartments, houses, villas);
        } catch(Exception ex) {
            System.out.println("idk");
        }

        PrintAllVehicles VehiclesPrinter = new PrintAllVehicles();
        try {
            VehiclesPrinter.PrintAllVehiclesMethod(cars, trucks);
        } catch(Exception ex) {
            System.out.println("idk");
        }



	//	PrintAllProperties Printer = new PrintAllProperties();
	//	Printer.PrintAllPropertiesMethod(apartments, houses, villas);
		
		/* I create an object so I can call the CalculateTotalIncomeAmount method to calculate the total income amount */
	//	CalculateTotalIncome Calculator = new CalculateTotalIncome();
	//	Calculator.CalculateTotalIncomeAmount(apartments, houses, villas);
		System.exit(0);
	}
}