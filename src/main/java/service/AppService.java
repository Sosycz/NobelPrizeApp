package service;

import repository.LaureateRepository;

public interface AppService {


    public int isInDb(int year, String category);


    public boolean isInDb(int year);

    public boolean isInDb(String name);

}
