
import ru.mamedova.model.Employee;
import ru.mamedova.serviceDao.CityDao;
import ru.mamedova.serviceDao.EmployeeDao;
import ru.mamedova.serviceDao.Impl.CityDaoImpl;
import ru.mamedova.serviceDao.Impl.EmployeeDaoImpl;

public class Application {

    private static final CityDao cityDao = new CityDaoImpl();
    private static final EmployeeDao employeeDao = new EmployeeDaoImpl();

    public static void main(String[] args) {

        System.out.println(employeeDao.findById(6));
        Employee anna = new Employee("Anna", "Petrova", "Female", 35, 3);
        employeeDao.addNewEmployee(anna);
        for (Employee employee : employeeDao.findAllEmployee()) {
            System.out.println(employee);
        }
        anna.setLastName("Stepanov");
        employeeDao.updateEmployee(anna, 10);
        employeeDao.deleteEmployee(anna);
    }

}
