package service;

import model.HocSinh;
import model.LopHoc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IHocSinhService {
    Map<String, String> insertHocSinh(HocSinh hocSinh) throws SQLException;

    HocSinh selectHocSinh(int id);

    List<HocSinh> selectAllHocSinh();

    boolean deleteHocSinh(int id) throws SQLException;

    boolean updateHocSinh(HocSinh hocSinh) throws SQLException;

    List<LopHoc> selectLopHoc();

    List<HocSinh> findByStatusDelete(String statusDelete);

    List<HocSinh> findByName(String name);

    List<HocSinh> findByNameAndAge(String name, String age);

    List<HocSinh> findByNameOrAge(String name, int age);
}
