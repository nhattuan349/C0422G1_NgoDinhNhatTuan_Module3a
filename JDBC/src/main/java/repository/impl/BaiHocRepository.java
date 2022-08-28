package repository.impl;

import model.BaiHoc;
import model.DoKho;
import model.LoaiBaiHoc;
import model.Module;
import repository.IBaiHocRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaiHocRepository implements IBaiHocRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/exam?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Baydem349";


    private static final String INSERT_BAI_HOC_SQL = "INSERT INTO bai_hoc" +
            "(tieu_de,ma_loai_bai_hoc,ma_do_kho,ma_module,status_delete,link_bai_hoc) VALUE(?,?,?,?,?,?);";
    private static final String SELECT_BAI_HOC_BY_ID = "SELECT * FROM bai_hoc where id_bai_hoc";
    private static final String SELECT_ALL_BAI_HOC = "SELECT * FROM bai_hoc";
    private static final String SELECT_ALL_LOAI_BAI_HOC = "SELECT * FROM loai_bai_hoc";
    private static final String SELECT_ALL_DO_KHO = "SELECT * FROM do_kho";
    private static final String SELECT_ALL_MODULE = "SELECT * FROM module";
    private static final String SEARCH_BAI_HOC_STATUS_DELETE = "SELECT * FROM bai_hoc where status_delete = ?";
    private static final String DELETE_BAI_HOC_SQL = "delete from bai_hoc where id_bai_hoc=?;";
    private static final String UPDATE_BAI_HOC_SQL = "update bai_hoc " +
            "set tieu_de=?,ma_loai_bai_hoc=?,ma_do_kho=?,ma_module=?,status_delete=?,link_bai_hoc=? where id_bai_hoc =?;";


    public BaiHocRepository() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertBaiHoc(BaiHoc baiHoc) throws SQLException {
        System.out.println(INSERT_BAI_HOC_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BAI_HOC_SQL)) {
            preparedStatement.setString(1, baiHoc.getTieuDe());
            preparedStatement.setInt(2, baiHoc.getMaLoaiBaiHoc());
            preparedStatement.setInt(3, baiHoc.getMaDoKho());
            preparedStatement.setInt(4, baiHoc.getMaModule());
            preparedStatement.setInt(5, baiHoc.getStatusDelete());
            preparedStatement.setString(6, baiHoc.getLinkBaiHoc());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public BaiHoc selectBaiHoc(int id) {
        BaiHoc baiHoc = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BAI_HOC_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idBaiHoc = rs.getInt("id_bai_hoc");
                String tieuDe = rs.getString("tieu_de");
                int maLoaiBaiHoc = rs.getInt("ma_loai_bai_hoc");
                int maDoKho = rs.getInt("ma_do_kho");
                int maModule = rs.getInt("ma_do_kho");
                String linkBaiHoc = rs.getString("link_bai_hoc");

                baiHoc = new BaiHoc(idBaiHoc, tieuDe, maLoaiBaiHoc, maDoKho, maModule, linkBaiHoc);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return baiHoc;
    }

    @Override
    public List<BaiHoc> selectAllBaiHoc() {
        List<BaiHoc> baiHocs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BAI_HOC);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idBaiHoc = rs.getInt("id_bai_hoc");
                String tieuDe = rs.getString("tieu_de");
                int maLoaiBaiHoc = rs.getInt("ma_loai_bai_hoc");
                int maDoKho = rs.getInt("ma_do_kho");
                int maModule = rs.getInt("ma_do_kho");
                String linkBaiHoc = rs.getString("link_bai_hoc");

                baiHocs.add(new BaiHoc(idBaiHoc, tieuDe, maLoaiBaiHoc, maDoKho, maModule, linkBaiHoc));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return baiHocs;
    }

    @Override
    public boolean deleteBaiHoc(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BAI_HOC_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateBaiHoc(BaiHoc baiHoc) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BAI_HOC_SQL);) {

            statement.setString(1, baiHoc.getTieuDe());
            statement.setInt(2, baiHoc.getMaLoaiBaiHoc());
            statement.setInt(3, baiHoc.getMaDoKho());
            statement.setInt(4, baiHoc.getMaModule());
            statement.setInt(5, baiHoc.getStatusDelete());
            statement.setString(6, baiHoc.getLinkBaiHoc());
            statement.setInt(7, baiHoc.getIdBaiHoc());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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

    @Override
    public List<LoaiBaiHoc> selectLoaiBaiHoc() {
        List<LoaiBaiHoc> loaiBaiHocs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOAI_BAI_HOC);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maLoaiBaiHoc = rs.getInt("ma_loai_bai_hoc");
                String tenLoaiBaiHoc = rs.getString("ten_loai_bai_hoc");
                loaiBaiHocs.add(new LoaiBaiHoc(maLoaiBaiHoc, tenLoaiBaiHoc));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return loaiBaiHocs;
    }

    @Override
    public List<DoKho> selectDoKho() {
        List<DoKho> doKhos = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DO_KHO);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maDoKho = rs.getInt("ma_do_kho");
                String tenDoKho = rs.getString("ten_do_kho");
                doKhos.add(new DoKho(maDoKho, tenDoKho));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return doKhos;
    }

    @Override
    public List<Module> selectModule() {
        List<Module> modules = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MODULE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maModule = rs.getInt("ma_module");
                String tenModule = rs.getString("ten_module");
                modules.add(new Module(maModule, tenModule));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return modules;
    }

    @Override
    public List<BaiHoc> findByStatusDelete(String statusDelete) {
        List<BaiHoc> baiHocs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BAI_HOC_STATUS_DELETE);
            preparedStatement.setString(1, statusDelete);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idBaiHoc = rs.getInt("id_bai_hoc");
                String tieuDe = rs.getString("tieu_de");
                int maLoaiBaiHoc = rs.getInt("ma_loai_bai_hoc");
                int maDoKho = rs.getInt("ma_do_kho");
                int maModule = rs.getInt("ma_module");
                String linkBaiHoc = rs.getString("link_bai_hoc");
                baiHocs.add(new BaiHoc(idBaiHoc, tieuDe, maLoaiBaiHoc, maDoKho, maModule, linkBaiHoc));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return baiHocs;
    }
}
