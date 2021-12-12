package repository;

import entity.LaureateEntity;
import model.PrizeCategory;

public interface Repository {

    public LaureateEntity getByName(String name);

    public LaureateEntity getByYear(String year);

    public LaureateEntity getByYearAndCategory(String year, PrizeCategory category);

    public LaureateEntity save();
    public void deleteByName();
}
