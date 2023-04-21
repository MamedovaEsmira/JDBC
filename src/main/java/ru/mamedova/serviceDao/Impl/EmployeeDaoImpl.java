package ru.mamedova.serviceDao.Impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.mamedova.connetion.HibernateSessionFactoryUtil;
import ru.mamedova.exception.NotFoundEmployeeAtDBException;
import ru.mamedova.model.Employee;
import ru.mamedova.serviceDao.CityDao;
import ru.mamedova.serviceDao.EmployeeDao;


import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

CityDao cityDao = new CityDaoImpl();

    @Override
    public List<Employee> findAllEmployee() {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            List<Employee> employees = session.createQuery("FROM Employee").list();
            if (!employees.isEmpty()) {
                return employees;
            } else {
                throw new NotFoundEmployeeAtDBException("Список работников пуст, либо не найден в БД.");
            }
        }
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
        if (employee != null) {
            return employee;
        } else {
            throw new NotFoundEmployeeAtDBException("Работник не найден в БД.");
        }
    }

    @Override
    public void addNewEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }
    @Override
    public void updateEmployee(Employee employee, Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
