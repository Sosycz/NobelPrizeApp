package mapper;

import entity.PrizeEntity;
import model.Laureate;
import model.Prize;

import java.util.ArrayList;
import java.util.List;

public class LaureateMapper {

    public static Laureate mapLaureateEntityToLaureate(entity.LaureateEntity laureateEntity) {
          Laureate laureate = new Laureate();

          laureate.setDateOfBirth(laureateEntity.getDateOfBirth());
          laureate.setDateOfDeath(laureateEntity.getDateOfDeath());
          laureate.setFullName(laureateEntity.getFullName());
          laureate.setId(laureateEntity.getId());
          laureate.setLocation(laureateEntity.getLocation());
          List<Prize> prizeList = new ArrayList<>();
          laureateEntity.getPrizeList().forEach(p -> {
              Prize prize = PrizeMapper.mapPrizeEntityToPrize(p);
              prizeList.add(prize);
          });

          return laureate;

    }

    public static entity.LaureateEntity mapLaureateToLaureateEntity(Laureate laureate) {

        entity.LaureateEntity laureateEntity = new entity.LaureateEntity();

        laureateEntity.setDateOfBirth(laureate.getDateOfBirth());
        laureateEntity.setDateOfDeath(laureate.getDateOfDeath());
        laureateEntity.setLocation(laureate.getLocation());
        laureateEntity.setFullName(laureate.getFullName());
        laureateEntity.setId(laureate.getId());
        // laureateEntity.setPrizeEntityList(laureate.getPrizeList());

        List<PrizeEntity> prizeEntityList = new ArrayList<>();
        laureate.getPrizeList().forEach(p -> {
            PrizeEntity pe = PrizeMapper.mapPrizeToPrizeEntity(p);
            prizeEntityList.add(pe);
        });

        laureateEntity.setPrizeList(prizeEntityList);

        return laureateEntity;
    }


}
