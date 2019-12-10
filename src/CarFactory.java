import java.awt.*;

public class CarFactory {

    public CarFactory(){
    }

    public Transportable createVolvo(){
        return new Volvo(4, Color.black,"Volvo V70", 120);
    }

    public Transportable createSaab(){
        return new Saab(4, Color.black,"Saab 95", 120);
    }

    public Transportable createScania(){
        return new Volvo(4, Color.black,"Scania", 120);
    }


}
