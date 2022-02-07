import java.util.ArrayList;

/**
 * This class represents an inventory of cars
 *
 * @author Rensong Wan
 */
public class UsedCarLot {
    /** An ArrayList that can hold cars */
    private ArrayList <Car> inventory;

    /**
     * Instantiates an ArrayList named iventory.
     */
    public UsedCarLot(){
        inventory = new ArrayList<Car>();
    }

    /**
     * Returns the ArrayList of cars.
     *
     * @return The entire inventory ArrayList
     */
    public ArrayList<Car> getInventory(){
        return inventory;
    }

    /**
     * Adds new car into the inventory ArrayList.
     *
     * @param newCar The new car that is added to the inventory ArrayList
     */
    public void addCar(Car newCar){
        inventory.add(newCar);
    }

    /**
     * Returns a boolean value that indicates if the operation is a success or failed.
     * If both idx1 and idx2 are between 0 and the inventory size, swap the car location at the two indexes.
     * Otherwise, the operation is failed.
     * \
     * @param idx1 The index of first car in the inventory ArrayList
     * @param idx2 The index of second car in the inventory ArrayList
     * @return The boolean value of the swap operation
     */
    public boolean swap(int idx1, int idx2){
        if(idx1 < inventory.size() && idx2 < inventory.size() && idx1 >= 0 && idx2 >= 0){
            Car car1 = inventory.get(idx1);
            Car car2 = inventory.get(idx2);
            inventory.set(idx1, car2);
            inventory.set(idx2, car1);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Adds a Car to the inventory list at the index specified by indexToAdd.
     * this method increases the size of inventory by 1
     *
     * PRECONDITION: 0 &lt;= indexToAdd &lt; inventory.size()
     *
     * @param indexToAdd The index in the inventory ArrayList where the car is added
     * @param carToAdd The car that is added to the ArrayList at index
     */
    public void addCar(int indexToAdd, Car carToAdd){
        inventory.add(indexToAdd, carToAdd);
    }

    /**
     *  "sells" the Car located at indexOfCarToSell which
     *  removes it from the inventory list and shifting the remaining
     *  Cars in the inventory list to the left to fill in the gap;
     *
     *  this method reduces the size of inventory by 1


     *  Returns the Car that is being "sold" (removed from lot)

     *  PRECONDITION: indexOfCarToSell &lt; inventory.size()
     *
     * @param indexOfCarToSell The index of the car that is sold
     * @return The car that is being sold
      */
    public Car sellCarShift(int indexOfCarToSell){
        Car carSell = inventory.get(indexOfCarToSell);
        inventory.remove(indexOfCarToSell);
        return carSell;
    }

    /**
     *  "sells" the Car located at indexOfCarToSell,
     *  but does not remove it from the inventory list and shifting the remaining
     *  Replaces the Car at indexOfCarToSell
     *  with NULL, thus creating an "empty parking spot" on the lot;
     *
     *  this method does NOT reduce the size of inventory by 1


     *  Returns the Car that is being "sold" (replaced with null)

     *  PRECONDITION: indexOfCarToSell &lt; inventory.size()
     *
     * @param indexOfCarToSell The index of the car that is sold
     * @return The car that is being sold
     */
    public Car sellCarNoShift(int indexOfCarToSell)
    {
        Car carSell = inventory.get(indexOfCarToSell);
        inventory.set(indexOfCarToSell, null);
        return carSell;
    }

    /**
     * moves Car located at index indexOfCarToMove to index destinationIndex;
     * if destinationIndex > indexOfCarToMove, moves the Car to the right in
     * inventory; if destinationIndex &lt; indexOfCarToMove, moves the
     * Car to the left in the inventory. All other cars in the inventory
     * should shift accordingly
     *
     * PRECONDITIONS: indexOfCarToMove &lt; inventory.size()
     * destinationIndex &lt; inventory.size()
     *
     * @param destinationIndex The index where the car is being moved to
     * @param indexOfCarToMove The index of the car that is being moved
     */
    public void moveCar(int indexOfCarToMove, int destinationIndex)
    {
        if(destinationIndex > indexOfCarToMove){
            addCar(destinationIndex + 1, inventory.get(indexOfCarToMove));
            sellCarShift(indexOfCarToMove);
        }
        else if(destinationIndex < indexOfCarToMove) {
            addCar(destinationIndex, inventory.get(indexOfCarToMove));
            sellCarShift(indexOfCarToMove + 1);
        }
    }
}
