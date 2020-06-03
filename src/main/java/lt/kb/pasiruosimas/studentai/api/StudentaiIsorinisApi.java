package lt.kb.pasiruosimas.studentai.api;

import lt.kb.pasiruosimas.studentai.model.Studentas;
import lt.kb.pasiruosimas.studentai.repositories.StudentRepostory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/studentai")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentaiIsorinisApi {
    @Resource
    StudentRepostory studentRepostory;


    @GetMapping
    List<Studentas> getAllStudents() {
        return studentRepostory.findAll();
    }
}
