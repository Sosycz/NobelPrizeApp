package entity;

import model.Prize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "laureates")
public class LaureateEntity {

    @Id
    private long id;

    private String fullName; //fullName
    private String location;//locationString
    private String dateOfBirth; //birth
    private String dateOfDeath; //death

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrizeEntity> prizeList = new ArrayList<>();

    public void setPrizeList(List<PrizeEntity> prizeList) {
        this.prizeList = prizeList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<PrizeEntity> getPrizeList() {
        return prizeList;
    }

}
