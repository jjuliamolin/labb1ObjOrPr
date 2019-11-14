import org.junit.Test;
import java.awt.*;
import static junit.framework.TestCase.assertEquals;
import java.lang.*;


public class VolvoTest {
    Volvo volvo2 = new Volvo(4, Color.BLACK, "Volvo240", 100);

    @Test
    public void speedFactor(){
        assertEquals(volvo2.speedFactor(), 1.25);
    }
}

