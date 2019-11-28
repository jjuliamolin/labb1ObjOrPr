import java.awt.*;
/**
 * Creates a vehicle which has a position and can move around. Implements the movable and transportable interfaces. Initially faces east, on coordinates (0,0).
 * @author Julia Molin, Jacob Allestam
 *
 */
public abstract class Vehicle implements Movable,Transportable {
    public static final int EAST =0;
    public static final int SOUTH =1;
    public static final int WEST =2;
    public static final int NORTH =3;
    private double currentSpeed; // The current speed of the Vehicle
    private double enginePower; // Engine power of the Vehicle
    private Point position;
    private int direction;
    private boolean isLoaded;

    public Vehicle(double enginePower){
        this.enginePower = enginePower;
        this.position = new Point();
        this.direction = EAST;
        this.isLoaded = false;
    }

    /**
     *
     * @return currentSpeed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Gets position
     * @return position
     */
    public Point getPosition(){
        return position;
    }

    /**
     *
     * @return enginePower
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Sets a new position for the car.
     * @param x the x position
     * @param y the y position
     */
    protected void setPosition(int x, int y){
        position.x = x;
        position.y = y;
    }

    /**
     * starts the engine
     */
    public void startEngine(){
        if(!isLoaded){
            currentSpeed = 0.1;
        }
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
    private void incrementSpeed(double amount){
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

        }
        else if(direction == Car.EAST){
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
        if(currentSpeed > 0 && !isLoaded) {
            if (amount <= 1 && amount >= 0)
                incrementSpeed(amount);
            else if (amount > 1) {
                incrementSpeed(1);
            } else {
                incrementSpeed(0);
            }
        }
    }

    /**
     * decrement the speed
     * @param amount
     */
    public void brake(double amount){
        if(currentSpeed > 0 && !isLoaded) {
            if (amount <= 1 && amount >= 0)
                decrementSpeed(amount);
            else if (amount > 1) {
                decrementSpeed(1);
            } else {
                decrementSpeed(0);
            }
        }
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

    /**
     * Checks if a vehicle is within 2 units.
     * @param v the vehicle in proximity
     * @return True if the vehicle is close enough
     */
    public boolean isClose(Vehicle v){
        if(Point.distance(v.getPosition().x,v.getPosition().y,getPosition().x,getPosition().y) <= 2){
            return true;
        }
        return false;
    }
    
    /**
     * Getter for isLoaded. Checks if the Vehicle is currently loaded.
     * @return true if it is loaded.
     */
    public boolean getIsLoaded(){
        return isLoaded;
    }
    
    /**
     * Sets the vehicle status to loaded. 
     */
    public void setIsLoaded(boolean status){
        isLoaded = status;
    }
}
