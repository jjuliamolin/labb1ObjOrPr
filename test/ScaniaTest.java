import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class ScaniaTest {
    Scania scania = new Scania(2, Color.orange, 650);

    @Test
    public void cantRaiseBedIfMoving(){
        //Arrange
        scania.startEngine();
        int expected = scania.getDegreeOfBed();
        //Act
        scania.raise();
        //Assert
        assertEquals(expected, scania.getDegreeOfBed());
    }

    @Test
    public void cantRaiseBedOver70degrees(){
        //Arrange
        scania.stopEngine();
        int expected = 70;
        //Act
        for(;scania.getDegreeOfBed() < 70;) {
            scania.raise();
        }
        //Assert
        assertEquals(expected, scania.getDegreeOfBed());
    }

    @Test
    public void raiseBedRaisesToSpecifiedDegree(){
        //Arrange
        scania.stopEngine();
        int expected = 5;
        //Act
        scania.raise();
        //Assert
        assertEquals(expected,scania.getDegreeOfBed());

    }

    @Test
    public void cantLowerBedBelowZeroDegrees(){
        //Arrange
        scania.stopEngine();
        int expected = 0;
        //Act
        scania.lower();
        //Assert
        assertEquals(expected,scania.getDegreeOfBed());
    }

    @Test
    public void cantStartEngineIfBedIsRaised(){
        //Arrange
        scania.stopEngine();
        scania.raise();
        int expected = 0;
        int actual = 0;
        //Act
        scania.startEngine();
        if(scania.getCurrentSpeed() > 0){
            actual = 1;
        }
        //Assert
        assertEquals(expected, actual);
    }
}
