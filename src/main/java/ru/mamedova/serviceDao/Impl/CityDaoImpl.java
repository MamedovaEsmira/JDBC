package ru.mamedova.serviceDao.Impl;

import ru.mamedova.connetion.HibernateSessionFactoryUtil;
import ru.mamedova.exception.NotFoundCityAtDBException;
import ru.mamedova.model.City;
import ru.mamedova.serviceDao.CityDao;


public class CityDaoImpl extends CityDao {

    @Override
    public City findById(Integer id)  {
        City city = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);

        if (city != null) {
            return city;
        } else {
            throw new NotFoundCityAtDBException("Город не найден в БД.");
        }
    }
}