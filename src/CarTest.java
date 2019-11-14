import org.junit.Test;
import java.awt.*;
import static junit.framework.TestCase.assertEquals;


public class CarTest {


    Saab car = new Saab(2, Color.RED, "car1", 125.0) ;
    //om testet ska vara av statisk typ Car, ta bort abstract i Car class.




    @Test
    public void getEnginePower() {

        assertEquals(car.getEnginePower(), 125.0);
    }

    @Test
    public void getCurrentSpeed() {

        assertEquals(car.getCurrentSpeed(), 0.0);
    }

    @Test //TODO
    public void getNrDoors() {
        assertEquals(car.getNrDoors(), 2);


    }

    @Test
    public void getColor() {

        assertEquals(car.getColor(), Color.RED);
    }

    @Test
    public void setColor() {
        car.setColor(Color.YELLOW);
        assertEquals(car.getColor(), Color.YELLOW);
    }

    @Test
    public void turnLeft() {
        car.turnLeft();
        assertEquals(car.getDirection(), Car.NORTH);
    }

    @Test
    public void turnRight() {
        int curDir = car.getDirection();
        car.turnRight();
        assertEquals((curDir + 1) % 4, car.getDirection());
    }


    @Test
    public void getPosition() {

        assertEquals(car.getPosition().x, 0);
        assertEquals(car.getPosition().y, 0);
    }

    @Test
    public void startEngine() {
        car.startEngine();
        assertEquals(car.getCurrentSpeed(), 0.1);
    }

    @Test
    public void stopEngine() {
        car.stopEngine();
        assertEquals(car.getCurrentSpeed(), 0.0);

    }





    @Test
    public void gas() {

        car.stopEngine();
        car.startEngine(); //speed=0.1
        car.gas(0.2);
        double expected = 0.1 + 1.25 * 0.2;
        assertEquals(expected, car.getCurrentSpeed());
    }




    @Test
    public void brake() {
        car.stopEngine();
        car.startEngine(); //speed =0.1
        car.setTurboOff();
        double expected = car.getCurrentSpeed() - (1.25 * 0.05);
        car.brake(0.05);
        assertEquals(expected, car.getCurrentSpeed());
    }


    @Test
    public void move() {
        car.stopEngine();
        car.startEngine(); //speed =0.1
        car.move(); //0.1*10 -> borde flyttats 1.0 i x-led.
        assertEquals(car.getPosition().x, 1);
        assertEquals(car.getPosition().y, 0);

        car.turnRight();
        car.gas(0.2);//new speed is 0.35, (int) ger 3
        car.move(); //borde flyttats 3 steg nedåt i y-led.
        assertEquals(car.getPosition().x, 1);
        assertEquals(car.getPosition().y, -3);

        car.turnRight();
        car.move(); //borde nu flyttas 3 steg i x-led, alltså till -2
        assertEquals(car.getPosition().x, -2);
        assertEquals(car.getPosition().y,-3);

        car.turnRight();
        car.move();
        assertEquals(car.getPosition().x,-2);
        assertEquals(car.getPosition().y,0);

    }


}