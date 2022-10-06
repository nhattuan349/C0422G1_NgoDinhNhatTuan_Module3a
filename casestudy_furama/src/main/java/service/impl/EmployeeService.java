package service.impl;

import model.BoPhan;
import model.Employee;
import model.TrinhDo;
import model.ViTri;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {

    IEmployeeRepository employeeRepository = new EmployeeRepository();


    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public List<TrinhDo> selectTrinhDo() {
        return employeeRepository.selectTrinhDo();
    }

    @Override
    public List<ViTri> selectViTri() {
        return employeeRepository.selectViTri();
    }

    @Override
    public List<BoPhan> selectBoPhan() {
        return employeeRepository.selectBoPhan();
    }

    @Override
    public List<Employee> findByStatusDelete(String statusDelete) {
        return employeeRepository.findByStatusDelete(statusDelete);
    }
}
