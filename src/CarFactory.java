import java.awt.*;

public class CarFactory {

    public CarFactory(){
    }

    public Transportable createVolvo(){
        return new Volvo(4, Color.black,"Volvo V70", 200);
    }

    public Transportable createSaab(){
        return new Saab(4, Color.red,"Saab 95", 200);
    }

    public Transportable createScania(){
        return new Volvo(4, Color.cyan,"Scania", 100);
    }


}
