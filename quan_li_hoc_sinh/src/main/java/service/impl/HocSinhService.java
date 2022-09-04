package service.impl;

import common.Validation;
import model.HocSinh;
import model.LopHoc;
import repository.IHocSinhRepository;
import repository.impl.HocSinhRepository;
import service.IHocSinhService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HocSinhService implements IHocSinhService {

    IHocSinhRepository hocSinhRepository = new HocSinhRepository();

    @Override
    public Map<String, String> insertHocSinh(HocSinh hocSinh) throws SQLException {
        Map<String, String> map = new HashMap<>();
        if (hocSinh.getTuoiHocSinh()<18){
            map.put("tuoiHocSinh","Tuổi phải lớn hơn 18");
        }else if (hocSinh.getTuoiHocSinh()>80){
            map.put("tuoiHocSinh","Tuổi phải nhỏ hơn 80");
        }
        if ("".equals(hocSinh.getTuoiHocSinh())){
            map.put("tuoiHocSinh","Tuổi không được để trống ");
        }else if(!Validation.checkAge(String.valueOf(hocSinh.getTuoiHocSinh()))){
            map.put("tuoiHocSinh","Tuổi không đúng định dạng");
        }
        if (map.isEmpty()){
            hocSinhRepository.insertHocSinh(hocSinh);
        }
        return map;
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
    public List<HocSinh> findByNameAndAge(String name, String age) {
        if (age.equals("")){
            return  hocSinhRepository.findByName(name);
        }else {
            return hocSinhRepository.findByNameAndAge(name,age);
        }
    }

    @Override
    public List<HocSinh> findByNameOrAge(String name, int age) {
        return hocSinhRepository.findByNameOrAge(name, age);
    }


}
