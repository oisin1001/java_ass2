//Java Assignment 2 - Oisin Quinn - 16314071

/*
 *  This file contains the Car class for creating cars for the system
 */

/* The class extends the Vehicle class - so it inherits the methods and variables of that class */
class Car extends Vehicle {

    // This is an instance variable that is not part of the Vehicle class
     private int passengersNumber;

    /**
     * Constructs a car class with the user's entered variables
     * @param enteredRegNum the registration number of the car
     * @param enteredName the name of the driver
     * @param enteredCost the cost per day
     * @param enteredPassengersNumber the number of passengers in the car
     */
     Car(int enteredRegNum, String enteredName, int enteredCost, int enteredPassengersNumber){
        // This line inherits the constructor from the Property class
         super(enteredRegNum, enteredName, enteredCost);
         passengersNumber = enteredPassengersNumber;
     }

     /**
      * This method returns the number of passengers the car holds
      * @return the number of passengers
      */
     int getPassengersNumber()
     {
         return passengersNumber;
     }

     /**
      * This method changes the number of passengers in the car
      * @param enteredPassengersNumber the new number of passengers
      */
     void setPassengersNumber(int enteredPassengersNumber)
     {
         passengersNumber = enteredPassengersNumber;
     }
 }