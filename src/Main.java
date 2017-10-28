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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Main {

    public static ArrayList<Apartment> apartments = new ArrayList<>();
    public static ArrayList<House> houses = new ArrayList<>();
    public static ArrayList<Villa> villas = new ArrayList<>();

    public static ArrayList<Car> cars = new ArrayList<>();
    public static ArrayList<Truck> trucks = new ArrayList<>();

    public static void main(String[] args) {

        Menu menuFrame = new Menu();
        menuFrame.setSize(700,100);
        menuFrame.setLocation(300,360);
        menuFrame.setVisible(true);

	}
}

class Menu extends JFrame implements ActionListener {

    private JButton importPropertyButton = new JButton("Import Property");
    private JButton rentPropertyButton = new JButton("Rent Property");
    private JButton CalculatePropertyIncomeButton = new JButton("Calculate Property Income");
    private JButton printPropertyButton = new JButton("Print Property");
    private JButton importVehicleButton = new JButton("Import Vehicle");
    private JButton rentVehicleButton = new JButton("Rent Vehicle");
    private JButton CalculateVehicleIncomeButton = new JButton("Calculate Vehicle Income");
    private JButton printVehicleButton = new JButton("Print Vehicle");

    Menu(){
        super("MyBNB - Main Menu");
        importPropertyButton.addActionListener(this);
        rentPropertyButton.addActionListener(this);
        CalculatePropertyIncomeButton.addActionListener(this);
        printPropertyButton.addActionListener(this);
        importVehicleButton.addActionListener(this);
        rentVehicleButton.addActionListener(this);
        CalculateVehicleIncomeButton.addActionListener(this);
        printVehicleButton.addActionListener(this);
        Container content = this.getContentPane();
        content.setLayout(new GridLayout(2,4));
        content.add(importPropertyButton);
        content.add(rentPropertyButton);
        content.add(CalculatePropertyIncomeButton);
        content.add(printPropertyButton);
        content.add(importVehicleButton);
        content.add(rentVehicleButton);
        content.add(CalculateVehicleIncomeButton);
        content.add(printVehicleButton);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        Property methodProperty = new Property();
        Vehicle methodVehicle = new Vehicle();
        if(e.getSource() == importPropertyButton)
        {
            methodProperty.readInputPropertyFile(Main.apartments, Main.houses, Main.villas);
            JOptionPane.showMessageDialog(null,"Property import successful:");
        }

        else if(e.getSource() == rentPropertyButton)
        {
            RentProperty frame = new RentProperty();
            frame.setSize(470,65);
            frame.setLocation(300,360);
            frame.setVisible(true);
        }

        else if(e.getSource() == CalculatePropertyIncomeButton)
        {

            methodProperty.CalculatePropertyTotalIncome(Main.apartments, Main.houses, Main.villas);
        }

        else if(e.getSource() == printPropertyButton)
        {
            try {
                methodProperty.PrintAllProperties(Main.apartments, Main.houses, Main.villas);
                JOptionPane.showMessageDialog(null,"Property printed to OutputProperty.txt");
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Error printing to OutputProperty.txt!");
            }

        }

        else if(e.getSource() == importVehicleButton)
        {
            methodVehicle.readInputVehicleFile(Main.cars, Main.trucks);
            JOptionPane.showMessageDialog(null,"Vehicle import successful:");
        }

        else if(e.getSource() == rentVehicleButton)
        {
            RentVehicle frame = new RentVehicle();
            frame.setSize(470,65);
            frame.setLocation(300,360);
            frame.setVisible(true);
        }

        else if(e.getSource() == CalculateVehicleIncomeButton)
        {
            methodVehicle.CalculateVehicleTotalIncome(Main.cars, Main.trucks);
        }

        else if(e.getSource() == printVehicleButton)
        {
             try {
                methodVehicle.PrintAllVehicles(Main.cars, Main.trucks);
                 JOptionPane.showMessageDialog(null,"Vehicles printed to OutputVehicles.txt");
            } catch(Exception ex) {
                 JOptionPane.showMessageDialog(null,"Error printing to OutputVehicles.txt");
            }
        }


    }
}
