package ru.mamedova.serviceDao;
import ru.mamedova.model.Employee;
import java.util.List;


public abstract class EmployeeDao {
        public abstract List<Employee> findAllEmployee();

        public abstract Employee findById(Integer id);

        public abstract void addNewEmployee(Employee employee);

        public abstract void updateEmployee(Employee employee, Integer id);

        public abstract void deleteEmployee(Employee employee);
}