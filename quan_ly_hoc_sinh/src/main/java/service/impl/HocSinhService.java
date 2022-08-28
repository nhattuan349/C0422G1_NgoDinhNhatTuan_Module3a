package service.impl;

import model.HocSinh;
import model.LopHoc;
import repository.IHocSinhRepository;
import repository.impl.HocSinhRepository;
import service.IHocSinhService;

import java.sql.SQLException;
import java.util.List;

public class HocSinhService implements IHocSinhService {

    IHocSinhRepository hocSinhRepository = new HocSinhRepository();

    @Override
    public void insertHocSinh(HocSinh hocSinh) throws SQLException {
        hocSinhRepository.insertHocSinh(hocSinh);
    }

    @Override
    public HocSinh selectHocSinh(int id) {
        return hocSinhRepository.selectHocSinh(id);
    }

    @Override
    public List<HocSinh> selectAllHocSinh() {
        return hocSinhRepository.selectAllHocSinh();
    }

    @Override
    public boolean deleteHocSinh(int id) throws SQLException {
        return hocSinhRepository.deleteHocSinh(id);
    }

    @Override
    public boolean updateHocSinh(HocSinh hocSinh) throws SQLException {
        return hocSinhRepository.updateHocSinh(hocSinh);
    }

    @Override
    public List<LopHoc> selectLopHoc() {
        return hocSinhRepository.selectLopHoc();
    }

    @Override
    public List<HocSinh> findByStatusDelete(String statusDelete) {
        return hocSinhRepository.findByStatusDelete(statusDelete);
    }

    @Override
    public List<HocSinh> findByName(String name) {
        return hocSinhRepository.findByName(name);
    }

    @Override
    public List<HocSinh> findByNameAndAge(String name, int age) {
        return hocSinhRepository.findByNameAndAge(name, age);
    }

    @Override
    public List<HocSinh> findByNameOrAge(String name, int age) {
        return hocSinhRepository.findByNameOrAge(name, age);
    }


}
