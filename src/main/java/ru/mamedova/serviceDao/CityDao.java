package ru.mamedova.serviceDao;

import ru.mamedova.model.City;

public interface CityDao {
    City findCityById(Integer id);

    void addNewCity(City city);

    void updateCity(City city);

    void deleteCity(City city);
}