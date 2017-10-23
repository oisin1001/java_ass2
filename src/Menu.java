import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        super("Main Menu");
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
        if(e.getSource() == importPropertyButton)
        {
            ReadInputPropertyFile PropertyReader = new ReadInputPropertyFile();
            PropertyReader.readInputPropertyFileMethod(Main.apartments, Main.houses, Main.villas);
            JOptionPane.showMessageDialog(null,"Property imported:");
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
            CalculatePropertyTotalIncome PropertyIncome = new CalculatePropertyTotalIncome();
            PropertyIncome.CalculatePropertyTotalIncomeAmount(Main.apartments, Main.houses, Main.villas);
        }

        else if(e.getSource() == printPropertyButton)
        {
            PrintAllProperties PropertyPrinter = new PrintAllProperties();
            try {
                PropertyPrinter.PrintAllPropertiesMethod(Main.apartments, Main.houses, Main.villas);
            } catch(Exception ex) {
                System.out.println("Error printing");
            }
            JOptionPane.showMessageDialog(null,"Property printed:");
        }

         else if(e.getSource() == importVehicleButton)
        {
            ReadInputVehicleFile VehicleReader = new ReadInputVehicleFile();
            VehicleReader.readInputVehicleFileMethod(Main.cars, Main.trucks);
            JOptionPane.showMessageDialog(null,"Vehicles imported:");
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
            CalculateVehicleTotalIncome VehicleIncome = new CalculateVehicleTotalIncome();
            VehicleIncome.CalculateVehicleTotalIncomeAmount(Main.cars, Main.trucks);
        }

        else if(e.getSource() == printVehicleButton)
        {
            JOptionPane.showMessageDialog(null,"Vehicles printed:");
            PrintAllVehicles VehiclePrinter = new PrintAllVehicles();
            try {
                VehiclePrinter.PrintAllVehiclesMethod(Main.cars, Main.trucks);
            } catch(Exception ex) {
                System.out.println("Error printing");
            }
        }


    }
}
