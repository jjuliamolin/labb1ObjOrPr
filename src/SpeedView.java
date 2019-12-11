import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpeedView extends JPanel {

    ArrayList<Transportable> cars;

    public SpeedView(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);

       cars = new ArrayList<Transportable>();
    }

    public void setListOfCars(ArrayList<Transportable> list){
        cars = list;
    }

    public String printNameAndSpeed(){
        String nameAndSpeedStr ="";

        for(Transportable car:cars){
            if(car instanceof ICar){
                String modelName = ((ICar) car).getModelName();
                double speed = car.getCurrentSpeed();
                nameAndSpeedStr += modelName + " " + speed + "         ";
            }
        }
        return nameAndSpeedStr;
    }

    protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawString(printNameAndSpeed(),0,10);
    }





}
