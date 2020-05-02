package br.com.jsf.model;

import br.com.jsf.util.SampleEntity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Disciplina implements Serializable, SampleEntity{
    
    @Id @SequenceGenerator(name = "GEN_ID_DISCIPLINA", sequenceName = "GEN_DISCIPLINA_ID")  
    @GeneratedValue(strategy = GenerationType.AUTO, generator="GEN_ID_DISCIPLINA")
    private Integer id;
    private String nome;   
    @ManyToOne
    private Curso curso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Disciplina && ((Disciplina)obj).getId().equals(this.getId()));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.curso);
        return hash;
    }
}
