import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    private final int delay = 50;  // The delay (ms) corresponds to 20 updates a sec (hz)
    private Timer timer = new Timer(delay, new TimerListener()); // The timer is started with an listener (see below) that executes the statements
                                                                // each step between delays.
    private CarView frame; //en JFrame     // The frame that represents this instance View of the MVC pattern

    ArrayList<Vehicle> cars = new ArrayList<>(); // A list of cars, modify if needed

    //methods:

    public static void main(String[] args) {
        CarController cc = new CarController();  //       // Instance of this class
        cc.cars.add(new Saab(4, Color.BLACK, "Saab95",120)); //lägger till i listan
        cc.cars.add(new Volvo(4, Color.RED, "Volvo240",120)); //lägger till i listan
        cc.cars.add(new Scania(4, Color.BLACK, 520)); //lägger till i listan

        cc.frame = new CarView("CarSim 1.0", cc); // Start a new view and send a reference of self
        cc.timer.start(); // Start the timer
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
               int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                x=x%800; // modulo 800 (bredden på CarView)

                frame.drawPanel.moveit(x, y); //TODO en parameter till, car?
                frame.drawPanel.repaint(); // repaint() calls the paintComponent method of the panel
                System.out.println(car.toString() + ": speed: " +  car.getCurrentSpeed() + "   pos: " + car.getPosition());
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
                ) {
            car.gas(gas);
        }
    }


    //------TESTAR--------//
    void startEngine() {
        for (Vehicle car : cars
        ) {
            car.startEngine();
        }
    }


    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.brake(brake);
        }
    }

    void stopEngine() {
        for (Vehicle car : cars
        ) {
            car.stopEngine();
        }
    }

    void turboOn(){
        for (Vehicle car: cars) {
            car.setTurboOn();
        }
    }


    //--------------------//
}
