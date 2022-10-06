package repository.impl;

import model.BoPhan;
import model.Employee;
import model.TrinhDo;
import model.ViTri;
import repository.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Furamat?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Baydem349";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO nhan_vien" +
            "(ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan,status_delete) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from nhan_vien where ma_nhan_vien = ?;";
    private static final String SELECT_ALL_EMPLOYEE = "select * from nhan_vien";
    private static final String DELETE_EMPLOYEE_SQL = "delete from nhan_vien where ma_nhan_vien = ? ;";
    private static final String UPDATE_CUSTOMER_SQL = "update khach_hang set " +
            "ma_loai_khach= ?," +
            "ho_ten= ?," +
            "ngay_sinh= ?," +
            "gioi_tinh= ?," +
            "so_cmnd= ?," +
            "so_dien_thoai= ?," +
            "email= ?," +
            "dia_chi= ?," +
            "status_delete = ? " +
            "where ma_khach_hang = ? ;" ;
    private static final String SEARCH_CUSTOMER_STATUS_DELETE = "SELECT * FROM khach_hang where status_delete = ?";
    private static final String SELECT_ALL_CUSTOMEER_TYPE = " select * from loai_khach";


    public EmployeeRepository() {

    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEE_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getHoTen());
            preparedStatement.setString(2, employee.getNgaySinh());
            preparedStatement.setString(3, employee.getSoCMND());
            preparedStatement.setDouble(4, employee.getLuong());
            preparedStatement.setString(5, employee.getSoDienThoai());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getDiachi());
            preparedStatement.setInt(8, employee.getMaVitri());
            preparedStatement.setInt(9, employee.getMaTrinhDo());
            preparedStatement.setInt(10, employee.getMaBoPhan());
            preparedStatement.setInt(11, employee.getStatusDelete());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maNhanVien = rs.getInt("ma_nhan_vien");
                String hoTen = rs.getString("ho_ten");
                String ngaySinh = rs.getString("ngay_sinh");
                String soCMND = rs.getString("so_cmnd");
                Double luong = rs.getDouble("luong");
                String soDienThoai = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String diachi = rs.getString("dia_chi");
                int maVitri = rs.getInt("ma_vi_tri");
                int maTrinhDo = rs.getInt("ma_trinh_do");
                int maBoPhan = rs.getInt("ma_bo_phan");
                int statusDelete = rs.getInt("status_delete");

                employee = new Employee(maNhanVien, hoTen, ngaySinh, soCMND,luong,soDienThoai,email,diachi,maVitri,maTrinhDo,maBoPhan,statusDelete);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Employee> employees = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maNhanVien = rs.getInt("ma_nhan_vien");
                String hoTen = rs.getString("ho_ten");
                String ngaySinh = rs.getString("ngay_sinh");
                String soCMND = rs.getString("so_cmnd");
                Double luong = rs.getDouble("luong");
                String soDienThoai = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String diachi = rs.getString("dia_chi");
                int maVitri = rs.getInt("ma_vi_tri");
                int maTrinhDo = rs.getInt("ma_trinh_do");
                int maBoPhan = rs.getInt("ma_bo_phan");

                employees.add(new Employee(maNhanVien, hoTen, ngaySinh, soCMND, luong,soDienThoai, email,diachi,maVitri,maTrinhDo,maBoPhan));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return false;
    }

    @Override
    public List<TrinhDo> selectTrinhDo() {
        return null;
    }

    @Override
    public List<ViTri> selectViTri() {
        return null;
    }

    @Override
    public List<BoPhan> selectBoPhan() {
        return null;
    }

    @Override
    public List<Employee> findByStatusDelete(String statusDelete) {
        return null;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
