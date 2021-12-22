package mapper;

import model.Prize;

public class PrizeMapper {

    public static Prize mapPrizeEntityToPrize(entity.PrizeEntity prizeEntity) {
        Prize prize = new Prize();

        prize.setPrizeMotivation(prizeEntity.getPrizeMotivation());
        prize.setCategory(prizeEntity.getCategory());
        prize.setPrizeAmountAdjusted(prizeEntity.getPrizeAmountAdjusted());
        prize.setPrizeAmountObtained(prizeEntity.getPrizeAmountObtained());
        prize.setDateAwarded(prizeEntity.getDateAwarded());

        return prize;
    }

    public static entity.PrizeEntity mapPrizeToPrizeEntity(Prize prize) {
        entity.PrizeEntity prizeEntity = new entity.PrizeEntity();

        prizeEntity.setCategory(prize.getCategory());
        prizeEntity.setPrizeMotivation(prize.getPrizeMotivation());
        prizeEntity.setPrizeAmountAdjusted(prize.getPrizeAmountAdjusted());
        prizeEntity.setPrizeAmountObtained(prize.getPrizeAmountObtained());
        prizeEntity.setDateAwarded(prize.getDateAwarded());

        return prizeEntity;
    }
}
