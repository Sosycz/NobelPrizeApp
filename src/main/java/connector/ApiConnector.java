package connector;

import model.Laureate;
import model.PrizeCategory;

import java.util.List;

public interface ApiConnector {

    public List<Laureate> getLaureatesByName(String name);

    public List<Laureate> getLaureatesByYearAndCategory(int year, PrizeCategory category);

    public List<Laureate> getLaureatesByYear(int year);
}
