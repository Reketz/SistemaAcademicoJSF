package br.com.jsf.controller;

import br.com.jsf.dao.ProfessorCursoDAO;
import br.com.jsf.model.ProfessorCurso;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name = "professorCursoMB")
public class ProfessorCursoController implements Serializable {
    private ProfessorCursoDAO professorCursoDAO = new ProfessorCursoDAO();
    private ProfessorCurso professorCurso = new ProfessorCurso();

    public void add() {
        if (professorCursoDAO.saveOrUpdate(professorCurso)) {
            displayMessager("Salvo", "ProfessorCurso salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "ProfessorCurso não salvo com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
        professorCurso = new ProfessorCurso();
    }

    public List<ProfessorCurso> list() {
        return professorCursoDAO.list();
    }

    public void edit(ProfessorCurso u) {
        professorCurso = u;
    }

    public void displayMessager(String sumario, String detalhe, FacesMessage.Severity faces) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(faces, sumario, detalhe);
        context.addMessage(null, message);
    }

    public void remove(ProfessorCurso u) {
        if (professorCursoDAO.remove(u.getId())) {
            displayMessager("Removido", "ProfessorCurso removido com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "ProfessorCurso não removido com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
    }

    public ProfessorCursoDAO getProfessorCursoDAO() {
        return professorCursoDAO;
    }

    public void setProfessorCursoDAO(ProfessorCursoDAO professorCursoDAO) {
        this.professorCursoDAO = professorCursoDAO;
    }

    public ProfessorCurso getProfessorCurso() {
        return professorCurso;
    }

    public void setProfessorCurso(ProfessorCurso professorCurso) {
        this.professorCurso = professorCurso;
    }
}
