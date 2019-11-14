import java.awt.*;

public class Volvo extends Car {
    private final static double trimFactor = 1.25;

    /**
     * Constructs a Volvo which extends Bil.
     * @param nrDoors
     * @param color
     * @param modelName
     * @param enginePower
     */
    public Volvo(int nrDoors, Color color, String modelName, double enginePower){
        super(nrDoors, color, modelName, enginePower);

    }
    @Override
    public double speedFactor(){
        return super.speedFactor()*trimFactor;
    }


}
