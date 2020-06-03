package lt.kb.pasiruosimas.studentai.repositories;

import lt.kb.pasiruosimas.studentai.model.Pazymys;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PazymysRepository  extends JpaRepository<Pazymys,Integer> {
    @Override
    @EntityGraph(attributePaths={"studentas"})
    List<Pazymys> findAll();
}
