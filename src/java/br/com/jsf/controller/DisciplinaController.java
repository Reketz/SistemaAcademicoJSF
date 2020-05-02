package br.com.jsf.controller;

import br.com.jsf.dao.DisciplinaDAO;
import br.com.jsf.model.Disciplina;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name = "disciplinaMB")
public class DisciplinaController implements Serializable {
    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    private Disciplina disciplina = new Disciplina();

    public void add() {
        if (disciplinaDAO.saveOrUpdate(disciplina)) {
            displayMessager("Salvo", "Disciplina salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "Disciplina não salvo com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
        disciplina = new Disciplina();
    }

    public List<Disciplina> list() {
        return disciplinaDAO.list();
    }

    public void edit(Disciplina u) {
        disciplina = u;
    }

    public void displayMessager(String sumario, String detalhe, FacesMessage.Severity faces) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(faces, sumario, detalhe);
        context.addMessage(null, message);
    }

    public void remove(Disciplina u) {
        if (disciplinaDAO.remove(u.getId())) {
            displayMessager("Removido", "Disciplina removido com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "Disciplina não removido com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
    }

    public DisciplinaDAO getDisciplinaDAO() {
        return disciplinaDAO;
    }

    public void setDisciplinaDAO(DisciplinaDAO disciplinaDAO) {
        this.disciplinaDAO = disciplinaDAO;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
