//Java Assignment 2 - Oisin Quinn - 16314071

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This is the class that is used to rent a vehicle
class RentVehicle extends JFrame implements ActionListener {



    // These are the components of the JFrame
    private JTextField searchNumField = new JTextField(4);
    private JTextField numDaysField = new JTextField(4);
    private JButton okButton = new JButton("Ok");


    /**
     * Constructs the RentVehicle class
     */
    RentVehicle() {
        // I use super to create the JFrame and set the title
        super("Rent Vehicle");

        // These are more components of the JFrame
        JButton cancelButton = new JButton("Cancel");
        JLabel searchNumLabel = new JLabel("Vehicle ID:");
        JLabel numDaysLabel = new JLabel("Rental days:");

        // I add an ActionListener to each button
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        Container content = this.getContentPane();

        // I create a container that holds the components of the JFrame
        content.setLayout(new FlowLayout());
        content.add(searchNumLabel);
        content.add(searchNumField);
        content.add(numDaysLabel);
        content.add(numDaysField);
        content.add(okButton);
        content.add(cancelButton);
    }

    /**
     * This method is triggered when a button on the "Rent Vehicle" window is pressed
     * @param e When a button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        boolean vehicleFound;
        int i, vehicleID, rentalDays;
        // If "Ok" is clicked, we use the inputted information to change the arraylist
        if(e.getSource() == okButton) {
            // I parse the strings to obtain an integer from the textfields
            vehicleID = Integer.parseInt(searchNumField.getText());
            rentalDays = Integer.parseInt(numDaysField.getText());
            // I use a boolean to prevent searching further into the arraylist when the correct entry is already found
            vehicleFound = false;

            // I loop through the arraylists, looking for the correct RegNum
            // If I find the correct one, I change the number of rentalDays to the user's input
            for (i = 0; i < 3 && !vehicleFound; i++) {
                if (vehicleID == Main.cars.get(i).getRegNum()) {
                    Main.cars.get(i).RentalItem(rentalDays);
                    vehicleFound = true;
                }
            }

            for (i = 0; i < 3 && !vehicleFound; i++) {
                if (vehicleID == Main.trucks.get(i).getRegNum()) {
                    Main.trucks.get(i).RentalItem(rentalDays);
                    vehicleFound = true;
                }
            }

            // I reset the textfields
            searchNumField.setText("");
            numDaysField.setText("");
        } else {
            // If the "Ok" button isn't clicked, then the "Cancel" button is clicked, and I dispose of the JFrame
            dispose();
        }

    }
}

