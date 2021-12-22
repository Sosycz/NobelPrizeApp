package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Laureate {
    private long id;
    private String fullName; //fullName
    private String location;//locationString
    private String dateOfBirth; //birth
    private String dateOfDeath; //death
    private List<Prize> prizeList = new ArrayList<>();

    public void setPrizeList(List<Prize> prizeList) {
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

    public List<Prize> getPrizeList() {
        return prizeList;
    }

    @Override
    public String toString() {
        return "Laureate{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", location='" + location + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfDeath='" + dateOfDeath + '\'' +
                ", prizeList=" + prizeList +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laureate)) return false;
        Laureate laureate = (Laureate) o;
        return id == laureate.id && prizeList.equals(laureate.prizeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prizeList);
    }
}
