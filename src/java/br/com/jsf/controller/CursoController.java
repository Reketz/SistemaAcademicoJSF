package br.com.jsf.controller;

import br.com.jsf.dao.CursoDAO;
import br.com.jsf.model.Curso;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name = "cursoMB")
public class CursoController implements Serializable {
    private CursoDAO cursoDAO = new CursoDAO();
    private Curso curso = new Curso();

    public void add() {
        if (cursoDAO.saveOrUpdate(curso)) {
            displayMessager("Salvo", "Curso salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "Curso não salvo com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
        curso = new Curso();
    }

    public List<Curso> list() {
        return cursoDAO.list();
    }

    public void edit(Curso u) {
        curso = u;
    }

    public void displayMessager(String sumario, String detalhe, FacesMessage.Severity faces) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(faces, sumario, detalhe);
        context.addMessage(null, message);
    }

    public void remove(Curso u) {
        if (cursoDAO.remove(u.getId())) {
            displayMessager("Removido", "Curso removido com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "Curso não removido com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
    }

    public CursoDAO getCursoDAO() {
        return cursoDAO;
    }

    public void setCursoDAO(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
