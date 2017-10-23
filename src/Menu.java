import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.*;

class Menu extends JFrame implements ActionListener {

    JButton importPropertyButton = new JButton("Import Property");
    JButton printPropertyButton = new JButton("Print Property");
    JButton rentPropertyButton = new JButton("Rent Property");
    JButton importVehicleButton = new JButton("Import Vehicle");
    JButton printVehicleButton = new JButton("Print Vehicle");
    JButton rentVehicleButton = new JButton("Rent Vehicle");

    Menu(){
        super("Main Menu");
        importPropertyButton.addActionListener(this);
        printPropertyButton.addActionListener(this);
        rentPropertyButton.addActionListener(this);
        importVehicleButton.addActionListener(this);
        printVehicleButton.addActionListener(this);
        rentVehicleButton.addActionListener(this);
        Container content = this.getContentPane();
        content.setLayout(new GridLayout(2,3));
        content.add(importPropertyButton);
        content.add(printPropertyButton);
        content.add(rentPropertyButton);
        content.add(importVehicleButton);
        content.add(printVehicleButton);
        content.add(rentVehicleButton);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == importPropertyButton)
        {
            ReadInputPropertyFile PropertyReader = new ReadInputPropertyFile();
            PropertyReader.readInputPropertyFileMethod(Main.apartments, Main.houses, Main.villas);
            JOptionPane.showMessageDialog(null,"Property imported:");
        } else if(e.getSource() == printPropertyButton)
        {
            PrintAllProperties PropertyPrinter = new PrintAllProperties();
            try {
                PropertyPrinter.PrintAllPropertiesMethod(Main.apartments, Main.houses, Main.villas);
            } catch(Exception ex) {
                System.out.println("Error printing");
            }
            JOptionPane.showMessageDialog(null,"Property printed:");
        } else if(e.getSource() == rentPropertyButton)
        {
            RentProperty frame = new RentProperty();
            frame.setSize(470,65);
            frame.setLocation(300,360);
            frame.setVisible(true);
        } else if(e.getSource() == importVehicleButton)
        {
            ReadInputVehicleFile VehicleReader = new ReadInputVehicleFile();
            VehicleReader.readInputVehicleFileMethod(Main.cars, Main.trucks);
            JOptionPane.showMessageDialog(null,"Vehicles imported:");
        } else if(e.getSource() == printVehicleButton)
        {
            PrintAllVehicles VehiclePrinter = new PrintAllVehicles();
            try {
                VehiclePrinter.PrintAllVehiclesMethod(Main.cars, Main.trucks);
            } catch(Exception ex) {
                System.out.println("Error printing");
            }
            JOptionPane.showMessageDialog(null,"Vehicles printed:");
        } else if(e.getSource() == rentVehicleButton)
        {
            RentVehicle frame = new RentVehicle();
            frame.setSize(470,65);
            frame.setLocation(300,360);
            frame.setVisible(true);
        }

    }
}
