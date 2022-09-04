package repository.impl;

import model.Customer;
import model.CustomerType;
import repository.ICustomerRepository;
import service.ICustomerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Furamat?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Baydem349";

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO khach_hang" +
            "(ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,status_delete) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from khach_hang where ma_khach_hang = ?;";
    private static final String SELECT_ALL_CUSTOMER = "select * from khach_hang";
    private static final String DELETE_CUSTOMER_SQL = "delete from khach_hang where ma_khach_hang = ? ;";
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
    public CustomerRepository() {

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
    public void insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {


            preparedStatement.setInt(1, customer.getMaLoaiKhachHang());
            preparedStatement.setString(2, customer.getHoTen());
            preparedStatement.setString(3, customer.getNgaySinh());
            preparedStatement.setInt(4, customer.getGioiTinh());
            preparedStatement.setString(5, customer.getSoCMND());
            preparedStatement.setInt(6, customer.getSoDienThoai());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getDiaChi());
            preparedStatement.setInt(9, customer.getStatusDelete());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maKhachHang = rs.getInt("ma_khach_hang");
                int maLoaiKhachHang = rs.getInt("ma_loai_khach");
                String hoTen = rs.getString("ho_ten");
                String ngaySinh = rs.getString("ngay_sinh");
                int gioiTinh = rs.getInt("gioi_tinh");
                String soCMND = rs.getString("so_cmnd");
                int soDienThoai = rs.getInt("so_dien_thoai");
                String email = rs.getString("email");
                String diaChi = rs.getString("dia_chi");
                int statusDelete = rs.getInt("status_delete");

                customer = new Customer(maKhachHang,maLoaiKhachHang,hoTen,ngaySinh,gioiTinh,soCMND,soDienThoai,email,diaChi,statusDelete);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Customer> customers = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maKhachHang = rs.getInt("ma_khach_hang");
                int maLoaiKhachHang = rs.getInt("ma_loai_khach");
                String hoTen = rs.getString("ho_ten");
                String ngaySinh = rs.getString("ngay_sinh");
                int gioiTinh = rs.getInt("gioi_tinh");
                String soCMND = rs.getString("so_cmnd");
                int soDienThoai = rs.getInt("so_dien_thoai");
                String email = rs.getString("email");
                String diaChi = rs.getString("dia_chi");
                int statusDelete = rs.getInt("status_delete");

                customers.add(new Customer(maKhachHang,maLoaiKhachHang,hoTen,ngaySinh,gioiTinh,soCMND,soDienThoai,email,diaChi,statusDelete));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            statement.setInt(1, customer.getMaKhachHang());
            statement.setInt(2, customer.getMaLoaiKhachHang());
            statement.setString(3, customer.getHoTen());
            statement.setString(4, customer.getNgaySinh());
            statement.setInt(5, customer.getGioiTinh());
            statement.setString(6, customer.getSoCMND());
            statement.setInt(7, customer.getSoDienThoai());
            statement.setString(8, customer.getEmail());
            statement.setString(9, customer.getDiaChi());
            statement.setInt(10, customer.getStatusDelete());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<CustomerType> selectCustomer() {
        return null;
    }

    @Override
    public List<Customer> findByStatusDelete(String statusDelete) {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_STATUS_DELETE);
            preparedStatement.setString(1, statusDelete);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maKhachHang = rs.getInt("ma_khach_hang");
                int maLoaiKhachHang = rs.getInt("ma_loai_khach");
                String hoTen = rs.getString("ho_ten");
                String ngaySinh = rs.getString("ngay_sinh");
                int gioiTinh = rs.getInt("gioi_tinh");
                String soCMND = rs.getString("so_cmnd");
                int soDienThoai = rs.getInt("so_dien_thoai");
                String email = rs.getString("email");
                String diaChi = rs.getString("dia_chi");


                customers.add(new Customer(maKhachHang,maLoaiKhachHang,hoTen,ngaySinh,gioiTinh,soCMND,soDienThoai,email,diaChi));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
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
