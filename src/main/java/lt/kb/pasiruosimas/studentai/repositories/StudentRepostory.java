package lt.kb.pasiruosimas.studentai.repositories;

import lt.kb.pasiruosimas.studentai.model.Studentas;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepostory extends JpaRepository<Studentas,Integer> {
    @Override
@EntityGraph(attributePaths={"pazymiai"})
    List<Studentas> findAll();
@EntityGraph(attributePaths={"pazymiai"})
Optional<Studentas> findById(Integer id);
}
