import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    ArrayList<BufferedImage> imageList;

    // To keep track of a single cars position
    private ArrayList<Point> pointList;

    // TODO: Make this general for all cars
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
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Remember to right click src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            imageList.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            imageList.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            imageList.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
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
}
