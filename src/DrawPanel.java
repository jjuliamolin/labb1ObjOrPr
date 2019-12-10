import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements CarListener{
    private ArrayList<BufferedImage> imageList;
    private ArrayList<Point> pointList;

    void moveit(int index,int x, int y){
        pointList.get(index).x = x;
        pointList.get(index).y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        pointList = new ArrayList<>();
        imageList = new ArrayList<>();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        addVisualCar("volvo");
        addVisualCar("saab");
        addVisualCar("scania");

        for(int i = 0; i < imageList.size(); i++){
            pointList.add(new Point());
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < imageList.size(); i++){
            g.drawImage(imageList.get(i),pointList.get(i).x,pointList.get(i).y + i*100,null);
        }
    }


    //TODO
    @Override
    public void actOnUpdate() {
        //for alla bilar, repaint
    }

    //TODO ska denna metoden vara här?
    public void addVisualCar(String s){ // Print an error message in case file is not found with a try/catch block
        String pic = "";
    String volvo = "pics/Volvo240.jpg";
    String saab = "pics/Saab95.jpg";
    String scania =  "pics/Scania.jpg";

    if(s.equals("volvo")) pic =volvo;
    else if(s.equals("saab")) pic =saab;
    else if(s.equals("scania")) pic =scania;

        try {
            imageList.add(ImageIO.read(DrawPanel.class.getResourceAsStream(pic)));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }



}
