public class CarApplication {
    CarController cc = new CarController();

    public static void main(String[] args) {
    CarApplication app = new CarApplication();
        app.start();
    }

    public void start(){
       cc.start();
    }
}
