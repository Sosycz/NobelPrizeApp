package repository;

import entity.LaureateEntity;
import model.PrizeCategory;

public class NoblistsRepository implements Repository {

    @Override
    public LaureateEntity getByName(String name) {
        return null;
    }

    @Override
    public LaureateEntity getByYear(String year) {
        return null;
    }

    @Override
    public LaureateEntity getByYearAndCategory(String year, PrizeCategory category) {
        return null;
    }

    @Override
    public LaureateEntity save() {
        return null;
    }

    @Override
    public void deleteByName() {

    }
}
