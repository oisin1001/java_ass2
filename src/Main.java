//Java Assignment 1 - Oisin Quinn - 16314071


/*
 *   This class runs the program itself, and calls all of the other methods
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

        ReadInputPropertyFile Reader = new ReadInputPropertyFile();
        Reader.readInputPropertyFileMethod(apartments, houses, villas);


        RentProperty Renter = new RentProperty();
        Renter.GiveRentalProperty(apartments, houses, villas);
		
        /* I create an object so I can call the PrintAllPropertiesMethod to print the added information */
       PrintToFile Printer = new PrintToFile();
        try {
            Printer.PrintAllPropertiesMethod(apartments, houses, villas);
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