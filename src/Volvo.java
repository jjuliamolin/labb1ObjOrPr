import java.awt.*;

public class Volvo extends Bil implements Movable{

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
