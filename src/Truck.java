//Java Assignment 2 - Oisin Quinn - 16314071

/*
 *  This file contains the Truck class for creating trucks for the system
 */

/* The class extends the Vehicle class - so it inherits the methods and variables of that class */
class Truck extends Vehicle {

    // This is an instance variable that is not part of the Vehicle class
    int cargoWeight;

    /**
     * Constructs a truck class with the user's entered variables
     * @param enteredRegNum the registration number of the car
     * @param enteredName the name of the driver
     * @param enteredCost the cost per day
     * @param enteredCargoWeight the entered maximum cargo weight
     */
    Truck(int enteredRegNum, String enteredName, int enteredCost, int enteredCargoWeight){
        // This line inherits the constructor from the Property class
        super(enteredRegNum, enteredName, enteredCost);
        cargoWeight = enteredCargoWeight;
    }

    /**
     * This method returns the maximum cargo weight
     * @return the maximum cargo weight
     */
    int getCargoWeight()
    {
        return cargoWeight;
    }

    /**
     * This method changes the maximum cargo weight
     * @param enteredCargoWeight the new maximum cargo weight
     */
    void setCargoWeight(int enteredCargoWeight)
    {
        cargoWeight = enteredCargoWeight;
    }
}
