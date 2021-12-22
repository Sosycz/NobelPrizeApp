import connector.NobelPrizeApiConnector;
import entity.LaureateEntity;
import mapper.LaureateMapper;
import model.Laureate;
import model.PrizeCategory;
import repository.LaureateRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Startup {
    public static void main(String[] args) {
        NobelPrizeApiConnector nobelPrizeApiConnector = new NobelPrizeApiConnector();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("noblists");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        LaureateRepository laureateRepository = new LaureateRepository(entityManager);

        LaureateEntity laureateEntity = new LaureateEntity();

        List<LaureateEntity> laureateEntities = new ArrayList<>();

        List<Laureate> laureateList = nobelPrizeApiConnector.getLaureatesByName("curie");
        laureateList.forEach((l)-> {
            laureateEntities.add(LaureateMapper.mapLaureateToLaureateEntity(l));
        });

//        laureateEntities.forEach((l)->{
//            laureateRepository.create(l);
//        });
        laureateRepository.findByName("curie");
//        laureateRepository.findByName("Michel Mayor");




    }
}
