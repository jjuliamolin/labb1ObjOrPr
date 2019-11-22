import java.awt.*;
import java.util.ArrayList;

/**
 * A class for objects that can store other objects. The objects that are able to store implements storage. 
 * @author Jacob Allestam, Julia Molin
 *
 * @param <T> Can store all objects that inherit from Car. 
 */
public class Storage<T extends Car>{
    private int maxNumberOfCars;
    private ArrayList<T> loadedCars;

    public Storage(int max){
        maxNumberOfCars = max;
        loadedCars = new ArrayList<>();
    }
    
    
    public ArrayList<T> getLoadedCars(){
        return loadedCars;
    }

    /**
     * Loads the Storage with a new car assuming it is not full. It can not load a transporter or itself.
     * @param car the car which is loaded to the Storage
     */
    public void load(T car){
        if((!(car instanceof CarTransport)) && loadedCars.size() < maxNumberOfCars && !car.getIsLoaded()){
                loadedCars.add(car);
                car.setIsLoaded(true);
        }
    }
    
    /**
     * Unloads the car if there are any cars in the storage
     * @param index the index of the car to unload
     * @return the unloaded car
     */
    public Car unload(int index){
        if(loadedCars.isEmpty()){
            System.out.println("Nothing is stored");
            return null;
        }
        else {
            Car unloaded = loadedCars.remove(index);
            unloaded.setIsLoaded(false);
            return unloaded;
        }
    }




}
