package ru.mamedova.serviceDao.Impl;

import ru.mamedova.connetion.ApplicationConnection;
import ru.mamedova.model.City;
import ru.mamedova.serviceDao.CityDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDaoImpl extends CityDao {

    private final ApplicationConnection applicationConnection = new ApplicationConnection();

    @Override
    public City findById(Integer id) throws SQLException {
        try(PreparedStatement statement = applicationConnection.getPrepareStatement
                ("SELECT * FROM city WHERE city_id = (?)")){
            statement.setInt(1,id);
            statement.executeQuery();

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return new City(resultSet.getString("city_name"));
        }
    }
}