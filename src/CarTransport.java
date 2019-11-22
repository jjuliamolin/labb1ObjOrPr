import java.awt.*;
import java.util.ArrayList;

/**
 * Creates a Car transporter which can hold up to 10 cars. The ramp is initially up.
 */
public class CarTransport extends Car implements Truck,Transporter<Car> {
    private boolean rampIsUp;
    private Storage<Car> storage;

    public CarTransport(int nrDoors, Color color, double EnginePower){
        super(nrDoors,color,"Transporter", EnginePower);
        rampIsUp = true;
        storage = new Storage<>(10);
    }

    /**
     * Raises the ramp fully
     */
    public void raise(){
        if(getCurrentSpeed() == 0){
            rampIsUp = true;
        }
    }

    /**
     * Lowers the ramp fully to allow cars to be loaded to the Transporter.
     */
    public void lower(){
        if(getCurrentSpeed() == 0){
            rampIsUp = false;
        }
    }

    /**
     * @return the position of the ramp
     */
    public boolean getRampPosition(){
        return rampIsUp;
    }

    /**
     * @return the Stack of cars loaded to the transporter
     */
    public ArrayList<Car> getLoadedCars(){
        return storage.getLoadedCars();
    }

    /**
     * Loads the Transporter with a new car assuming it is not full and the ramp is down. It can not load another transporter or itself.
     * The car needs to be close enough to the Transporter and face in the same direction in order to load.
     * @param car the car which is loaded to the Transporter
     */
    public void load(Car car){
        if(isClose(car)){
            storage.load(car);
        }
        else{
            System.out.println("Not close enough");
        }
    }

    /**
     * Unloads the last car from the Transporter assuming it is not empty. Places the car nearby.
     */
    public Car unload(){
        if(!rampIsUp) {
            Car car = storage.unload(storage.getLoadedCars().size()-1);
            car.setPosition(getPosition().x - 2, getPosition().y - 2);
            return car;
        }
        return null;
    }

    /**
     * Moves the Transporter along with all the cars inside
     */
    public void move(){
        super.move();
        for(Car car: storage.getLoadedCars()){
            car.setPosition(getPosition().x, getPosition().y);
        }
    }

    /**
     * Makes sure the engine can't start if the ramp is down
     */
    public void startEngine(){
        if(!rampIsUp){
            super.startEngine();
        }
    }

}
