package repository;

import entity.PrizeEntity;

import javax.persistence.EntityManager;

public class PrizeRepository extends Repository<PrizeEntity> {

    private final EntityManager entityManager;

    public PrizeRepository(EntityManager entityManager) {
        super(entityManager, PrizeEntity.class);
        this.entityManager = entityManager;
    }


}
