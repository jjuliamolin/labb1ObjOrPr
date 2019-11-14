import java.awt.*;
import java.lang.RuntimeException;

public abstract class Car implements Movable {
    public static final int EAST =0;
    public static final int SOUTH =1;
    public static final int WEST =2;
    public static final int NORTH =3;

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Point position;
    private int direction;


    /**
     * Constructs a Car, with specified nr of doors, color, modelName and engine power.
     * @param nrDoors
     * @param color
     * @param modelName
     * @param enginePower
     */
    public Car(int nrDoors, Color color, String modelName, double enginePower){
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.enginePower =enginePower;
        this.position = new Point();
        this.direction = Car.EAST;
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
     * @return enginePower
     */
    public double getEnginePower(){
        return enginePower;
    }
    /**
     *
     * @return currentSpeed
     */

    public double getCurrentSpeed(){
        return currentSpeed;
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
    /**
     * Gets position
     * @return position
     */
    public Point getPosition(){
        return position;
    }


    /**
     * starts the engine
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }
    /**
     * stops the Engine
     */

    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     *
     * @return riktning
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Factor of how much the speed will increase/decrease.
     * @return enginePower*0.01*trimFactor
     */
    public double speedFactor(){
        return enginePower * 0.01 ;
    }

    /**
     * increases the speed
     * @param amount
     */
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);  //tar det minsta värdet av enginePower och ökning.
    }

    /**
     * decreases the speed
     * @param amount
     */
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }


    /**
     * move the vehicle to a new position, depending on the speed.
     */
    public void move(){
        if (this.currentSpeed ==0){
            throw new RuntimeException("can't move if engine is off");
        }


        if(direction == Car.EAST){
            this.position.x = (int)(this.position.x +(10*this.currentSpeed));
        }

        else if(direction == Car.SOUTH){
            this.position.y = (int)(this.position.y -(10*this.currentSpeed));
        }

        else if(direction == Car.WEST){
            this.position.x = (int)(this.position.x -(10*this.currentSpeed));
        }

        else if(direction == Car.NORTH){
            this.position.y = (int)(this.position.y +(10*this.currentSpeed));
        }
    }



    /**
     * increment the speed
     * @param amount
     */
    public void gas(double amount){
        if(amount<=1 && amount >=0)
            incrementSpeed(amount);
        else
            throw new RuntimeException("otillåtet värde");
    }
    /**
     * decrement the speed
     * @param amount
     */
    public void brake(double amount){
        if(amount<=1 && amount >=0)
            decrementSpeed(amount);
        else
            throw new RuntimeException("otillåtet värde");

    }





    /**
     * the vehicle turns left. change direction.
     */
    public void turnLeft(){
        this.direction = (this.direction -1+4)%4;
    }

    /**
     * the vehicle turns right, changes direction.
     */
    public void turnRight(){
        this.direction = (this.direction +1)%4;

    }
}