import java.awt.*;

/**
 * An interface for all objects that can be transported. Has to implement a method to check if the object is loaded, and a method that can change the loaded status.
 * @author Julia Molin, Jacob Allestam
 *
 */
public interface Transportable {
    public boolean getIsLoaded();
    public void setIsLoaded(boolean status);
    public Point getPosition();
    public void turnLeft();
    public void move();
    public void gas(double amount);
    public void brake(double amount);
    public void startEngine();
    public void stopEngine();
    public double getCurrentSpeed();

}
