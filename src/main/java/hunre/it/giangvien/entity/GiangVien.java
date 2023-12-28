package hunre.it.giangvien.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_giangvien")
public class GiangVien {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "ma_gv")
  private String maGvien;
  @Column(name = "ho_ten")
  private String hoTen;
  @Column(name = "ten_bmon")
  private String tenBmon;
  @Column(name = "hs_luong")
  private int heSo;
  @Column(name = "t_trang")
  private String status;
}
