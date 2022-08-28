package repository;

import model.BaiHoc;
import model.DoKho;
import model.LoaiBaiHoc;
import model.Module;

import java.sql.SQLException;
import java.util.List;

public interface IBaiHocRepository {
    void insertBaiHoc(BaiHoc baiHoc) throws SQLException;

    BaiHoc selectBaiHoc(int id);

    List<BaiHoc> selectAllBaiHoc();

    boolean deleteBaiHoc(int id) throws SQLException;

    boolean updateBaiHoc(BaiHoc baiHoc) throws SQLException;

    List<LoaiBaiHoc> selectLoaiBaiHoc();

    List<DoKho> selectDoKho();

    List<Module> selectModule();

    List<BaiHoc> findByStatusDelete(String statusDelete);

}
