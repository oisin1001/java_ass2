import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.*;

class RentVehicle extends JFrame implements ActionListener {

    boolean vehicleFound;
    int i, vehicleID, rentalDays;

    JTextField searchNumField = new JTextField(4);

    JTextField numDaysField = new JTextField(4);
    JButton okButton = new JButton("Ok");               // create button
    JButton cancelButton = new JButton("Cancel");       // create button
    JLabel searchNumLabel = new JLabel("PropertyID:");
    JLabel numDaysLabel = new JLabel("Rental days:");


    // RentProperty2(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas) {
    RentVehicle() {
        super("myButtonJFrame");
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        //   cancelButton.addActionListener(this);
        Container content = this.getContentPane();

        content.setLayout(new FlowLayout());
        content.add(searchNumLabel);                           // add text area
        content.add(searchNumField);
        content.add(numDaysLabel);
        content.add(numDaysField);
        content.add(okButton);
        content.add(cancelButton);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == okButton) {
            vehicleID = Integer.parseInt(searchNumField.getText());
            rentalDays = Integer.parseInt(numDaysField.getText());
            vehicleFound = false;

            for (i = 0; i < 3 && vehicleFound == false; i++) {
                if (vehicleID == Main.cars.get(i).getRegNum()) {
                    Main.cars.get(i).RentalItem(rentalDays);
                    vehicleFound = true;
                }
            }

            for (i = 0; i < 3 && vehicleFound == false; i++) {
                if (vehicleID == Main.trucks.get(i).getRegNum()) {
                    Main.trucks.get(i).RentalItem(rentalDays);
                    vehicleFound = true;
                }
            }
            searchNumField.setText("");
            numDaysField.setText("");
        } else {
            dispose();
        }

    }
}

