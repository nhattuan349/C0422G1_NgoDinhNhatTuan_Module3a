package repository.impl;

import model.BanHang;
import model.KhuyenMai;
import repository.IBanHangRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BanHangRepository implements IBanHangRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ban_hang?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Baydem349";

    private static final String INSERT_BAN_HANG_SQL = "INSERT INTO khach_hang" +
            "(ten_khach_hang,so_dien_thoai,thoi_gian_giao_dich,ma_khuyen_mai,status_delete) " +
            "VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_BAN_HANG_BY_ID = "select * from khach_hang where ma_khach_hang = ?;";
    private static final String SELECT_ALL_BAN_HANG = "select * from khach_hang";
    private static final String SELECT_ALL_KHUYEN_MAI = " select * from khuyen_mai";
    private static final String SEARCH_BAN_HANG_STATUS_DELETE = "SELECT * FROM khach_hang where status_delete = ?";
    private static final String DELETE_BAN_HANG_SQL = "delete from khach_hang where ma_khach_hang = ? ;";
    private static final String UPDATE_BAN_HANG_SQL = "update khach_hang set " +
            "ten_khach_hang= ?," +
            "so_dien_thoai= ?," +
            "thoi_gian_giao_dich= ?," +
            "ma_khuyen_mai= ?," +
            "status_delete = ? " +
            "where ma_khach_hang = ? ;" ;
    private static final String SEARCH_BAN_HANG_BY_NAME = "SELECT * FROM khach_hang where ten_khach_hang like ? ";
    private static final String SEARCH_BAN_HANG_BY_NAME_AND_AGE = "SELECT * FROM khach_hang where ten_khach_hang like ? AND so_dien_thoai = ? ";

    public BanHangRepository() {

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
    public void insertBanHang(BanHang banHang) throws SQLException {
        System.out.println(INSERT_BAN_HANG_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BAN_HANG_SQL)) {
            preparedStatement.setString(1, banHang.getTenKhachHang());
            preparedStatement.setInt(2, banHang.getSoDienThoai());
            preparedStatement.setString(3, banHang.getThoiGianGiaoDich());
            preparedStatement.setInt(4, banHang.getMaKhuyenMai());
            preparedStatement.setInt(5, banHang.getStatusDelete());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public BanHang selectBanHang(int id) {
        BanHang banHang = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BAN_HANG_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maKhachHang = rs.getInt("ma_khach_hang");
                String tenKhachHang = rs.getString("ten_khach_hang");
                int soDienThoai = rs.getInt("so_dien_thoai");
                String thoiGianGiaoDich = rs.getString("thoi_gian_giao_dich");
                int maKhuyenMai = rs.getInt("ma_khuyen_mai");
                int statusDelete = rs.getInt("status_delete");

                banHang = new BanHang(maKhachHang, tenKhachHang, soDienThoai, thoiGianGiaoDich, maKhuyenMai, statusDelete);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return banHang;
    }

    @Override
    public List<BanHang> selectAllBanHang() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<BanHang> banHangs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BAN_HANG);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maKhachHang = rs.getInt("ma_khach_hang");
                String tenKhachHang = rs.getString("ten_khach_hang");
                int soDienThoai = rs.getInt("so_dien_thoai");
                String thoiGianGiaoDich = rs.getString("thoi_gian_giao_dich");
                int maKhuyenMai = rs.getInt("ma_khuyen_mai");

                banHangs.add(new BanHang(maKhachHang, tenKhachHang, soDienThoai, thoiGianGiaoDich, maKhuyenMai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return banHangs;
    }

    @Override
    public boolean deleteBanHang(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BAN_HANG_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateBanHang(BanHang banHang) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BAN_HANG_SQL);) {
            statement.setString(1, banHang.getTenKhachHang());
            statement.setInt(2, banHang.getSoDienThoai());
            statement.setString(3, banHang.getThoiGianGiaoDich());
            statement.setInt(4, banHang.getMaKhuyenMai());
            statement.setInt(5, banHang.getStatusDelete());
            statement.setInt(6, banHang.getMaKhachHang());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<KhuyenMai> selectKhuyenMai() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<KhuyenMai> khuyenMais = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_KHUYEN_MAI);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maKhuyenMai = rs.getInt("ma_khuyen_mai");
                int tenKhuyenMai = rs.getInt("ten_khuyen_mai");
                khuyenMais.add(new KhuyenMai(maKhuyenMai,tenKhuyenMai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return khuyenMais;
    }

    @Override
    public List<BanHang> findByStatusDelete(String statusDelete) {
        List<BanHang> banHangs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BAN_HANG_STATUS_DELETE);
            preparedStatement.setString(1, statusDelete);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maKhachHang = rs.getInt("ma_khach_hang");
                String tenKhachHang = rs.getString("ten_khach_hang");
                int soDienThoai = rs.getInt("so_dien_thoai");
                String thoiGianGiaoDich = rs.getString("thoi_gian_giao_dich");
                int maKhuyenMai = rs.getInt("ma_khuyen_mai");

                banHangs.add(new BanHang(maKhachHang, tenKhachHang, soDienThoai, thoiGianGiaoDich, maKhuyenMai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return banHangs;
    }

    @Override
    public List<BanHang> findByName(String name) {
        List<BanHang> banHangs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BAN_HANG_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maKhachHang = rs.getInt("ma_khach_hang");
                String tenKhachHang = rs.getString("ten_khach_hang");
                int soDienThoai = rs.getInt("so_dien_thoai");
                String thoiGianGiaoDich = rs.getString("thoi_gian_giao_dich");
                int maKhuyenMai = rs.getInt("ma_khuyen_mai");

                banHangs.add(new BanHang(maKhachHang, tenKhachHang, soDienThoai, thoiGianGiaoDich, maKhuyenMai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return banHangs;
    }

    @Override
    public List<BanHang> findByNameAndPhone(String name, String phone) {
        List<BanHang> banHangs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BAN_HANG_BY_NAME_AND_AGE);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + phone + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maKhachHang = rs.getInt("ma_khach_hang");
                String tenKhachHang = rs.getString("ten_khach_hang");
                int soDienThoai = rs.getInt("so_dien_thoai");
                String thoiGianGiaoDich = rs.getString("thoi_gian_giao_dich");
                int maKhuyenMai = rs.getInt("ma_khuyen_mai");

                banHangs.add(new BanHang(maKhachHang, tenKhachHang, soDienThoai, thoiGianGiaoDich, maKhuyenMai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return banHangs;
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
