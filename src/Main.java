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

class Main {

    public static ArrayList<Apartment> apartments = new ArrayList<>();
    public static ArrayList<House> houses = new ArrayList<>();
    public static ArrayList<Villa> villas = new ArrayList<>();

    public static ArrayList<Car> cars = new ArrayList<>();
    public static ArrayList<Truck> trucks = new ArrayList<>();

    public static void main(String[] args) {

		/* These three arraylists store the information about the different rented properties*/




        /* I create an object so I can call the FillInPropertiesMethod to add details to the arraylists */
     //   FillInProperties Filler = new FillInProperties();
     //   Filler.FillInPropertiesMethod(apartments, houses, villas);

    //    ReadInputPropertyFile PropertyReader = new ReadInputPropertyFile();
     //   PropertyReader.readInputPropertyFileMethod(Main.apartments, Main.houses, Main.villas);

        ReadInputVehicleFile VehicleReader = new ReadInputVehicleFile();
        VehicleReader.readInputVehicleFileMethod(cars, trucks);

        Menu menuFrame = new Menu();
        menuFrame.setSize(700,100);
        menuFrame.setLocation(300,360);
        menuFrame.setVisible(true);


        //     RentProperty2 frame = new RentProperty2(apartments, houses, villas);
    /*    RentProperty2 frame = new RentProperty2();
        frame.setSize(470,65);
        frame.setLocation(300,360);
        frame.setVisible(true); */


		
        /* I create an object so I can call the PrintAllPropertiesMethod to print the added information */
    /*    PrintAllProperties PropertyPrinter = new PrintAllProperties();
        try {
            PropertyPrinter.PrintAllPropertiesMethod(Main.apartments, Main.houses, Main.villas);
        } catch(Exception ex) {
            System.out.println("idk");
        }*/

  /*      PrintAllVehicles VehiclesPrinter = new PrintAllVehicles();
        try {
            VehiclesPrinter.PrintAllVehiclesMethod(cars, trucks);
        } catch(Exception ex) {
            System.out.println("idk");
        } */



	//	PrintAllProperties Printer = new PrintAllProperties();
	//	Printer.PrintAllPropertiesMethod(apartments, houses, villas);
		
		/* I create an object so I can call the CalculateTotalIncomeAmount method to calculate the total income amount */
	//	CalculateTotalIncome Calculator = new CalculateTotalIncome();
	//	Calculator.CalculateTotalIncomeAmount(apartments, houses, villas);
	}
}