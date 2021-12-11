import connector.NobelPrizeApiConnector;

public class App {
    public static void main(String[] args) {
        NobelPrizeApiConnector nobelPrizeApiConnector = new NobelPrizeApiConnector();
        nobelPrizeApiConnector.getLaureate("Alan Heeger");
        nobelPrizeApiConnector.getLaureatesFromYear(2000);
    }
}
