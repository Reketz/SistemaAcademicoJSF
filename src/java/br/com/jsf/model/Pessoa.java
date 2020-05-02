package br.com.jsf.model;

import br.com.jsf.util.SampleEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({
    @NamedQuery(name = "login", query = "select p from Pessoa p where p.login=:login and p.senha=:senha")
    ,
@NamedQuery(name = "lista_filtro", query = "select p from Pessoa p where p.tipo=:tipo or p.nome like :nome")
    ,
@NamedQuery(name = "lista_tipo", query = "select p from Pessoa p where p.tipo=:tipo")
})
public class Pessoa implements Serializable, SampleEntity {

    @Id
    @SequenceGenerator(name = "GEN_ID_PESSOA", sequenceName = "GEN_PESSOA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_ID_PESSOA")
    private Integer id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private String login;
    private String senha;
    private String tipo;
    private String titulacao;

    @Override
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Pessoa && ((Pessoa) obj).getId().equals(this.getId()));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.cpf);
        hash = 23 * hash + Objects.hashCode(this.endereco);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.telefone);
        hash = 23 * hash + Objects.hashCode(this.login);
        hash = 23 * hash + Objects.hashCode(this.senha);
        hash = 23 * hash + Objects.hashCode(this.tipo);
        hash = 23 * hash + Objects.hashCode(this.titulacao);
        return hash;
    }
}
