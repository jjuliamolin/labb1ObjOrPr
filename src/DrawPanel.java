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

    private ArrayList<Transportable> transportableList;


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {

        imageList = new ArrayList<>();
        transportableList = new ArrayList<>();

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);



    }



    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < imageList.size(); i++){
            g.drawImage(imageList.get(i), transportableList.get(i).getPosition().x,transportableList.get(i).getPosition().y + i*100,null);
        }
    }

    //Vi tänkte använda observer pattern men det behövdes inte då vi uppdaterar kontinuerligt i CarController. Låter metoden ligga kvar
    //då den är kopplad och kan användas i framtida utbyggnad.
    @Override
    public void actOnUpdate() {
        System.out.println("act on update");
    }


    public void addVisualCar(String s){ // Print an error message in case file is not found with a try/catch block
        String pic = "";
        String volvo = "pics/Volvo240.jpg";
        String saab = "pics/Saab95.jpg";
        String scania =  "pics/Scania.jpg";

    if(s.equals("volvo")) pic = volvo;
    else if(s.equals("saab")) pic = saab;
    else if(s.equals("scania")) pic = scania;

        try {
            imageList.add(ImageIO.read(DrawPanel.class.getResourceAsStream(pic)));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    public void removeLastVisualCar(){
        imageList.remove(imageList.size() - 1);
    }

    public void setTransportableList(ArrayList<Transportable> tList){
        transportableList = tList;
    }



}
