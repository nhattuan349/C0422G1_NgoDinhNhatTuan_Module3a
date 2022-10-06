package repository;

import model.BanHang;
import model.KhuyenMai;

import java.sql.SQLException;
import java.util.List;

public interface IBanHangRepository {
    void insertBanHang(BanHang banHang) throws SQLException;

    BanHang selectBanHang(int id);

    List<BanHang> selectAllBanHang();

    boolean deleteBanHang(int id) throws SQLException;

    boolean updateBanHang(BanHang banHang) throws SQLException;

    List<KhuyenMai> selectKhuyenMai();

    List<BanHang> findByName(String name);

    List<BanHang> findByNameAndPhone(String name, String phone);

    List<BanHang> findByNamePhoneAndDate(String name, String phone, String date);
}
