package mapper;

import model.PrizeCategory;

public class CategoryMapper {
    public static String catMapper(PrizeCategory category) {

        switch (category) {
            case CHE:
                return "Chemistry";
            case MED:
                return "Physiology or Medicine";
            case LIT:
                return "Literature";
            case PHY:
                return "Physics";
            case ECO:
                return "Economic Sciences";
            case PEA:
                return "Peace";

            default: return null;
        }
    }
}
