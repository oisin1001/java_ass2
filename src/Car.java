 class Car extends Vehicle {

     int passengersNumber;

     Car(String enteredName, int enteredCost, int enteredDays, int enteredPassengersNumber){
         super(enteredName, enteredCost, enteredDays);
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