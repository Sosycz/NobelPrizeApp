package service;

import jdk.jfr.Category;
import model.Laureate;
import model.PrizeCategory;

import java.util.List;

public interface AppService {
    public List<Laureate> getLaureatesByName(String name);
    public List<Laureate> getLaureatesByYear(int year);
    public List<Laureate> getLaureatesByYearAndCategory(int year, PrizeCategory category);
}
