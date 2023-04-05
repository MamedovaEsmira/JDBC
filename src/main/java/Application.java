
import ru.mamedova.model.Employee;
import ru.mamedova.serviceDao.CityDao;
import ru.mamedova.serviceDao.EmployeeDao;
import ru.mamedova.serviceDao.Impl.CityDaoImpl;
import ru.mamedova.serviceDao.Impl.EmployeeDaoImpl;

import java.sql.SQLException;

public class Application {

    private static final CityDao cityDao = new CityDaoImpl();
    private static final EmployeeDao employeeDao = new EmployeeDaoImpl();

    public static void main(String[] args) throws SQLException {

        System.out.println(employeeDao.findById(6));
        for (Employee employee: employeeDao.findAllEmployee()){
            System.out.println(employee);
        }
        employeeDao.addNewEmployee("Anna", "Petrova", "Female", 35, 3);
        employeeDao.updateEmployee(10, "Misha", "Solovyov", "Male", 28, 3);
        employeeDao.deleteEmployeeById(10);

    }

}
