
import ru.mamedova.exception.NotFoundCityAtDBException;
import ru.mamedova.model.City;
import ru.mamedova.model.Employee;
import ru.mamedova.serviceDao.CityDao;
import ru.mamedova.serviceDao.EmployeeDao;
import ru.mamedova.serviceDao.Impl.CityDaoImpl;
import ru.mamedova.serviceDao.Impl.EmployeeDaoImpl;

public class Application {

    private static final CityDao cityDao = new CityDaoImpl();
    private static final EmployeeDao employeeDao = new EmployeeDaoImpl();

    //Операции с городами
    static void addNewCity(City city) {
        cityDao.addNewCity(city);
    }

    static Object findCityById(Integer id) {
        try {
            return cityDao.findCityById(id);
        } catch (NotFoundCityAtDBException e) {
            return e.getMessage();
        }
    }

    static void updateCity(City city) {
        cityDao.updateCity(city);
    }

    static void deleteCity(City city) {
        cityDao.deleteCity(city);
    }

    //Операции с работниками
    static void addNewEmployee(Employee employee) {
        employeeDao.addNewEmployee(employee);
    }

    static Object findEmployeeById(Integer id) {
        try {
            return cityDao.findCityById(id);
        } catch (NotFoundCityAtDBException e) {
            return e.getMessage();
        }
    }

    static void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    static void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
    }

    public static void main(String[] args) {

        System.out.println(employeeDao.findById(6));
        Employee anna = new Employee("Anna", "Petrova", "Female", 35, 3);
        employeeDao.addNewEmployee(anna);
        for (Employee employee : employeeDao.findAllEmployee()) {
            System.out.println(employee);
        }
        anna.setLastName("Stepanov");
        employeeDao.deleteEmployee(anna);
    }

}
