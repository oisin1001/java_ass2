//Java Assignment 1 - Oisin Quinn - 16314071

import java.util.ArrayList;
import javax.swing.*;


/* This class fills in the details into the arraylists for each property */
class FillInProperties {
	
	/* This is an empty constructor for the class */
	FillInProperties(){}
	/**
	 * Lets the user enter values for the property, and creates an object
	 * @param apartments the arraylist that contains details about the apartments
	 * @param houses the arraylist that contains details about the houses
	 * @param villas he arraylist that contains details about the villas
	 */

	 void FillInPropertiesMethod(ArrayList<Apartment> apartments,ArrayList<House> houses, ArrayList<Villa> villas){
	    /* These are the required variables */
        int i, regNum, seasonsRentalDays, storey, beds;
        int costPerDay, clearing, roomServiceRate, luxuryTaxRate;

        /* This for loop lets the user enter in values for apartments */
        for(i = 0; i < 3; i++)
		{
            // These are the labels for the user input JOptionPane
            // I use HTML in title to make the text bold (so it stands out)
            JLabel title = new JLabel("<html><b>Apartment " + (i+1) + ":</b></html>");
            JLabel regNumLabel = new JLabel("Registration number:");
            JLabel ownerNameLabel = new JLabel("Owner name:");
            JLabel addressLabel = new JLabel("Address:");
            JLabel costPerDayLabel = new JLabel("Cost per day:");
            JLabel seasonsRentalDaysLabel = new JLabel("Seasons rental days:");
            JLabel storeyLabel = new JLabel("Storey number:");
            JLabel bedsLabel = new JLabel("Number of beds:");

            // These are the text fields for the JOptionPane
            JTextField regNumField=new JTextField();
            JTextField ownerNameField=new JTextField();
            JTextField addressField=new JTextField();
            JTextField costPerDayField=new JTextField();
            JTextField seasonsRentalDaysField=new JTextField();
            JTextField storeyField=new JTextField();
            JTextField bedsField=new JTextField();

            // This is used to have multiple items in the JOptionPane confirm dialog
            Object[] userInput = {
                    title, regNumLabel, regNumField, ownerNameLabel, ownerNameField, addressLabel, addressField, costPerDayLabel,
                    costPerDayField, seasonsRentalDaysLabel, seasonsRentalDaysField, storeyLabel, storeyField, bedsLabel, bedsField
            };

            // This line opens the dialog box - DEFAULT_OPTION means that there's only an "OK" button
            JOptionPane.showConfirmDialog(null, userInput, "Input Details", JOptionPane.DEFAULT_OPTION);

            // This converts some of the variables from strings to integers/doubles
            regNum = Integer.parseInt(regNumField.getText());
            costPerDay = Integer.parseInt(costPerDayField.getText());
            seasonsRentalDays = Integer.parseInt(seasonsRentalDaysField.getText());
            storey = Integer.parseInt(storeyField.getText());
            beds = Integer.parseInt(bedsField.getText());

            // This creates the apartment and adds it to the arraylist
            apartments.add(new Apartment(regNum, ownerNameField.getText(), addressField.getText(), costPerDay, seasonsRentalDays, storey, beds));
   //         1 2 50 0 George Paradise_3
		}



        /* This for loop lets the user enter in values for houses */
		for(i = 0; i < 3; i++)
		{
            // These are the labels for the user input JOptionPane
            // I use HTML in title to make the text bold (so it stands out)
            JLabel title = new JLabel("<html><b>House " + (i+1) + ":</b></html>");
            JLabel regNumLabel = new JLabel("Registration number:");
            JLabel ownerNameLabel = new JLabel("Owner name:");
            JLabel addressLabel = new JLabel("Address:");
            JLabel costPerDayLabel = new JLabel("Cost per day:");
            JLabel seasonsRentalDaysLabel = new JLabel("Seasons rental days:");
            JLabel storeyLabel = new JLabel("Number of stories:");
            JLabel clearingFeesLabel = new JLabel("Clearing fees:");

            // These are the text fields for the JOptionPane
            JTextField regNumField=new JTextField();
            JTextField ownerNameField=new JTextField();
            JTextField addressField=new JTextField();
            JTextField costPerDayField=new JTextField();
            JTextField seasonsRentalDaysField=new JTextField();
            JTextField storeyField=new JTextField();
            JTextField clearingFeesField=new JTextField();

            // This is used to have multiple items in the JOptionPane confirm dialog
            Object[] userInput = {
                    title, regNumLabel, regNumField, ownerNameLabel, ownerNameField, addressLabel, addressField, costPerDayLabel,
                    costPerDayField, seasonsRentalDaysLabel, seasonsRentalDaysField, storeyLabel, storeyField, clearingFeesLabel, clearingFeesField
            };

            // This line opens the dialog box - DEFAULT_OPTION means that there's only an "OK" button
            JOptionPane.showConfirmDialog(null, userInput, "Input Details", JOptionPane.DEFAULT_OPTION);

            // This converts some of the variables from strings to integers/doubles
            regNum = Integer.parseInt(regNumField.getText());
            costPerDay = Integer.parseInt(costPerDayField.getText());
            seasonsRentalDays = Integer.parseInt(seasonsRentalDaysField.getText());
            storey = Integer.parseInt(storeyField.getText());
            clearing = Integer.parseInt(clearingFeesField.getText());

            // This creates the house and adds it to the arraylist
			houses.add(new House(regNum, ownerNameField.getText(), addressField.getText(), costPerDay, seasonsRentalDays, storey, clearing)); // This needs two more arguments
		}


		/* This for loop lets the user enter in values for apartments */
		for(i = 0; i < 3; i++)
		{
            // These are the labels for the user input JOptionPane
            // I use HTML in title to make the text bold (so it stands out)
            JLabel title = new JLabel("<html><b>Villa " + (i+1) + ":</b></html>");
            JLabel regNumLabel = new JLabel("Registration number:");
            JLabel ownerNameLabel = new JLabel("Owner name:");
            JLabel addressLabel = new JLabel("Address:");
            JLabel costPerDayLabel = new JLabel("Cost per day:");
            JLabel seasonsRentalDaysLabel = new JLabel("Seasons rental days:");
            JLabel roomServiceRateLabel = new JLabel("Room service cost per day:");
            JLabel luxuryTaxRateLabel = new JLabel("Luxury tax cost per day:");

            // These are the text fields for the JOptionPane
            JTextField regNumField = new JTextField();
            JTextField ownerNameField = new JTextField();
            JTextField addressField = new JTextField();
            JTextField costPerDayField = new JTextField();
            JTextField seasonsRentalDaysField = new JTextField();
            JTextField roomServiceRateField = new JTextField();
            JTextField luxuryTaxRateField = new JTextField();

            // This is used to have multiple items in the JOptionPane confirm dialog
            Object[] userInput = {
                    title, regNumLabel, regNumField, ownerNameLabel, ownerNameField, addressLabel, addressField, costPerDayLabel,
                    costPerDayField, seasonsRentalDaysLabel, seasonsRentalDaysField, roomServiceRateLabel, roomServiceRateField, luxuryTaxRateLabel, luxuryTaxRateField
            };

            // This line opens the dialog box - DEFAULT_OPTION means that there's only an "OK" button
            JOptionPane.showConfirmDialog(null, userInput, "Input Details", JOptionPane.DEFAULT_OPTION);

            // This converts some of the variables from strings to integers/doubles
            regNum = Integer.parseInt(regNumField.getText());
            costPerDay = Integer.parseInt(costPerDayField.getText());
            seasonsRentalDays = Integer.parseInt(seasonsRentalDaysField.getText());
            roomServiceRate = Integer.parseInt(roomServiceRateField.getText());
            luxuryTaxRate = Integer.parseInt(luxuryTaxRateField.getText());

			
			// This creates the villa and adds it to the arraylist
			villas.add(new Villa(regNum, ownerNameLabel.getText(), addressLabel.getText(), costPerDay, seasonsRentalDays, roomServiceRate, luxuryTaxRate)); // This needs two more arguments
			
		}
	}
}