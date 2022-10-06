package service;

import model.BoPhan;
import model.Employee;
import model.TrinhDo;
import model.ViTri;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    void insertEmployee(Employee employee) throws SQLException;

    Employee selectEmployee(int id);

    List<Employee> selectAllEmployee();

    boolean deleteEmployee(int id) throws SQLException;

    boolean updateEmployee(Employee employee) throws SQLException;

    List<TrinhDo> selectTrinhDo();

    List<ViTri> selectViTri();

    List<BoPhan> selectBoPhan();

    List<Employee> findByStatusDelete(String statusDelete);
}
