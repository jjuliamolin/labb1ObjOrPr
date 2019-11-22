import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

public class WorkshopTest {
	
	Workshop<Saab> saabWorkshop = new Workshop<>(10);
	Workshop<Volvo> volvoWorkshop = new Workshop<>(10);

	
	@Test
	public void testLoadCar() {
		//Arrange
		Saab saab = new Saab(2,Color.ORANGE,"Saab", 300);
		//Act
		saabWorkshop.loadCar(saab);
		//Assert
		assertEquals(saabWorkshop.storage.getLoadedCars().size(),1);
	}

	@Test
	public void testRetrieveCar() {
		//Arrange
		Saab saab = new Saab(2,Color.ORANGE,"Saab", 300);
		saabWorkshop.loadCar(saab);
		Saab expected = saab;
		//Act
		Saab actual = saabWorkshop.retrieveCar(saab);
		//Assert
		assertEquals(expected,actual);
	}

}
