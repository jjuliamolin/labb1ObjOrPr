import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class CarTransportTest {
    CarTransport transport = new CarTransport(2, Color.black, 700);

    @Test
    public void raiseRampTest(){
        //Arrange
        transport.stopEngine();
        transport.lower();
        transport.startEngine();
        //Act
        transport.raise();
        //Assert
        assertEquals(false, transport.getRampPosition());
    }

    @Test
    public void testLoadCar(){
        //Arrange
        transport.stopEngine();
        transport.lower();
        Saab expected = new Saab(2,Color.yellow,"Saab95",150);
        //Act
        transport.load(expected);
        //Assert
        assertEquals(1,transport.getLoadedCars().size());
        assertEquals(expected,transport.getLoadedCars().get(0));
    }
}
