class Truck extends Vehicle {

    int cargoWeight;

    Truck(String enteredName, int enteredCost, int enteredDays, int enteredCargoWeight){
        super(enteredName, enteredCost, enteredDays);
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
     * This method changes the number of stories in the apartment
     * @param enteredCargoWeight the new number of stories
     */
    void setCargoWeight(int enteredCargoWeight)
    {
        cargoWeight = enteredCargoWeight;
    }
}
