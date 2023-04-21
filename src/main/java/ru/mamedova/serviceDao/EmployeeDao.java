package ru.mamedova.serviceDao;

import ru.mamedova.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAllEmployee();

    Employee findById(Integer id);

    void addNewEmployee(Employee employee);

    void updateEmployee(Employee employee, Integer id);

    void deleteEmployee(Employee employee);
}