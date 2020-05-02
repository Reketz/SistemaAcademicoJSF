package br.com.jsf.controller;

import br.com.jsf.dao.ProfessorTurmaDAO;
import br.com.jsf.model.ProfessorTurma;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name = "professorTurmaMB")
public class ProfessorTurmaController implements Serializable {

    private ProfessorTurmaDAO professorTurmaDAO = new ProfessorTurmaDAO();
    private ProfessorTurma professorTurma = new ProfessorTurma();

    public void add() {
        if (professorTurmaDAO.saveOrUpdate(professorTurma)) {
            displayMessager("Salvo", "ProfessorTurma salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "ProfessorTurma não salvo com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
        professorTurma = new ProfessorTurma();
    }

    public List<ProfessorTurma> list() {
        return professorTurmaDAO.list();
    }

    public List<ProfessorTurma> listPorProfessor(int id) {
        return professorTurmaDAO.listPorProfessor(id);
    }

    public void edit(ProfessorTurma u) {
        professorTurma = u;
    }

    public void displayMessager(String sumario, String detalhe, FacesMessage.Severity faces) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(faces, sumario, detalhe);
        context.addMessage(null, message);
    }

    public void remove(ProfessorTurma u) {
        if (professorTurmaDAO.remove(u.getId())) {
            displayMessager("Removido", "ProfessorTurma removido com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "ProfessorTurma não removido com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
    }

    public ProfessorTurmaDAO getProfessorTurmaDAO() {
        return professorTurmaDAO;
    }

    public void setProfessorTurmaDAO(ProfessorTurmaDAO professorTurmaDAO) {
        this.professorTurmaDAO = professorTurmaDAO;
    }

    public ProfessorTurma getProfessorTurma() {
        return professorTurma;
    }

    public void setProfessorTurma(ProfessorTurma professorTurma) {
        this.professorTurma = professorTurma;
    }
}
