//Java Assignment 2 - Oisin Quinn - 16314071


/*
 *   This class contains the main method, creates the arraylists and calls the Menu function that contains the main menu JFrame
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


class Main {

    // I understand that it's not best practice to declare these as static, but it was the only way I could pass these
    // into the ActionPerformed method later on
    static ArrayList<Apartment> apartments = new ArrayList<>();
    static ArrayList<House> houses = new ArrayList<>();
    static ArrayList<Villa> villas = new ArrayList<>();

    static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Truck> trucks = new ArrayList<>();


    public static void main(String[] args) {
        // I create a new main menu frame to call the rest of the program from
        MainMenu mainMenuFrame = new MainMenu();
        mainMenuFrame.setSize(700,100);
        mainMenuFrame.setLocation(300,360);
        mainMenuFrame.setVisible(true);
	}
}

class MainMenu extends JFrame implements ActionListener {
    // These are the buttons in the frame
    private JButton importPropertyButton = new JButton("Import Property");
    private JButton rentPropertyButton = new JButton("Rent Property");
    private JButton CalculatePropertyIncomeButton = new JButton("Calculate Property Income");
    private JButton printPropertyButton = new JButton("Print Property");
    private JButton importVehicleButton = new JButton("Import Vehicle");
    private JButton rentVehicleButton = new JButton("Rent Vehicle");
    private JButton CalculateVehicleIncomeButton = new JButton("Calculate Vehicle Income");
    private JButton printVehicleButton = new JButton("Print Vehicle");

    /**
     * This is the constructor for the main menu JFrame
     */
    MainMenu(){
        // I use super to create the JFrame, and set the title
        super("MyBNB - Main Menu");
        // These add an action listener to each button
        importPropertyButton.addActionListener(this);
        rentPropertyButton.addActionListener(this);
        CalculatePropertyIncomeButton.addActionListener(this);
        printPropertyButton.addActionListener(this);
        importVehicleButton.addActionListener(this);
        rentVehicleButton.addActionListener(this);
        CalculateVehicleIncomeButton.addActionListener(this);
        printVehicleButton.addActionListener(this);
        // I create a container, and I add each button to the container
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

        // Whenever this window is closed, the program is terminated
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * This method is triggered when a button is pressed
     * @param e When a button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        // I create a new property and vehicle that are used to call the methods in the Property and Vehicle class
        Property methodProperty = new Property();
        Vehicle methodVehicle = new Vehicle();

        // These eight if statements check which button is pressed, and runs the respective method in the respective class
        if(e.getSource() == importPropertyButton)
        {
            methodProperty.readInputPropertyFile(Main.apartments, Main.houses, Main.villas);
            JOptionPane.showMessageDialog(null,"Property import successful:");
        }

        else if(e.getSource() == rentPropertyButton)
        {
            // If the "Rent Property" button is pressed, I create a new JFrame
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
            // I use try and catch to catch the FileNotFound exception
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
            // If the "Rent Vehicle" button is pressed, I create a new JFrame
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
            // I use try and catch to catch the FileNotFound exception
             try {
                methodVehicle.PrintAllVehicles(Main.cars, Main.trucks);
                 JOptionPane.showMessageDialog(null,"Vehicles printed to OutputVehicles.txt");
            } catch(Exception ex) {
                 JOptionPane.showMessageDialog(null,"Error printing to OutputVehicles.txt");
            }
        }


    }
}
