package br.com.jsf.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({
    @NamedQuery(name = "lista_por_professor", query = "select pt from ProfessorTurma pt where pt.professor.id = :professor_id")
})
public class ProfessorTurma implements Serializable {
    
    @Id @SequenceGenerator(name = "GEN_ID_PROFESSOR_TURMA", sequenceName = "GEN_PROFESSOR_TURMA_ID")  
    @GeneratedValue(strategy = GenerationType.AUTO, generator="GEN_ID_PROFESSOR_TURMA")
    private Integer id;
    @OneToOne
    private Pessoa professor;
    @OneToOne
    private Turma turma;

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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
