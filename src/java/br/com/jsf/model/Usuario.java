package br.com.jsf.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario implements Serializable{
    
    @Id @SequenceGenerator(name = "GEN_ID_USUARIO", sequenceName = "GEN_USUARIO_ID")  
    @GeneratedValue(strategy = GenerationType.AUTO, generator="GEN_ID_USUARIO")
    private Integer id;
    private String login;
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
