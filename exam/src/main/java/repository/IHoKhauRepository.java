package repository;

import model.HoKhau;
import model.ThanhVien;

import java.sql.SQLException;
import java.util.List;

public interface IHoKhauRepository {

    HoKhau selectHoKhau(int id);

    List<HoKhau> selectAllHoKhau();

    boolean updateHoKhau(HoKhau hoKhau) throws SQLException;

    List<ThanhVien> selectThanhVien();
}
