import java.awt.*;

/**
 * Makes a Scania which extends Car
 * The bed starts with no tilt, it is parallel to the ground.
 */
public class Scania extends Car implements Truck{
    private int degreeOfBed;

    public Scania(int nrDoors, Color color, double EnginePower){
        super(nrDoors,color,"Scania",EnginePower);
        degreeOfBed = 0;
    }

    /**
     * Raises the bed by 5 degrees
     */
    public void raise(){
        if(getCurrentSpeed() == 0) {
            degreeOfBed = Math.min(degreeOfBed + 5, 70);
        }
    }

    /**
     * Lowers the bed by 5 degrees
     */
    public void lower(){
        if(getCurrentSpeed() == 0) {
            degreeOfBed = Math.max(degreeOfBed - 5, 0);
        }
    }

    /**
     *
     * @return the tilt of the bed
     */
    public int getDegreeOfBed(){
        return degreeOfBed;
    }

    /**
     * Makes sure the engine can't start if the bed is tilted
     */
    @Override
    public void startEngine(){
        if(degreeOfBed == 0){
            super.startEngine();
        }
    }

}
