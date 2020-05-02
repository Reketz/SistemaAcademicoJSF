package br.com.jsf.controller;

import br.com.jsf.dao.PessoaDAO;
import br.com.jsf.model.Pessoa;
import br.com.jsf.util.FacesMessageUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginMB")
@ViewScoped
public class LoginController implements Serializable {

    private String login;
    private String senha;
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private Pessoa pessoa = new Pessoa();
    private String filtro = "";
    private String nome = "";

    public void add() {
        if (pessoa.getNome() != null || !pessoa.getNome().isEmpty()) {
            if (pessoaDAO.saveOrUpdate(pessoa)) {
                displayMessager("Salvo", "Pessoa salvo com sucesso!", FacesMessage.SEVERITY_INFO);
            }
        } else {
            displayMessager("Erro", "Pessoa não salvo com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
        pessoa = new Pessoa();
    }

    public void addPorTipo(String tipo) {
        if (pessoa.getNome() != null || !pessoa.getNome().isEmpty()) {
            pessoa.setTipo(tipo);
            if (pessoaDAO.saveOrUpdate(pessoa)) {
                displayMessager("Salvo", "Pessoa salvo com sucesso!", FacesMessage.SEVERITY_INFO);
            }
        } else {
            displayMessager("Erro", "Pessoa não salvo com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
        pessoa = new Pessoa();
    }

    public List<Pessoa> list() {
        return pessoaDAO.list();
    }

    public List<Pessoa> listPorTipo(String type) {
        return pessoaDAO.listPorTipo(type);
    }

    public List<Pessoa> list(String filtro, String nome) {
        return filtro.isEmpty() && nome.isEmpty() ? pessoaDAO.list() : pessoaDAO.list(filtro, nome);
    }

    public void edit(Pessoa u) {
        pessoa = u;
    }

    public void displayMessager(String sumario, String detalhe, FacesMessage.Severity faces) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(faces, sumario, detalhe);
        context.addMessage(null, message);
    }

    public void remove(Pessoa u) {
        if (pessoaDAO.remove(u.getId())) {
            displayMessager("Removido", "Pessoa removido com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "Pessoa não removido com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
    }

    public PessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }

    public void setPessoaDAO(PessoaDAO usuarioDAO) {
        this.pessoaDAO = usuarioDAO;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa usuario) {
        this.pessoa = usuario;
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

    public void logar() {

        try {
            String paginaDestino = "login.xtml";
            StringBuilder builder = new StringBuilder();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Pessoa p;
            p = pessoaDAO.getPessoaByLogin(login, senha);

            if (p != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", p);
                paginaDestino = "";
                paginaDestino = builder.append("/")
                        .append(p.getTipo()
                                .toLowerCase()).append("/index.xhtml?faces-redirect=true").toString();
                System.out.println("Página de destino: " + paginaDestino);
            } else {
                FacesMessageUtil.fail("Login ou senha inválidos");
            }
            NavigationHandler navigation = facesContext.getApplication().getNavigationHandler();
            navigation.handleNavigation(facesContext, null, paginaDestino);

        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pessoa getPessoaSessao() {
        return (Pessoa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
    }

    public void logout() {
        FacesContext f = FacesContext.getCurrentInstance();
        f.getExternalContext().getSessionMap().remove("user");
        NavigationHandler navigation = f.getApplication().getNavigationHandler();
        navigation.handleNavigation(f, null, "/login.xhtml?faces-redirect=true");
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
