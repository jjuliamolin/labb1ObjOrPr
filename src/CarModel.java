import java.util.ArrayList;

public class CarModel {
    private ArrayList<Transportable> listOfTransportables;
    private ArrayList<Transporter> listOfTransporters;
    private CarFactory factory;
    private CarListener listener;


    public void addCar(){
        listOfTransportables.add(factory.createSaab());
        listener.actOnUpdate();
    }


}
