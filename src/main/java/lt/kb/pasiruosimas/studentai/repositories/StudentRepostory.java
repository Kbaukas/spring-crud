package lt.kb.pasiruosimas.studentai.repositories;

import lt.kb.pasiruosimas.studentai.model.Studentas;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepostory extends JpaRepository<Studentas,Integer> {
    @Override
@EntityGraph(attributePaths={"pazymiai"})
    List<Studentas> findAll();
@EntityGraph(attributePaths={"pazymiai"})
Optional<Studentas> findById(Integer id);
@Query("select s from Studentas s where s.vardas like %:filter%")
    List<Studentas> findByFilter(@Param("filter") String filter);
}
