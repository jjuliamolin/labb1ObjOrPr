import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame = new CarView("CarSim 1.0", this);
    ;
    // A list of cars, modify if needed
    private ArrayList<Car> cars = new ArrayList<>();


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo(2, Color.black, "Volvo", 200));
        cc.cars.add(new Saab(2, Color.red, "Saab", 200));
        cc.cars.add(new Scania(2, Color.cyan, 100));
        cc.addActionListeners();

        // Start a new view and send a reference of self
        //cc.frame = new CarView("CarSim 1.0", cc); //initierar ovan istället -funkar

        // Start the timer
        cc.timer.start();

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                if (car.getPosition().getX() > 700) {
                    car.turnLeft();
                    car.turnLeft();
                } else if (car.getPosition().getX() < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }
                car.move();
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                frame.drawPanel.moveit(cars.indexOf(car), x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    public void addActionListeners() {
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = (double) frame.gasAmount / 100;
                for (Car car : cars)
                    car.gas(amount);
            }
        });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double brake = ((double) frame.gasAmount) / 100;
                for (Car car : cars) {
                    car.brake(brake);
                }
            }
        });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : cars) {
                    car.startEngine();
                }
            }
        });

        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : cars) {
                    car.stopEngine();
                }
            }
        });

        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : cars) {
                    if (car instanceof Saab) { //TODO vill ej bero på Saab, hur löser vi denna?
                        ((Saab) car).setTurboOn();
                    }
                }
            }
        });

        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : cars) {
                    if (car instanceof Saab) { //TODO vill ej bero på Saab, hur löser vi denna?
                        ((Saab) car).setTurboOff();
                    }
                }
            }
        });

        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : cars) {
                    if (car instanceof Scania) { //TODO vill ej bero på Scania, hur löser vi denna?
                        ((Scania) car).raise();
                    }
                }
            }
        });

        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : cars) {
                    if (car instanceof Scania) {  //TODO vill ej bero på Scania, hur löser vi denna?
                        ((Scania) car).lower();
                    }
                }
            }
        });
    }




}


