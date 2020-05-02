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
public class ProfessorCurso implements Serializable {
    
    @Id @SequenceGenerator(name = "GEN_ID_PROFESSOR_CURSO", sequenceName = "GEN_PROFESSOR_CURSO_ID")  
    @GeneratedValue(strategy = GenerationType.AUTO, generator="GEN_ID_PROFESSOR_CURSO")
    private Integer id;
    @OneToOne
    private Pessoa professor;
    @OneToOne
    private Curso curso;

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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
