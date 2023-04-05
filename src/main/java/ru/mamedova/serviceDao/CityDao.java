package ru.mamedova.serviceDao;

import ru.mamedova.model.City;

import java.sql.SQLException;

public abstract class CityDao {
    public abstract City findById(Integer id) throws SQLException;
}