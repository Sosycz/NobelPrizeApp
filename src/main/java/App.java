import connector.NobelPrizeApiConnector;
import prizecomponents.PrizeCategory;

public class App {
    public static void main(String[] args) {
        NobelPrizeApiConnector nobelPrizeApiConnector = new NobelPrizeApiConnector();
//        nobelPrizeApiConnector.getLaureate("Alan Heeger");
//        nobelPrizeApiConnector.getLaureatesFromYear(2000);
        nobelPrizeApiConnector.getLaureatesFromYear(2019, PrizeCategory.ECO);
    }
}
