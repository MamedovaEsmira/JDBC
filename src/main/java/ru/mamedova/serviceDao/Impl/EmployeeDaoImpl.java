package ru.mamedova.serviceDao.Impl;

import ru.mamedova.connetion.ApplicationConnection;
import ru.mamedova.model.Employee;
import ru.mamedova.serviceDao.CityDao;
import ru.mamedova.serviceDao.EmployeeDao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl extends EmployeeDao {

    private final ApplicationConnection applicationConnection = new ApplicationConnection();

    private final CityDao cityDao = new CityDaoImpl();


    @Override
    public List<Employee> findAllEmployee() throws SQLException{
        try(PreparedStatement statement = applicationConnection.getPrepareStatement
                ("SELECT * FROM employee")){
            statement.executeQuery();

            ResultSet resultSet = statement.getResultSet();
            List<Employee> employeeList = new ArrayList<>();

            while (resultSet.next()){
                employeeList.add(new Employee
                        (resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("gender"),
                                resultSet.getInt("age"),
                                cityDao.findById(resultSet.getInt("city_id"))));
            }
            return employeeList;
        }
    }

    @Override
    public Employee findById(Integer id) throws SQLException {
        try (PreparedStatement statement = applicationConnection.getPrepareStatement("SELECT * FROM employee where id = (?)")){
            statement.setInt(1,id);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return new Employee(resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("gender"),
                    resultSet.getInt("age"),
                    cityDao.findById(resultSet.getInt("city_id")));
        }
    }

    @Override
    public void addNewEmployee (String firstName, String lastName, String gender, Integer age, Integer cityId) throws SQLException {
        try(PreparedStatement preparedStatement = applicationConnection.getPrepareStatement
                ("INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES (?,?,?,?,?)")){
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3,gender);
            preparedStatement.setInt(4,age);
            preparedStatement.setInt(5,cityId);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateEmployee(Integer id, String firstName, String lastName, String gender, Integer age, Integer cityId) throws SQLException {
        try (PreparedStatement statement = applicationConnection.getPrepareStatement
                ("UPDATE employee SET first_name = ?, last_name = ?, gender = ?, age = ?, city_id = ? WHERE id = (?)")){
            statement.setString(1,firstName);
            statement.setString(2, lastName);
            statement.setString(3,gender);
            statement.setInt(4,age);
            statement.setInt(5, cityId);
            statement.setInt(6, id);
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteEmployeeById(Integer id) throws SQLException {
        try(PreparedStatement statement = applicationConnection.getPrepareStatement
                ("DELETE FROM employee WHERE id = (?)")){
            statement.setInt(1,id);
            statement.executeUpdate();
        }
    }
}