package service.impl;

import model.HocSinh;
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
    public List<HocSinh> selectAllHocSinh() {
        return hocSinhRepository.selectAllHocSinh();
    }
}
