package service.impl;

import model.HoKhau;
import model.ThanhVien;
import repository.IHoKhauRepository;
import repository.impl.HoKhauRepository;
import service.IHoKhauService;

import java.sql.SQLException;
import java.util.List;

public class HoKhauService implements IHoKhauService {

    IHoKhauRepository hoKhauRepository = new HoKhauRepository();

    @Override
    public HoKhau selectHoKhau(int id) {
        return hoKhauRepository.selectHoKhau(id);
    }

    @Override
    public List<HoKhau> selectAllHoKhau() {
        return hoKhauRepository.selectAllHoKhau();
    }

    @Override
    public boolean updateHoKhau(HoKhau hoKhau) throws SQLException {
        return hoKhauRepository.updateHoKhau(hoKhau);
    }

    @Override
    public List<ThanhVien> selectThanhVien() {
        return hoKhauRepository.selectThanhVien();
    }
}
