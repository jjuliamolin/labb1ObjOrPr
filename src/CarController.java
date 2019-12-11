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
    private int delay = 50; // The delay (ms) corresponds to 20 updates a sec (hz)
    private Timer timer = new Timer(delay, new TimerListener()); //The timer is started with an listener (see below) that executes the statements each step between delays.
    private CarView frame = new CarView("CarSim 1.0");   // The frame that represents this instance View of the MVC pattern
    private CarModel model = new CarModel(); //M



    public void start(){
        addActionListeners();
        model.addCarListener(this.frame.drawPanel);

        addCar("volvo");
        addCar("saab");
        addCar("saab");
        addCar("scania");

        // Start the timer
        timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Transportable car : model.getTransportableList()) {
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
                //frame.drawPanel.moveit(cars.indexOf(car), x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                frame.speedView.repaint();
            }
        }
    }

    private void addCar(String name){
        model.addCar(name);
        updateTransportableList();
        frame.drawPanel.addVisualCar(name);
    }

    public void removeCar(){
        model.removeLastCar();
        updateTransportableList();
        frame.drawPanel.removeLastVisualCar();
    }

    private void updateTransportableList(){
        frame.drawPanel.setTransportableList(model.getTransportableList());
        frame.speedView.setListOfCars(model.getTransportableList());
    }

    private void addActionListeners() {
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = (double) frame.gasAmount / 100;
                for (Transportable car : model.getTransportableList())
                    car.gas(amount);
            }
        });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double brake = ((double) frame.gasAmount) / 100;
                for (Transportable car : model.getTransportableList()) {
                    car.brake(brake);
                }
            }
        });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Transportable car : model.getTransportableList()) {
                    car.startEngine();
                }
            }
        });

        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Transportable car : model.getTransportableList()) {
                    car.stopEngine();
                }
            }
        });

        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Transportable car : model.getTransportableList()) {
                    // Create interface "turbochargeable" for this and similar for the scania
                    if (car instanceof Saab) { //TODO vill ej bero på Saab, hur löser vi denna?
                        ((Saab) car).setTurboOn();
                    }
                }
            }
        });

        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Transportable car : model.getTransportableList()) {
                    if (car instanceof Saab) { //TODO vill ej bero på Saab, hur löser vi denna?
                        ((Saab) car).setTurboOff();
                    }
                }
            }
        });

        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Transportable car : model.getTransportableList()) {
                    if (car instanceof Scania) { //TODO vill ej bero på Scania, hur löser vi denna?
                        ((Scania) car).raise();
                    }
                }
            }
        });

        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Transportable car : model.getTransportableList()) {
                    if (car instanceof Scania) {  //TODO vill ej bero på Scania, hur löser vi denna?
                        ((Scania) car).lower();
                    }
                }
            }
        });
    }




}


