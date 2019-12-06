import java.util.ArrayList;

/**
 * Creates a car ferry that can hold up to 10 cars. 
 * @author Jacob Allestam, Julia Molin
 *
 */
public class Ferry extends Vehicle implements Transporter<Car> {
    private Storage<Car> storage;
    
    public Ferry(double enginePower){
        super(enginePower);

        storage = new Storage<>(10);
    }
    
    /**
     * Loads the a car to the ferry if it is close enough
     * @param car the car loaded to the ferry
     */
    public void load(Car car){
        if(isClose(car)){
            storage.load(car);
        }
        else {
            System.out.println("Not close enough");
        }
    }
    
    /**
     * Unloads a car from the ferry if the ferry is not empty.
     */
    public Car unload(){
    	if(!storage.getLoadedCars().isEmpty()) {
    		Car car = storage.unload(0);
    		car.setPosition(getPosition().x - 2, getPosition().y - 2);
    		return car;
    	}
    	else {
    		return null;
    	}
    }

    public ArrayList<Car> getLoadedCars(){
        return storage.getLoadedCars();
    }
    
    /**
     * Moves the ferry in the direction it is facing along with all the cars inside.
     */
    @Override
    public void move(){
        super.move();
        for(Car c : storage.getLoadedCars()){
            c.setPosition(getPosition().x,getPosition().y);
        }
    }
}
