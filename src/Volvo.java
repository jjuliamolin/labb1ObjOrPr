import java.awt.*;

public class Volvo extends Bil implements Movable{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name

    /**
     * Constructs a Volvo which extends Bil.
     * @param nrDoors
     * @param color
     * @param modelName
     * @param enginePower
     */
    public Volvo(int nrDoors, Color color, String modelName, double enginePower){
        super(nrDoors, color, modelName, enginePower);
        this.trimFactor=1.25;
    }



}
