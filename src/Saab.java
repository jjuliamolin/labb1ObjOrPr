import java.awt.*;

public class Saab extends Car { 
    private boolean turboOn;

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
        System.out.println("turbo ON " + turboOn);
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
         System.out.println("override: speedfactor Saab");
        double turbo = 1;
        if(turboOn) {
            turbo = 1.3;
        }
        return super.speedFactor() * turbo;
    }




}