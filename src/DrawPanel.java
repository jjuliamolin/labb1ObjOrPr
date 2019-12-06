import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    //BufferedImage image;  // Just a single image, TODO: Generalize
   ////// ArrayList<BufferedImage> images = new ArrayList<>();
    //Point point = new Point();  // To keep track of a singel cars position
    //////ArrayList<Point> points = new ArrayList<>();

    private ArrayList<ImageAndPoint> listOfImAndPoints = new ArrayList<>();

    String volvoPic = "pics/Volvo240.jpg";
    String saabPic = "pics/Saab95.jpg";
    String scaniaPic = "pics/Scania.jpg";


    ////////////
    private class ImageAndPoint{
        BufferedImage im;
        Point p;

         ImageAndPoint(BufferedImage im,Point p){
            this.im = im;
            this.p =p;
        }
    }
//////////


    // TODO: Make this general for all cars
    void moveit(int x, int y){ //TODO: blir nog fel här. anropas från timelistner. om vi tar in en car. så kan vi kolla om den är lika med någon i list of imp
        for (ImageAndPoint imp:listOfImAndPoints) {
            imp.p.x=x;
            imp.p.y=y;
        }
        /////point.x = x;
        /////point.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> list) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);


        // Print an error message in case file is not found with a try/catch block
        try {

            /*
                for (Vehicle car : list) {
                    if (car instanceof Volvo) {
                        System.out.println("is a volvo");
                        images.add(ImageIO.read(DrawPanel.class.getResourceAsStream(volvoPic)));
                        points.add(new Point());
                    } else if (car instanceof Saab) {
                        BufferedImage im = ImageIO.read(DrawPanel.class.getResourceAsStream(saabPic));
                        images.add(im);
                        points.add(new Point());
                    } else if (car instanceof Scania) {
                        images.add(ImageIO.read(DrawPanel.class.getResourceAsStream(scaniaPic)));
                        points.add(new Point());
                    }
                    else return;
                }

             */

            for (Vehicle car : list) {
                if (car instanceof Volvo) {
                    ImageAndPoint v = new ImageAndPoint(ImageIO.read(DrawPanel.class.getResourceAsStream(volvoPic)),new Point());
                    listOfImAndPoints.add(v);
                } else if (car instanceof Saab) {
                    ImageAndPoint s = new ImageAndPoint(ImageIO.read(DrawPanel.class.getResourceAsStream(saabPic)),new Point());
                    listOfImAndPoints.add(s);
                } else if (car instanceof Scania) {
                    ImageAndPoint sc = new ImageAndPoint(ImageIO.read(DrawPanel.class.getResourceAsStream(scaniaPic)),new Point());
                    listOfImAndPoints.add(sc);
                }
                else return;
            }


           //image = ImageIO.read(DrawPanel.class.getResourceAsStream(volvoPic)); //testar?
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int diff=0;
        /*
        for (BufferedImage image: images) {
            //g.drawImage(image, point.x, point.y+x, null); // see javadoc for more info on the parameters
            g.drawImage(image, point.x, point.y+x, null);
            x=x+100;
        }

         */

        for (ImageAndPoint imp:listOfImAndPoints) {
            g.drawImage(imp.im, imp.p.x, imp.p.y+diff, null);
            diff+=100;
        }
    }
}
