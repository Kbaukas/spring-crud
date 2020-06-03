package lt.kb.pasiruosimas.studentai.api;

import lt.kb.pasiruosimas.studentai.model.Studentas;
import lt.kb.pasiruosimas.studentai.repositories.StudentRepostory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/studentai")
public class StudentApi {
    @Resource
    StudentRepostory studentRepostory;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    @GetMapping("/visi")
    String getAllStudents(Model model) {
        List<Studentas> studentai = studentRepostory.findAll();
        model.addAttribute("studentai", studentai);

        return "index";
    }

    @GetMapping("{id}")
    String getStudentById(Model model, @PathVariable Integer id) {
        Optional<Studentas> studentas = studentRepostory.findById(id);
        model.addAttribute("studentas", studentas.get());
        return "studentuView/getPazymius";
    }

    @RequestMapping(value = "delete/{id}")
    String deletePost(@PathVariable Integer id) {
        studentRepostory.deleteById(id);
        return "redirect:/studentai/visi";
    }

    @RequestMapping(value = "edit/{id}")
    String showEdit(@PathVariable Integer id, Model model) {
        Studentas studentas = studentRepostory.findById(id).orElseThrow(() -> new IllegalArgumentException("nera Studento"));

        model.addAttribute("studentas", studentas);
        return "studentuView/edit";
    }
    @RequestMapping("update/{id}")
     String updateStudenta(@PathVariable("id") Integer id, Studentas student, Model model) {
//        if (result.hasErrors()) {
//            student.setId(id);
//            return "update-student";
//        }

        studentRepostory.save(student);
//        model.addAttribute("studentas", studentRepository.findAll());
        return "redirect:/studentai/visi";
    }
    @GetMapping("sukurtiForma")
    public String showSignUpForm(Studentas studentas) {
        return "studentuView/sukurtiNauja";
    }
    @RequestMapping(value = "sukurti")
    public String addStudent(@ModelAttribute @Valid Studentas studentas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("klaida");
            return "studentuView/sukurtiNauja";
        }
//        if(studentas.getVardas()==null)return "sukurtiNauja";

        studentRepostory.save(studentas);
        return "redirect:/studentai/visi";
    }

}
