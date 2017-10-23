 class Car extends Vehicle {

     int passengersNumber;

     Car(int enteredRegNum, String enteredName, int enteredCost, int enteredPassengersNumber){
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
      * This method changes the number of stories in the apartment
      * @param enteredPassengersNumber the new number of stories
      */
     void setPassengersNumber(int enteredPassengersNumber)
     {
         passengersNumber = enteredPassengersNumber;
     }
 }