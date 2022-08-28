package service.impl;

import model.BaiHoc;
import model.DoKho;
import model.LoaiBaiHoc;
import model.Module;
import repository.IBaiHocRepository;
import repository.impl.BaiHocRepository;
import service.IBaiHocService;

import java.sql.SQLException;
import java.util.List;

public class BaiHocService implements IBaiHocService {

    IBaiHocRepository baiHocRepository = new BaiHocRepository();

    @Override
    public void insertBaiHoc(BaiHoc baiHoc) throws SQLException {
        baiHocRepository.insertBaiHoc(baiHoc);
    }

    @Override
    public BaiHoc selectBaiHoc(int id) {
        return baiHocRepository.selectBaiHoc(id);
    }

    @Override
    public List<BaiHoc> selectAllBaiHoc() {
        return baiHocRepository.selectAllBaiHoc();
    }

    @Override
    public boolean deleteBaiHoc(int id) throws SQLException {
        return baiHocRepository.deleteBaiHoc(id);
    }

    @Override
    public boolean updateBaiHoc(BaiHoc baiHoc) throws SQLException {
        return baiHocRepository.updateBaiHoc(baiHoc);
    }

    @Override
    public List<LoaiBaiHoc> selectLoaiBaiHoc() {
        return baiHocRepository.selectLoaiBaiHoc();
    }

    @Override
    public List<DoKho> selectDoKho() {
        return baiHocRepository.selectDoKho();
    }

    @Override
    public List<Module> selectModule() {
        return baiHocRepository.selectModule();
    }

    @Override
    public List<BaiHoc> findByStatusDelete(String statusDelete) {
        return baiHocRepository.findByStatusDelete(statusDelete);
    }
}
