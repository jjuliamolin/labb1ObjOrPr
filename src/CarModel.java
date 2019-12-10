import java.util.ArrayList;

public class CarModel {
    private ArrayList<Transportable> listOfTransportables;
    private ArrayList<Transporter> listOfTransporters;
    private CarFactory factory;
    private CarListener listener;


    public CarModel(){
        listOfTransportables = new ArrayList<>();
        listOfTransporters = new ArrayList<>();
        factory = new CarFactory();
    }


    public void addCar(){ //TODO: generalisera. gör bara saab nu.
        listOfTransportables.add(factory.createSaab());
        listener.actOnUpdate();
    }

    public void addCarListener(CarListener carListener){
        this.listener=carListener;
    }


}
