package ru.mamedova.serviceDao;

import ru.mamedova.model.Employee;
import java.sql.SQLException;
import java.util.List;

public abstract class EmployeeDao {
        public abstract List<Employee> findAllEmployee() throws SQLException;

        public abstract Employee findById(Integer id) throws SQLException;

        public abstract void addNewEmployee(String firstName, String lastName, String gender, Integer age, Integer cityId) throws SQLException;

        public abstract void updateEmployee(Integer id, String firstName, String lastName, String gender, Integer age, Integer cityId) throws SQLException;

        public abstract void deleteEmployeeById(Integer id) throws SQLException;
}