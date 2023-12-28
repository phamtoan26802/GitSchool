package hunre.it.giangvien.repository;

import hunre.it.giangvien.entity.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, Integer> {
    List<GiangVien> findByTenBmonAndHeSoLessThanEqual(String tenBmon, int heSo);
}
