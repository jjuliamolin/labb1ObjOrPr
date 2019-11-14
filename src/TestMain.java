import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.awt.Color;

public class TestMain{


    public static void main(String[] args) {



        Saab saab1 = new Saab(2,Color.red, "Saab95", 125);
        System.out.println(saab1.getPosition());
        saab1.startEngine();
        saab1.move();
        System.out.println(saab1.getPosition());




    }



    /* Saab värden
     // nrDoors = 2;
        // color = Color.red;
        // enginePower = 125;
	    // turboOn = false;
        // modelName = "Saab95";
        // stopEngine();


        Volvo:
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();

    */

}