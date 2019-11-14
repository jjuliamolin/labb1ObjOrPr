import java.awt.*;

public class Saab extends Bil implements Movable{ //fråga: varför räcker det inte att Bil implementerar Movable?
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
        this.trimFactor=1;
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
     *
     * @return state of turbo
     */
    public boolean getTurboState(){
        return turboOn;
    }

    /**
     * Factor which decides how fast the speed should increase or decrease
     * @return enginePower*0.01*turbo
     */
    @Override //Overridear inte eftersom den är private i Bil, vet ej vad som är "rätt".
    public double speedFactor(){
        System.out.println("Saab speedFactor");
        double turbo = 1;
        if(turboOn) {
            turbo = 1.3;
        }
        return (this.getEnginePower() * 0.01 * turbo);
    }



}
