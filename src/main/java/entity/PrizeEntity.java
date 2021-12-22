package entity;

import model.Laureate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "prize")
public class PrizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dateAwarded; //awardYear
    private String category; //category
    private String prizeMotivation;
    private BigDecimal prizeAmountObtained;
    private BigDecimal prizeAmountAdjusted;

//    @ManyToOne( cascade = CascadeType.ALL)
//    @JoinColumn(name = "LaureateID")
//    private LaureateEntity laureateEntity;



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

}
