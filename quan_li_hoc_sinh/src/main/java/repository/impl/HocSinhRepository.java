package repository.impl;

import model.HocSinh;
import model.LopHoc;
import repository.IHocSinhRepository;
import service.IHocSinhService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HocSinhRepository implements IHocSinhRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/student?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Baydem349";

    private static final String INSERT_HOC_SINH_SQL = "INSERT INTO hoc_sinh" +
            "(ten_hoc_sinh,tuoi_hoc_sinh,dia_chi,ma_lop_hoc,status_delete) " +
            "VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_HOC_SINH_BY_ID = "select * from hoc_sinh where id_hoc_sinh = ?;";
    private static final String SELECT_ALL_HOC_SINH = "select * from hoc_sinh";
    private static final String SELECT_ALL_LOP_HOC = " select * from lop_hoc";
    private static final String SEARCH_HOC_SINH_STATUS_DELETE = "SELECT * FROM hoc_sinh where status_delete = ?";
    private static final String DELETE_HOC_SINH_SQL = "delete from hoc_sinh where id_hoc_sinh = ? ;";
    private static final String UPDATE_HOC_SINH_SQL = "update hoc_sinh set " +
            "ten_hoc_sinh= ?," +
            "tuoi_hoc_sinh= ?," +
            "dia_chi= ?," +
            "ma_lop_hoc= ?," +
            "status_delete = ? " +
            "where id_hoc_sinh = ? ;" ;
    private static final String SEARCH_HOC_SINH_BY_NAME = "SELECT * FROM hoc_sinh where ten_hoc_sinh like ? ";
    private static final String SEARCH_HOC_SINH_BY_NAME_AND_AGE = "SELECT * FROM hoc_sinh where ten_hoc_sinh like ? AND tuoi_hoc_sinh = ? ";
    private static final String SEARCH_HOC_SINH_BY_NAME_OR_AGE = "SELECT * FROM hoc_sinh where ten_hoc_sinh like ? OR tuoi_hoc_sinh = ? ";

    public HocSinhRepository() {

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
    public void insertHocSinh(HocSinh hocSinh) throws SQLException {
        System.out.println(INSERT_HOC_SINH_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOC_SINH_SQL)) {
            preparedStatement.setString(1, hocSinh.getTenHocSinh());
            preparedStatement.setInt(2, hocSinh.getTuoiHocSinh());
            preparedStatement.setString(3, hocSinh.getDiaChi());
            preparedStatement.setInt(4, hocSinh.getMaLopHoc());
            preparedStatement.setInt(5, hocSinh.getStatusDelete());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public HocSinh selectHocSinh(int id) {
        HocSinh hocSinh = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOC_SINH_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idHocSinh = rs.getInt("id_hoc_sinh");
                String tenHocSinh = rs.getString("ten_hoc_sinh");
                int tuoiHocSinh = rs.getInt("tuoi_hoc_sinh");
                String diaChi = rs.getString("dia_chi");
                int maLopHoc = rs.getInt("ma_lop_hoc");
                int statusDelete = rs.getInt("status_delete");

                hocSinh = new HocSinh(idHocSinh, tenHocSinh, tuoiHocSinh, diaChi, maLopHoc, statusDelete);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return hocSinh;
    }

    @Override
    public List<HocSinh> selectAllHocSinh() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<HocSinh> hocSinhs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOC_SINH);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idHocSinh = rs.getInt("id_hoc_sinh");
                String tenHocSinh = rs.getString("ten_hoc_sinh");
                int tuoiHocSinh = rs.getInt("tuoi_hoc_sinh");
                String diaChi = rs.getString("dia_chi");
                int maLopHoc = rs.getInt("ma_lop_hoc");

                hocSinhs.add(new HocSinh(idHocSinh, tenHocSinh, tuoiHocSinh, diaChi, maLopHoc));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return hocSinhs;
    }

    @Override
    public boolean deleteHocSinh(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_HOC_SINH_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateHocSinh(HocSinh hocSinh) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_HOC_SINH_SQL);) {
            statement.setString(1, hocSinh.getTenHocSinh());
            statement.setInt(2, hocSinh.getTuoiHocSinh());
            statement.setString(3, hocSinh.getDiaChi());
            statement.setInt(4, hocSinh.getMaLopHoc());
            statement.setInt(5, hocSinh.getStatusDelete());
            statement.setInt(6, hocSinh.getIdHocSinh());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<LopHoc> selectLopHoc() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<LopHoc> lopHocs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOP_HOC);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maLopHoc = rs.getInt("ma_lop_hoc");
                String tenLopHoc = rs.getString("ten_lop_hoc");
                lopHocs.add(new LopHoc(maLopHoc, tenLopHoc));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return lopHocs;
    }

    @Override
    public List<HocSinh> findByStatusDelete(String statusDelete) {
        List<HocSinh> hocSinhs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_HOC_SINH_STATUS_DELETE);
            preparedStatement.setString(1, statusDelete);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idHocSinh = rs.getInt("id_hoc_sinh");
                String tenHocSinh = rs.getString("ten_hoc_sinh");
                int tuoiHocSinh = rs.getInt("tuoi_hoc_sinh");
                String diaChi = rs.getString("dia_chi");
                int maLopHoc = rs.getInt("ma_lop_hoc");

                hocSinhs.add(new HocSinh(idHocSinh, tenHocSinh, tuoiHocSinh, diaChi, maLopHoc));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return hocSinhs;
    }

    @Override
    public List<HocSinh> findByName(String name) {
        List<HocSinh> hocSinhs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_HOC_SINH_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idHocSinh = rs.getInt("id_hoc_sinh");
                String tenHocSinh = rs.getString("ten_hoc_sinh");
                int tuoiHocSinh = rs.getInt("tuoi_hoc_sinh");
                String diaChi = rs.getString("dia_chi");
                int maLopHoc = rs.getInt("ma_lop_hoc");

                hocSinhs.add(new HocSinh(idHocSinh, tenHocSinh, tuoiHocSinh, diaChi, maLopHoc));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return hocSinhs;
    }

    @Override
    public List<HocSinh> findByNameAndAge(String name, String age) {
        List<HocSinh> hocSinhs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_HOC_SINH_BY_NAME_AND_AGE);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + age + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idHocSinh = rs.getInt("id_hoc_sinh");
                String tenHocSinh = rs.getString("ten_hoc_sinh");
                int tuoiHocSinh = rs.getInt("tuoi_hoc_sinh");
                String diaChi = rs.getString("dia_chi");
                int maLopHoc = rs.getInt("ma_lop_hoc");

                hocSinhs.add(new HocSinh(idHocSinh, tenHocSinh, tuoiHocSinh, diaChi, maLopHoc));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return hocSinhs;
    }

    @Override
    public List<HocSinh> findByNameOrAge(String name, int age) {
        List<HocSinh> hocSinhs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_HOC_SINH_BY_NAME_OR_AGE);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setInt(2, age );
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idHocSinh = rs.getInt("id_hoc_sinh");
                String tenHocSinh = rs.getString("ten_hoc_sinh");
                int tuoiHocSinh = rs.getInt("tuoi_hoc_sinh");
                String diaChi = rs.getString("dia_chi");
                int maLopHoc = rs.getInt("ma_lop_hoc");

                hocSinhs.add(new HocSinh(idHocSinh, tenHocSinh, tuoiHocSinh, diaChi, maLopHoc));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return hocSinhs;
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
