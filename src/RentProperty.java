//Java Assignment 2 - Oisin Quinn - 16314071

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This is the class that is used to rent a property
class RentProperty extends JFrame implements ActionListener {



    // These are the components of the JFrame
    private JTextField searchNumField = new JTextField(4);
    private JTextField numDaysField = new JTextField(4);
    private JButton okButton = new JButton("Ok");


    /**
     * Constructs the RentProperty class
     */
    RentProperty() {
        // I use super to create the JFrame and set the title
        super("Rent Property");

        // These are more components of the JFrame
        JButton cancelButton = new JButton("Cancel");
        JLabel searchNumLabel = new JLabel("PropertyID:");
        JLabel numDaysLabel = new JLabel("Rental days:");

        // I add an ActionListener to each button
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // I create a container that holds the components of the JFrame
        Container content = this.getContentPane();
        content.setLayout(new FlowLayout());
        content.add(searchNumLabel);
        content.add(searchNumField);
        content.add(numDaysLabel);
        content.add(numDaysField);
        content.add(okButton);
        content.add(cancelButton);
    }

    /**
     * This method is triggered when a button on the "Rent Property" window is pressed
     * @param e When a button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        boolean propertyFound;
        int i, propertyID, rentalDays;
        // If "Ok" is clicked, we use the inputted information to change the arraylist
        if(e.getSource() == okButton) {
            // I parse the strings to obtain an integer from the textfields
            propertyID = Integer.parseInt(searchNumField.getText());
            rentalDays = Integer.parseInt(numDaysField.getText());
            // I use a boolean to prevent searching further into the arraylist when the correct entry is already found
            propertyFound = false;

            // I loop through the arraylists, looking for the correct RegNum
            // If I find the correct one, I change the number of rentalDays to the user's input
            for (i = 0; i < 3 && !propertyFound; i++) {
                if (propertyID == Main.apartments.get(i).getRegNum()) {
                    Main.apartments.get(i).RentalItem(rentalDays);
                    propertyFound = true;
                    System.out.println("Apartment " + (i + 1) + " value " + rentalDays);
                }
            }

            for (i = 0; i < 3 && !propertyFound; i++) {
                if (propertyID == Main.houses.get(i).getRegNum()) {
                    Main.houses.get(i).RentalItem(rentalDays);
                    propertyFound = true;
                    System.out.println("House " + (i + 1) + " value " + rentalDays);
                }
            }

            for (i = 0; i < 3 && !propertyFound; i++) {
                if (propertyID == Main.villas.get(i).getRegNum()) {
                    Main.villas.get(i).RentalItem(rentalDays);
                    propertyFound = true;
                    System.out.println("Villa " + (i + 1) + " value " + rentalDays);
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