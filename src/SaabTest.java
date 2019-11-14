import org.junit.Test;
import java.awt.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.lang.*;


public class SaabTest {
    Saab saab = new Saab(2, Color.RED, "Saab95", 125);

    @Test
    public void turboOn() { //only for Saab
        saab.setTurboOn();
        assertEquals(saab.turboOn, true);
    }

    @Test
    public void setTurboOff() { //only for Saab
        saab.setTurboOff();
        assertEquals(saab.turboOn, false);
    }
    @Test
    public void toMuchGasThrowsExceptionSaab() {
        saab.setTurboOff();
        saab.stopEngine();
        saab.startEngine(); //speed=0.1

        boolean thrown = false;
        try {
            saab.gas(1.5);
        } catch (RuntimeException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }



    @Test
    public void gasWhenTurboOnSaab() {
        saab.setTurboOn();
        double cur = saab.getCurrentSpeed();
        double expected = cur + (1.25 * 1.3 * 0.2);
        saab.gas(0.2);
        assertEquals(expected, saab.getCurrentSpeed());
    }
}
