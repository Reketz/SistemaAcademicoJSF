package br.com.jsf.controller;

import br.com.jsf.dao.ProfessorDisciplinaDAO;
import br.com.jsf.model.ProfessorDisciplina;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name = "professorDisciplinaMB")
public class ProfessorDisciplinaController implements Serializable {
    private ProfessorDisciplinaDAO professorDisciplinaDAO = new ProfessorDisciplinaDAO();
    private ProfessorDisciplina professorDisciplina = new ProfessorDisciplina();

    public void add() {
        if (professorDisciplinaDAO.saveOrUpdate(professorDisciplina)) {
            displayMessager("Salvo", "ProfessorDisciplina salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "ProfessorDisciplina não salvo com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
        professorDisciplina = new ProfessorDisciplina();
    }

    public List<ProfessorDisciplina> list() {
        return professorDisciplinaDAO.list();
    }

    public void edit(ProfessorDisciplina u) {
        professorDisciplina = u;
    }

    public void displayMessager(String sumario, String detalhe, FacesMessage.Severity faces) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(faces, sumario, detalhe);
        context.addMessage(null, message);
    }

    public void remove(ProfessorDisciplina u) {
        if (professorDisciplinaDAO.remove(u.getId())) {
            displayMessager("Removido", "ProfessorDisciplina removido com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "ProfessorDisciplina não removido com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
    }

    public ProfessorDisciplinaDAO getProfessorDisciplinaDAO() {
        return professorDisciplinaDAO;
    }

    public void setProfessorDisciplinaDAO(ProfessorDisciplinaDAO professorDisciplinaDAO) {
        this.professorDisciplinaDAO = professorDisciplinaDAO;
    }

    public ProfessorDisciplina getProfessorDisciplina() {
        return professorDisciplina;
    }

    public void setProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
        this.professorDisciplina = professorDisciplina;
    }
}
