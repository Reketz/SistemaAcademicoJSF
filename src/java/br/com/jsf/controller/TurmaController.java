package br.com.jsf.controller;

import br.com.jsf.dao.TurmaDAO;
import br.com.jsf.model.Turma;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name = "turmaMB")
public class TurmaController implements Serializable {
    private TurmaDAO turmaDAO = new TurmaDAO();
    private Turma turma = new Turma();

    public void add() {
        if (turmaDAO.saveOrUpdate(turma)) {
            displayMessager("Salvo", "Turma salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "Turma não salvo com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
        turma = new Turma();
    }

    public List<Turma> list() {
        return turmaDAO.list();
    }

    public void edit(Turma u) {
        turma = u;
    }

    public void displayMessager(String sumario, String detalhe, FacesMessage.Severity faces) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(faces, sumario, detalhe);
        context.addMessage(null, message);
    }

    public void remove(Turma u) {
        if (turmaDAO.remove(u.getId())) {
            displayMessager("Removido", "Turma removido com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            displayMessager("Erro", "Turma não removido com sucesso!", FacesMessage.SEVERITY_ERROR);
        }
    }

    public TurmaDAO getTurmaDAO() {
        return turmaDAO;
    }

    public void setTurmaDAO(TurmaDAO turmaDAO) {
        this.turmaDAO = turmaDAO;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
