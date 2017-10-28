import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RentProperty extends JFrame implements ActionListener {

    boolean propertyFound;
    int i, propertyID, rentalDays;

    JTextField searchNumField = new JTextField(4);

    JTextField numDaysField = new JTextField(4);
    JButton okButton = new JButton("Ok");               // create button
    JButton cancelButton = new JButton("Cancel");       // create button
    JLabel searchNumLabel = new JLabel("PropertyID:");
    JLabel numDaysLabel = new JLabel("Rental days:");


    RentProperty() {
        super("myButtonJFrame");
       okButton.addActionListener(this);
        cancelButton.addActionListener(this);
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
            propertyID = Integer.parseInt(searchNumField.getText());
            rentalDays = Integer.parseInt(numDaysField.getText());
            propertyFound = false;

            for (i = 0; i < 3 && propertyFound == false; i++) {
                if (propertyID == Main.apartments.get(i).getRegNum()) {
                    Main.apartments.get(i).RentalItem(rentalDays);
                    propertyFound = true;
                    System.out.println("Apartment " + (i + 1) + " value " + rentalDays);
                }
            }

            for (i = 0; i < 3 && propertyFound == false; i++) {
                if (propertyID == Main.houses.get(i).getRegNum()) {
                    Main.houses.get(i).RentalItem(rentalDays);
                    propertyFound = true;
                    System.out.println("House " + (i + 1) + " value " + rentalDays);
                }
            }

            for (i = 0; i < 3 && propertyFound == false; i++) {
                if (propertyID == Main.villas.get(i).getRegNum()) {
                    Main.villas.get(i).RentalItem(rentalDays);
                    propertyFound = true;
                    System.out.println("Villa " + (i + 1) + " value " + rentalDays);
                 }
            }
            searchNumField.setText("");
            numDaysField.setText("");
        } else {
            dispose();
        }
    }
}

