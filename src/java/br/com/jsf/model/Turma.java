package br.com.jsf.model;

import br.com.jsf.util.SampleEntity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Turma implements Serializable, SampleEntity {

    @Id
    @SequenceGenerator(name = "GEN_ID_TURMA", sequenceName = "GEN_TURMA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_ID_TURMA")
    private Integer id;
    private String periodo;
    @Column(unique = true, nullable = false)
    private String sigla;
    @ManyToOne
    private Curso curso;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Turma && ((Turma) obj).getId().equals(this.getId()));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.periodo);
        hash = 67 * hash + Objects.hashCode(this.sigla);
        hash = 67 * hash + Objects.hashCode(this.curso);
        return hash;
    }
}
