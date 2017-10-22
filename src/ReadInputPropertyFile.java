import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;

class ReadInputPropertyFile {

    void readInputPropertyFileMethod (ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas)
    {
        String line;
        int regNum = 1;

        try {
            FileReader myFile = new FileReader("/Users/oisin/Desktop/Second Year/Java/InputProperty.txt");
            Scanner scanFile = new Scanner(myFile);
            while(scanFile.hasNextLine()){
                line = scanFile.nextLine();

                Scanner getWords = new Scanner(line);
                int PropertyType = getWords.nextInt();
                if (PropertyType == 1) {
                    int StoreyNumber = getWords.nextInt();
                    int BedsNumber= getWords.nextInt();
                    int RentalCostPerDay= getWords.nextInt();
                    int TotalRentalDays= getWords.nextInt();
                    String Owner= getWords.next();
                    String PostalAddress= getWords.next();
                    apartments.add(new Apartment(regNum++, Owner, PostalAddress, RentalCostPerDay, TotalRentalDays, StoreyNumber, BedsNumber ));
                } else if (PropertyType == 2) {
                    int numberOfStories = getWords.nextInt();
                    int clearingFees= getWords.nextInt();
                    int RentalCostPerDay= getWords.nextInt();
                    int TotalRentalDays= getWords.nextInt();
                    String Owner= getWords.next();
                    String PostalAddress= getWords.next();
                    houses.add(new House(regNum++, Owner, PostalAddress, RentalCostPerDay, TotalRentalDays, numberOfStories, clearingFees));
                    // 2 1 50 60 0 George Paradise_1
                    //  House(int enteredRegNum, String enteredName, String enteredAddress, double enteredCost, int enteredDays, int enteredNumOfStories, double enteredClearingFees)
                } else if (PropertyType == 3) {
                    int numberOfStories = getWords.nextInt();
                    int roomServiceRate = getWords.nextInt();
                    int luxuryTaxRate = getWords.nextInt();
                    int RentalCostPerDay = getWords.nextInt();
                    int TotalRentalDays = getWords.nextInt();
                    String Owner= getWords.next();
                    String PostalAddress= getWords.next();
                    villas.add(new Villa(regNum++, Owner, PostalAddress, RentalCostPerDay, TotalRentalDays, roomServiceRate, luxuryTaxRate));
                 //   3 8 20 30 55 0 Jane Devil’s_place_23
                    // 	Villa (int enteredRegNum, String enteredName, String enteredAddress, double enteredCost, int enteredDays, double enteredRoomServiceRate, double enteredLuxuryTaxRate) {
               }

            }
        }
        catch(Exception ex) {
            System.out.println("exception "+ex.getMessage()+" caught");
        }
    }
}
