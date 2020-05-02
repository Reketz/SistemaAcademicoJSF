package br.com.jsf.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({
})
public class ProfessorDisciplina implements Serializable {
    
    @Id @SequenceGenerator(name = "GEN_ID_PROFESSOR_DISCIPLINA", sequenceName = "GEN_PROFESSOR_DISCIPLINA_ID")  
    @GeneratedValue(strategy = GenerationType.AUTO, generator="GEN_ID_PROFESSOR_DISCIPLINA")
    private Integer id;
    @OneToOne
    private Pessoa professor;
    @OneToOne
    private Disciplina disciplina;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getProfessor() {
        return professor;
    }

    public void setProfessor(Pessoa professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
