package model;

import java.math.BigDecimal;

public class Prize {
    private String dateAwarded; //awardYear
    private String category; //category
    private String prizeMotivation;
    private BigDecimal prizeAmountObtained;
    private BigDecimal prizeAmountAdjusted;

    public String getDateAwarded() {
        return dateAwarded;
    }

    public void setDateAwarded(String dateAwarded) {
        this.dateAwarded = dateAwarded;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrizeMotivation() {
        return prizeMotivation;
    }

    public void setPrizeMotivation(String prizeMotivation) {
        this.prizeMotivation = prizeMotivation;
    }

    public BigDecimal getPrizeAmountObtained() {
        return prizeAmountObtained;
    }

    public void setPrizeAmountObtained(BigDecimal prizeAmountObtained) {
        this.prizeAmountObtained = prizeAmountObtained;
    }

    public BigDecimal getPrizeAmountAdjusted() {
        return prizeAmountAdjusted;
    }

    public void setPrizeAmountAdjusted(BigDecimal prizeAmountAdjusted) {
        this.prizeAmountAdjusted = prizeAmountAdjusted;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "dateAwarded='" + dateAwarded + '\'' +
                ", category='" + category + '\'' +
                ", prizeMotivation='" + prizeMotivation + '\'' +
                ", prizeAmountObtained=" + prizeAmountObtained +
                ", prizeAmountAdjusted=" + prizeAmountAdjusted +
                '}';
    }
}
