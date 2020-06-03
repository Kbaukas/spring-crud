package lt.kb.pasiruosimas.studentai.mainMethods;

import lt.kb.pasiruosimas.studentai.repositories.StudentRepostory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Order(value = 1)
public class UzsikraunamStudentus implements CommandLineRunner {
    @Resource
    StudentRepostory studentRepostory;

    @Override

    public void run(String... args) throws Exception {
        studentRepostory.findAll().stream()
                .forEach(studentas ->{ System.out.println(studentas.getElPastas());
        studentas.getPazymiai()
                .forEach(pazymys -> System.out.println(pazymys.getPazymys()));});


    }
}
