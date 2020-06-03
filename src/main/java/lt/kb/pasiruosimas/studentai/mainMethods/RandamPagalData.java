package lt.kb.pasiruosimas.studentai.mainMethods;

import lt.kb.pasiruosimas.studentai.repositories.PazymysRepository;
import lt.kb.pasiruosimas.studentai.repositories.StudentRepostory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Order(value = 2)
@Component

public class RandamPagalData implements CommandLineRunner {
    @Resource
    StudentRepostory studentRepostory;
    @Resource
    PazymysRepository pazymysRepository;

    @Override
    public void run(String... args) throws Exception {
        pazymysRepository.findAll().stream().filter(pazymys -> pazymys.getData().getYear()==2018).forEach(pazymys -> System.out.println(pazymys.getStudentas().getVardas()));

    }
}
