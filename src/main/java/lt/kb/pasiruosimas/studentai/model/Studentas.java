package lt.kb.pasiruosimas.studentai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "studentai")
public class Studentas {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    String vardas;
    @NotNull
    String pavarde;
    @NotNull
    String elPastas;
    @OneToMany(mappedBy = "studentas")
    Set<Pazymys> pazymiai = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getElPastas() {
        return elPastas;
    }

    public void setElPastas(String elPastas) {
        this.elPastas = elPastas;
    }

    public Set<Pazymys> getPazymiai() {
        return pazymiai;
    }

    public void setPazymiai(Set<Pazymys> pazymiai) {
        this.pazymiai = pazymiai;
    }
}
