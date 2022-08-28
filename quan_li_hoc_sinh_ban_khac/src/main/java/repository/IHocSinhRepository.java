package repository;

import model.HocSinh;

import java.sql.SQLException;
import java.util.List;

public interface IHocSinhRepository {
    void insertHocSinh(HocSinh hocSinh) throws SQLException;

    List<HocSinh> selectAllHocSinh();
}
