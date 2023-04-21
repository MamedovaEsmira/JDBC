
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

    static void updateCity(City city, Integer id) {
        cityDao.updateCity(city, id);
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

    static void updateEmployee(Employee employee, Integer id) {
        employeeDao.updateEmployee(employee, id);
    }

    static void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
    }

    public static void main(String[] args) {

        System.out.println(employeeDao.findById(2));
        Employee anna = new Employee("Anna", "Petrova", "Female");
        employeeDao.addNewEmployee(anna);
        for (Employee employee : employeeDao.findAllEmployee()) {
            System.out.println(employee);
        }
        anna.setLastName("Petrova");
        employeeDao.deleteEmployee(anna);

        System.out.println(cityDao.findCityById(3));
        City moscow = new City("Moscow");
        cityDao.addNewCity(moscow);
        moscow.setName("Ne Moscow");
        cityDao.updateCity(moscow, 3);
        cityDao.deleteCity(moscow);
    }

}
