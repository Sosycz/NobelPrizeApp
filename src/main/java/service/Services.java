package service;

import connector.NobelPrizeApiConnector;
import entity.LaureateEntity;
import mapper.CategoryMapper;
import mapper.LaureateMapper;
import model.Laureate;
import model.PrizeCategory;
import repository.LaureateRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Services {

    NobelPrizeApiConnector nobelPrizeApiConnector = new NobelPrizeApiConnector();
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("noblists");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    LaureateRepository laureateRepository = new LaureateRepository(entityManager);

    LaureateEntity laureateEntity = new LaureateEntity();

    public boolean isInDB(int year, PrizeCategory category) {
        int DBRecords = laureateRepository.findByYearAndCategory(year, category).size();

        int ExistingRecords = nobelPrizeApiConnector.getLaureatesByYearAndCategory(year, category).size();

        return DBRecords == ExistingRecords;
    }
    public boolean isInDB(int year) {
        int DBRecords = laureateRepository.findByYear(year).size();

        int ExistingRecords = nobelPrizeApiConnector.getLaureatesByYear(year).size();

        return DBRecords == ExistingRecords;
    }
    public boolean isInDB(String name) {
        int DBRecords = laureateRepository.findByName(name).size();

        int ExistingRecords = nobelPrizeApiConnector.getLaureatesByName(name).size();

        return DBRecords == ExistingRecords;
    }

    public List<Laureate> getLaureatesByName(String name) {

        if (isInDB(name)) {
            List<Laureate> laureates = new ArrayList<>();
            laureateRepository.findByName(name).forEach(l-> {
                laureates.add(LaureateMapper.mapLaureateEntityToLaureate(l));
            });
            return laureates;
        }
        return nobelPrizeApiConnector.getLaureatesByName(name);
    }

    public List<Laureate> getLaureatesByYear(int year) {

        if(isInDB(year)) {
            List<Laureate> laureates = new ArrayList<>();
            laureateRepository.findByYear(year).forEach(l->{
                laureates.add(LaureateMapper.mapLaureateEntityToLaureate(l));
                    });
            return laureates;
        }

        return nobelPrizeApiConnector.getLaureatesByYear(year);

    }

    public List<Laureate> getLaureatesByYearAndCategory(int year, PrizeCategory category) {
        if(isInDB(year,category)) {
            List<Laureate> laureates = new ArrayList<>();
            laureateRepository.findByYearAndCategory(year, category).forEach(l -> {
                laureates.add(LaureateMapper.mapLaureateEntityToLaureate(l));
            });
            return laureates;
        }
        List<Laureate> laureates = nobelPrizeApiConnector.getLaureatesByYearAndCategory(year, category);
        
    }
}
