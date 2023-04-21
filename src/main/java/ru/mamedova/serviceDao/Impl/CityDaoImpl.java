package ru.mamedova.serviceDao.Impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.mamedova.connetion.HibernateSessionFactoryUtil;
import ru.mamedova.exception.NotFoundCityAtDBException;
import ru.mamedova.model.City;
import ru.mamedova.serviceDao.CityDao;


public class CityDaoImpl implements CityDao {

    @Override
    public City findCityById(Integer id) {
        City city = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
        if (city != null) {
            return city;
        } else {
            throw new NotFoundCityAtDBException("Город не найден в БД.");
        }
    }

    @Override
    public void addNewCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public void updateCity(City city, Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}