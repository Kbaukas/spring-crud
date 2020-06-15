package lt.kb.pasiruosimas.studentai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pazymiai")
public class Pazymys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "studentas_id", referencedColumnName = "id")
    @JsonIgnore
    Studentas studentas;

    LocalDate data;
    Integer pazymys;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Studentas getStudentas() {
        return studentas;
    }

    public void setStudentas(Studentas studentas) {
        this.studentas = studentas;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getPazymys() {
        return pazymys;
    }

    public void setPazymys(Integer pazymys) {
        this.pazymys = pazymys;
    }



}


