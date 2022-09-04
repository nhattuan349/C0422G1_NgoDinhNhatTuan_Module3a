package service.impl;

import model.BanHang;
import model.KhuyenMai;
import repository.IBanHangRepository;
import repository.impl.BanHangRepository;
import service.IBanHangService;

import java.sql.SQLException;
import java.util.List;

public class BanHangService implements IBanHangService {

    IBanHangRepository banHangRepository = new BanHangRepository();

    @Override
    public void insertBanHang(BanHang banHang) throws SQLException {
        banHangRepository.insertBanHang(banHang);
    }

    @Override
    public BanHang selectBanHang(int id) {
        return banHangRepository.selectBanHang(id);
    }

    @Override
    public List<BanHang> selectAllBanHang() {
        return banHangRepository.selectAllBanHang();
    }

    @Override
    public boolean deleteBanHang(int id) throws SQLException {
        return banHangRepository.deleteBanHang(id);
    }

    @Override
    public boolean updateBanHang(BanHang banHang) throws SQLException {
        return banHangRepository.updateBanHang(banHang);
    }

    @Override
    public List<KhuyenMai> selectKhuyenMai() {
        return banHangRepository.selectKhuyenMai();
    }

    @Override
    public List<BanHang> findByStatusDelete(String statusDelete) {
        return banHangRepository.findByStatusDelete(statusDelete);
    }

    @Override
    public List<BanHang> findByName(String name) {
        return banHangRepository.findByName(name);
    }

    @Override
    public List<BanHang> findByNameAndPhone(String name, String phone) {
        if (phone.equals("")){
            return  banHangRepository.findByName(name);
        }else {
            return banHangRepository.findByNameAndPhone(name,phone);
        }
    }
}
