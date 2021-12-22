package repository;

import entity.LaureateEntity;
import mapper.CategoryMapper;
import model.Laureate;
import model.PrizeCategory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Locale;

public class LaureateRepository extends Repository<LaureateEntity> {

    private final EntityManager entityManager;

    public LaureateRepository(EntityManager entityManager) {
        super(entityManager, LaureateEntity.class);
        this.entityManager = entityManager;
    }

    public LaureateEntity create(LaureateEntity laureateEntity) {
        if(this.read(laureateEntity.getId()) != null) {
            throw new IllegalArgumentException("Laureate is already stored in database");
        }

        return super.create(laureateEntity);

    }

    public List<LaureateEntity> findByName(String name) {

        Query query = entityManager.createQuery("FROM LaureateEntity L left join L.prizeList WHERE L.fullName = :name" );
        query.setParameter("name", name);
        List<LaureateEntity> laureateEntities = (List<LaureateEntity>) query.getResultList();
        return laureateEntities;
    }


    public List<LaureateEntity> findByYear(int year) {

        Query query = entityManager.createQuery("FROM LaureateEntity L left join L.prizeList WHERE L.dateAwarded = :year");
        query.setParameter("year", year);
        List<LaureateEntity> laureateEntities = (List<LaureateEntity>) query.getResultList();

        return laureateEntities;

    }


    public List<LaureateEntity> findByYearAndCategory(int year, PrizeCategory category) {
        Query query = entityManager.createQuery("FROM LaureateEntity L left join L.prizeList WHERE" +
                                                        " L.dateAwarded = :year " +
                                                        "AND L.category = :category");

        query.setParameter("category", CategoryMapper.catMapper(category));
        query.setParameter("year", year);

        List<LaureateEntity> laureateEntities = (List<LaureateEntity>) query.getResultList();

        return laureateEntities;

    }
    public List<LaureateEntity> findAll() {
        Query query = entityManager.createQuery("FROM LaureateEntity L left join L.prizeList");
        return query.getResultList();
    }

    public Laureate save() {
        return null;
    }


    public void deleteByName() {

    }
}
