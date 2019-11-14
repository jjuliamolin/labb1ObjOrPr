import org.junit.Test;
import java.awt.*;
import static junit.framework.TestCase.assertEquals;
import java.lang.*;


public class BilTest {

    Saab saab2 = new Saab(2, Color.RED, "Saab95", 125);
    Volvo volvo2= new Volvo(4,Color.BLACK,"Volvo240", 100);




    @Test
    public void getEnginePower(){
        assertEquals(volvo2.getEnginePower(),100.0);
        assertEquals(saab2.getEnginePower(),125.0);
    }

    @Test
    public void getCurrentSpeed(){
        assertEquals(volvo2.getCurrentSpeed(),0.0);
        assertEquals(saab2.getCurrentSpeed(),0.0);
    }

    @Test //TODO
    public void getNrDoors(){
        assertEquals(saab2.getNrDoors(),2);
        assertEquals(volvo2.getNrDoors(),4);

    }

    @Test
    public void getColor(){
        assertEquals(volvo2.getColor(),Color.BLACK);
        assertEquals(saab2.getColor(),Color.RED);
    }

    @Test
    public void setColor(){
        volvo2.setColor(Color.WHITE);
        saab2.setColor(Color.YELLOW);
        assertEquals(volvo2.getColor(),Color.WHITE);
        assertEquals(saab2.getColor(),Color.YELLOW);
    }

    @Test
    public void turnLeft() {
        saab2.turnLeft();
        assertEquals(saab2.getRiktning(),Bil.NORTH);
    }

    @Test
    public void turnRight(){
        int curDir = saab2.getRiktning();
        saab2.turnRight();
        assertEquals((curDir+1)%4,saab2.getRiktning());
    }


    @Test
    public void getPosition(){
        assertEquals(volvo2.getPosition().x, 0);
        assertEquals(volvo2.getPosition().y, 0);

        assertEquals(saab2.getPosition().x, 0);
        assertEquals(saab2.getPosition().y, 0);
    }

    @Test
    public void startEngine(){
        volvo2.startEngine();
        saab2.startEngine();
        assertEquals(volvo2.getCurrentSpeed(),0.1);
        assertEquals(saab2.getCurrentSpeed(),0.1);
    }

    @Test
    public void stopEngine(){
        volvo2.stopEngine();
        saab2.stopEngine();
        assertEquals(volvo2.getCurrentSpeed(),0.0);
        assertEquals(saab2.getCurrentSpeed(),0.0);

    }



    @Test
    public void turboOn(){ //only for Saab
        saab2.setTurboOn();
        assertEquals(saab2.turboOn,true);
    }

    @Test
    public void setTurboOff(){ //only for Saab
        saab2.setTurboOff();
        assertEquals(saab2.turboOn,false);
    }


    @Test
    public void gasForSaab(){
        //TurboOff
        saab2.setTurboOff();
        saab2.stopEngine();
        saab2.startEngine(); //speed=0.1
        saab2.gas(0.2);
        double expected = 0.1+1.25*0.2;
        assertEquals(expected,saab2.getCurrentSpeed());
    }

    @Test
    public void toMuchGasThrowsExceptionSaab(){
        saab2.setTurboOff();
        saab2.stopEngine();
        saab2.startEngine(); //speed=0.1

        boolean thrown = false;
        try {
            saab2.gas(1.5);
        } catch (RuntimeException e){
            thrown = true;
        }
        assertEquals(thrown, true);
    }


    @Test
    public void gasWhenTurboOnSaab(){
        saab2.setTurboOn();
        double cur = saab2.getCurrentSpeed();
        double expected = cur + (1.25*1.3*0.2);
        saab2.gas(0.2);
        assertEquals(expected,saab2.getCurrentSpeed());
    }


    @Test
    public void brake(){
        saab2.stopEngine();
        saab2.startEngine(); //speed =0.1
        saab2.setTurboOff();
        double expected = saab2.getCurrentSpeed() - (1.25*0.05);
        saab2.brake(0.05);
        assertEquals(expected,saab2.getCurrentSpeed());
    }


    @Test
    public void move(){
        saab2.stopEngine();
        saab2.startEngine(); //speed =0.1
        saab2.move(); //0.1*10 -> borde flyttats 1.0 i x-led.
        assertEquals(saab2.getPosition().x, 1);
        assertEquals(saab2.getPosition().y, 0);

        saab2.turnRight();
        saab2.gas(0.2);//new speed is 0.35, (int) ger 3
        saab2.move(); //borde flyttats 3 steg nedåt i y-led.
        assertEquals(saab2.getPosition().x,1);
        assertEquals(saab2.getPosition().y,-3);
    }


}

