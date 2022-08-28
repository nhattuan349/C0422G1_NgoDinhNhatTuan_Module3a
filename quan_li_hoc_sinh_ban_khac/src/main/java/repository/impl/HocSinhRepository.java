package repository.impl;

import model.HocSinh;
import repository.IHocSinhRepository;

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
    private static final String SELECT_HOC_SINH_SQL = "select * from hoc_sinh ";

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
    public List<HocSinh> selectAllHocSinh() {
        List<HocSinh> hocSinhs = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOC_SINH_SQL)) {
            System.out.println(preparedStatement);
            ResultSet  rs = preparedStatement.executeQuery();
            while (rs.next()) {
int idHocSinh = rs.getInt("id_hoc)sinh");
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
