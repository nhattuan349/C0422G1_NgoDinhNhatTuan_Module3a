package service;

import model.HocSinh;

import java.sql.SQLException;
import java.util.List;

public interface IHocSinhService {
    void insertHocSinh(HocSinh hocSinh) throws SQLException;

    List<HocSinh> selectAllHocSinh();
}
