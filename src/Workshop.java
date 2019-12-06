/**
 * Workshop that holds a number of cars
 */
public class Workshop<T extends Car>{

    private Storage<T> storage;
    

    public Workshop(int maxNumberOfCars){
        storage = new Storage<>(maxNumberOfCars);
    }
    
    /**
     * Loads a car to the Workshop 
     * @param car the car that is taken in to the workshop
     */
    public void loadCar(T car){
        storage.load(car);
    }

    /**
     * Retrieves a car from the workshop
     * @param car the car that is retrieved
     * @return the retrieved car if it was in the workshop
     */
    public T retrieveCar(T car){
        for(T c: storage.getLoadedCars()){
            if(c.equals(car)){
                return c;
            }
        }
        return null;
    }

}
