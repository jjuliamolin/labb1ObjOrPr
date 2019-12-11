import java.awt.*;
import java.lang.RuntimeException;

public abstract class Car extends Vehicle implements ICar {

    private int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    /**
     * Constructs a Car, with specified nr of doors, color, modelName and engine power.
     * @param nrDoors
     * @param color
     * @param modelName
     * @param enginePower
     */
    public Car(int nrDoors, Color color, String modelName, double enginePower){
        super(enginePower);
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
    }

    public String getModelName(){
        return modelName;
    }

    /**
     *
     * @return nrDoors
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     *
     * @return color
     */
    public Color getColor(){
        return color;
    }
    /**
     * @param clr
     */
    public void setColor(Color clr){
        color = clr;
    }


}