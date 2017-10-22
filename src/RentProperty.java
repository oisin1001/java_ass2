import java.util.ArrayList;
import javax.swing.*;

public class RentProperty {
    void GiveRentalProperty(ArrayList<Apartment> apartments,ArrayList<House> houses, ArrayList<Villa> villas)
    {
        int propertyID, rentalDays, i;
        boolean propertyFound;

        JLabel propertyIDLabel = new JLabel("PropertyID:");
        JLabel rentalDaysLabel = new JLabel("Rental days:");

        JTextField propertyIDField = new JTextField();
        JTextField rentalDaysField = new JTextField();

        Object[] userInput = {
                propertyIDLabel, propertyIDField, rentalDaysLabel, rentalDaysField
        };

        int input = JOptionPane.showConfirmDialog(null, userInput, "Input Details", JOptionPane.OK_CANCEL_OPTION);

        while(input == 0) {
            propertyFound = false;

            propertyID = Integer.parseInt(propertyIDField.getText());
            rentalDays = Integer.parseInt(rentalDaysField.getText());

            for (i = 0; i < 3 && propertyFound == false; i++) {
                if (propertyID == apartments.get(i).getRegNum()) {
                    apartments.get(i).RentalItem(rentalDays);
                    propertyFound = true;
                }
            }

            for (i = 0; i < 3 && propertyFound == false; i++) {
                if (propertyID == houses.get(i).getRegNum()) {
                    houses.get(i).RentalItem(rentalDays);
                    propertyFound = true;
                }
            }

            for (i = 0; i < 3 && propertyFound == false; i++) {
                if (propertyID == villas.get(i).getRegNum()) {
                    villas.get(i).RentalItem(rentalDays);
                    propertyFound = true;
                }
            }

            propertyIDField.setText("");
            rentalDaysField.setText("");
            input = JOptionPane.showConfirmDialog(null, userInput, "Input Details", JOptionPane.OK_CANCEL_OPTION);
        }
    }
}