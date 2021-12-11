import connector.NobelPrizeApiConnector;

public class App {
    public static void main(String[] args) {
        NobelPrizeApiConnector nobelPrizeApiConnector = new NobelPrizeApiConnector();
        nobelPrizeApiConnector.getLaureate("wilhelm");
        nobelPrizeApiConnector.getLaureatesFromYear(2000);
    }
}
