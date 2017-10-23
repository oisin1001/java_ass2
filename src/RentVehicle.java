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

    /*    class PageActionListener implements ActionListener {
            ArrayList<Apartment> apartments = new ArrayList<>();
            ArrayList<House> houses = new ArrayList<>();
            ArrayList<Villa> villas = new ArrayList<>();

            public PageActionListener(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas) {
                this.apartments = apartments;
                this.houses = houses;
                this.villas = villas;
            }

            public void actionPerformed(ActionEvent e) {
                System.out.println("Shit's happening!");
                propertyID = Integer.parseInt(searchNumField.getText());
                rentalDays = Integer.parseInt(numDaysField.getText());
                propertyFound = false;

                for (i = 0; i < 3 && propertyFound == false; i++) {
                    if (propertyID == apartments.get(i).getRegNum()) {
                        apartments.get(i).RentalItem(rentalDays);
                        propertyFound = true;
                        System.out.println("Apartment " + (i+1) + " value " + rentalDays);
                    //    return apartments;
                    }
                }

                for (i = 0; i < 3 && propertyFound == false; i++) {
                    if (propertyID == houses.get(i).getRegNum()) {
                        houses.get(i).RentalItem(rentalDays);
                        propertyFound = true;
                        System.out.println("House " + (i+1) + " value " + rentalDays);
                    //    return houses;
                    }
                }

                for (i = 0; i < 3 && propertyFound == false; i++) {
                    if (propertyID == villas.get(i).getRegNum()) {
                        villas.get(i).RentalItem(rentalDays);
                        propertyFound = true;
                        System.out.println("Villa " + (i+1) + " value " + rentalDays);
                    //    return villas;
                    }
                }
            }
        } */


        //   okButton.addActionListener(new PageActionListener(apartments, houses, villas));                 // add listener
        okButton.addActionListener(this);
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
        JOptionPane.showMessageDialog(null,"Count button clicked!");
        System.out.println("Shit's happening!");
        vehicleID = Integer.parseInt(searchNumField.getText());
        rentalDays = Integer.parseInt(numDaysField.getText());
        vehicleFound = false;

        for (i = 0; i < 3 && vehicleFound == false; i++) {
            if (vehicleID ==  Main.cars.get(i).getRegNum()) {
                Main.cars.get(i).RentalItem(rentalDays);
                vehicleFound = true;
                System.out.println("Vehicle " + (i+1) + " value " + rentalDays);
                //    return apartments;
            }
        }

        for (i = 0; i < 3 && vehicleFound == false; i++) {
            if (vehicleID ==  Main.trucks.get(i).getRegNum()) {
                Main.trucks.get(i).RentalItem(rentalDays);
                vehicleFound = true;
                System.out.println("Vehicle " + (i+1) + " value " + rentalDays);
                //    return houses;
            }
        }

    }
}

