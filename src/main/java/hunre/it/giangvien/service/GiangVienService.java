package hunre.it.giangvien.service;

import hunre.it.giangvien.entity.GiangVien;
import hunre.it.giangvien.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiangVienService {

  @Autowired
  private GiangVienRepository eRepo;

  public void save(GiangVien e) {
    eRepo.save(e);
  }

  public List<GiangVien> getAllGiangVien() {
    return eRepo.findAll();
  }

  public GiangVien getGiangVienById(int id) {
    return eRepo.findById(id).get();
  }

  public void deleteById(int id) {
    eRepo.deleteById(id);
  }
  public List<GiangVien> searchGiangVien(String tenBmon, int heSo) {
    return eRepo.findByTenBmonAndHeSoLessThanEqual( tenBmon, heSo);
  }

}
