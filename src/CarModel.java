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


    public void addCar(String name){ //TODO: generalisera. gör bara saab nu.
        if(name.equals("volvo")){
            listOfTransportables.add(factory.createVolvo());
        }
        else if(name.equals("saab")){
            listOfTransportables.add(factory.createSaab());
        }
        else if(name.equals("scania")){
            listOfTransportables.add(factory.createScania());
        }
        else{
            System.out.println("Not a valid name");
        }
        listener.actOnUpdate();
    }

    public ArrayList<Transportable> getTransportableList(){
        return listOfTransportables;
    }

    public void removeLastCar(){
        listOfTransportables.remove(listOfTransportables.size() - 1);
    }

    public void addCarListener(CarListener carListener){
        this.listener = carListener;
    }


}
