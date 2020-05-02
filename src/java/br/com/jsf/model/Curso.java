package br.com.jsf.model;

import br.com.jsf.util.SampleEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Curso implements Serializable, SampleEntity{
    
    @Id @SequenceGenerator(name = "GEN_ID_CURSO", sequenceName = "GEN_CURSO_ID")  
    @GeneratedValue(strategy = GenerationType.AUTO, generator="GEN_ID_CURSO")
    private Integer id;
    private String nome;
    private String area;

    @Override
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.area);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Curso && ((Curso)obj).getId().equals(this.getId()));
    }
}
