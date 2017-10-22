import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadInputVehicleFile {

    void readInputVehicleFileMethod(ArrayList<Car> cars, ArrayList<Truck> trucks)
    {
        String line;
        int regNum = 1;

        try {
            FileReader myFile = new FileReader("/Users/oisin/Desktop/Second Year/Java/InputVehicle.txt");
            Scanner scanFile = new Scanner(myFile);
            while(scanFile.hasNextLine()){
                line = scanFile.nextLine();

                Scanner getWords = new Scanner(line);
                int VehicleType = getWords.nextInt();
                if (VehicleType == 1) {
                    int RentalCostPerDay= getWords.nextInt();
                    int TotalRentalDays= getWords.nextInt();
                    int passengerNumber= getWords.nextInt();
                    String Owner= getWords.next();
                    cars.add(new Car(regNum++, Owner, RentalCostPerDay, TotalRentalDays, passengerNumber));
                } else if (VehicleType == 2) {
                    int RentalCostPerDay= getWords.nextInt();
                    int TotalRentalDays= getWords.nextInt();
                    int passengerNumber= getWords.nextInt();
                    String Owner= getWords.next();
                    trucks.add(new Truck(regNum++, Owner, RentalCostPerDay, TotalRentalDays, passengerNumber));
                }
            }
        }
        catch(Exception ex) {
            System.out.println("exception "+ex.getMessage()+" caught");
        }
    }
}