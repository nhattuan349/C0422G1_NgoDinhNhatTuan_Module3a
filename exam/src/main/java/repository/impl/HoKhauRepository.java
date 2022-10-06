package repository.impl;

import model.HoKhau;
import model.ThanhVien;
import repository.IHoKhauRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoKhauRepository implements IHoKhauRepository {

    private String jdbcURL = "jdbc:mysql://localhost:3306/thi_module?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Baydem349";


    private static final String SELECT_HO_KHAU_BY_ID = "select * from ho_khau where stt_ho_khau = ?;";
    private static final String SELECT_ALL_HO_KHAU = "select * from ho_khau";
    private static final String SELECT_ALL_THANH_VIEN = " select * from thanh_vien";
    private static final String UPDATE_HO_KHAU_SQL = "update ho_khau set " +
            "ma_thanh_vien= ?," +
            "ten_chu_ho= ?," +
            "so_luong_thanh_vien= ?," +
            "ngay_lap_ho_khau= ?," +
            "dia_chi_nha = ? " +
            "where stt_ho_khau = ? ;" ;


    public HoKhauRepository() {

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
    public HoKhau selectHoKhau(int id) {
        HoKhau hoKhau = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HO_KHAU_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int stt_ho_khau = rs.getInt("stt_ho_khau");
                int maThanhVien = rs.getInt("ma_thanh_vien");
                String tenChuHo = rs.getString("ten_chu_ho");
                int soLuongThanhVien = rs.getInt("so_luong_thanh_vien");
                String ngayLapHoKhau = rs.getString("ngay_lap_ho_khau");
                String diaChiNha = rs.getString("dia_chi_nha");

                hoKhau = new HoKhau(stt_ho_khau, maThanhVien, tenChuHo, soLuongThanhVien, ngayLapHoKhau,diaChiNha);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return hoKhau;
    }

    @Override
    public List<HoKhau> selectAllHoKhau() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<HoKhau> hoKhaus = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HO_KHAU);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int stt_ho_khau = rs.getInt("stt_ho_khau");
                int maThanhVien = rs.getInt("ma_thanh_vien");
                String tenChuHo = rs.getString("ten_chu_ho");
                int soLuongThanhVien = rs.getInt("so_luong_thanh_vien");
                String ngayLapHoKhau = rs.getString("ngay_lap_ho_khau");
                String diaChiNha = rs.getString("dia_chi_nha");

                hoKhaus.add(new HoKhau(stt_ho_khau, maThanhVien, tenChuHo, soLuongThanhVien, ngayLapHoKhau,diaChiNha));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return hoKhaus;
    }

    @Override
    public boolean updateHoKhau(HoKhau hoKhau) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_HO_KHAU_SQL);) {
            statement.setInt(1, hoKhau.getMaThanhVien());
            statement.setString(2, hoKhau.getTenChuHo());
            statement.setInt(3, hoKhau.getSoLuongThanhVien());
            statement.setString(4, hoKhau.getNgayLapHoKhau());
            statement.setString(5, hoKhau.getDiaChiNha());
            statement.setInt(6, hoKhau.getSttHoKhau());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<ThanhVien> selectThanhVien() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<ThanhVien> thanhViens = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THANH_VIEN);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maThanhVien = rs.getInt("ma_thanh_vien");
                String tenThanhVien = rs.getString("ten_thanh_vien");
                thanhViens.add(new ThanhVien(maThanhVien,tenThanhVien));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return thanhViens;
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
