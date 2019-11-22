import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class FerryTest {
    private Ferry ferry = new Ferry(500);

    @Test
    public void loadTest(){
        //Arrange
        Saab saab = new Saab(2, Color.black, "Saab", 200);
        //Act
        ferry.load(saab);
        //Assert
        assertEquals(ferry.getLoadedCars().size(),1);
    }

    @Test
    public void unloadTest(){
        //Arrange
        Saab saab = new Saab(2,Color.black,"Saab",200);
        ferry.load(saab);
        Saab expected = saab;
        //Act
        Saab actual = (Saab) ferry.unload();
        //Assert
        assertEquals(actual,expected);

    }
}
