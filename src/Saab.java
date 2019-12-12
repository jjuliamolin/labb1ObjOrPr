import java.awt.*;

public class Saab extends Car implements TurboChargeable {
    public boolean turboOn;

    /**
     * Constructs a Saab which extends Car.
     * turboOn is false by default.
     * @param nrDoors
     * @param color
     * @param modelName
     * @param enginePower
     */
    public Saab(int nrDoors, Color color, String modelName, double enginePower){
        super(nrDoors, color, modelName, enginePower);
        this.turboOn =false;

    }

    /**
     * setTurboOn
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * set TurboOff
     */
    public void setTurboOff(){
        turboOn = false;
    }


    /**
     * Factor which decides how fast the speed should increase or decrease
     * @return enginePower*0.01*turbo
     */
     @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) {
            turbo = 1.5;
        }
        return super.speedFactor() * turbo;
    }



}