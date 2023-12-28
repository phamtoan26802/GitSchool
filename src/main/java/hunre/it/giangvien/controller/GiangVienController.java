package hunre.it.giangvien.controller;

import hunre.it.giangvien.entity.GiangVien;
import hunre.it.giangvien.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GiangVienController {

  @Autowired
  private GiangVienService service;

  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/giangvien_register")
  public String giangvienRegister() {
    return "giangvienRegister";
  }

  @GetMapping("/available_giangviens")
  public ModelAndView getAllGiangVien() {
    List<GiangVien> list = service.getAllGiangVien();
    return new ModelAndView("giangvienList", "giangvien", list);
  }

  @PostMapping("/save")
  public String addGiangVien(@ModelAttribute GiangVien e) {
    service.save(e);
    List<String> ca = new ArrayList<>();
    return "redirect:/available_giangviens";
  }


  @RequestMapping("/editGiangVien/{id}")
  public String editGiangVien(@PathVariable("id") int id, Model model) {
    GiangVien e = service.getGiangVienById(id);
    model.addAttribute("giangvien", e);
    return "giangvienEdit";
  }

  @RequestMapping("/deleteGiangVien/{id}")
  public String deleteGiangVien(@PathVariable("id") int id) {
    service.deleteById(id);
    return "redirect:/available_giangviens";
  }

  @GetMapping("/search")
  public String searchGiangVien(@RequestParam("tenBmon") String tenBmon,
                               @RequestParam("heSo") int heSo,
                               Model theModel) {
    List<GiangVien> theGiangVien = service.searchGiangVien(tenBmon, heSo);
    theModel.addAttribute("giangvien", theGiangVien);
    return "search-giangvien";
  }

}
