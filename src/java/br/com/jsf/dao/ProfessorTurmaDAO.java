package br.com.jsf.dao;

import br.com.jsf.connection.ConnectionFactory;
import br.com.jsf.interfaces.DAO;
import br.com.jsf.model.ProfessorTurma;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ProfessorTurmaDAO implements DAO<ProfessorTurma>, Serializable {

    @Override
    public boolean save(ProfessorTurma u) {

        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
//            String rollbackID = "SET GENERATOR GEN_CLIENTE_ID TO " + (getMaxID());
//            em.createSQLQuery(rollbackID).executeUpdate();
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean saveOrUpdate(ProfessorTurma u) {

        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            if (u.getId() == null) {
                em.persist(u);
            } else {
                em.merge(u);
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
//            String rollbackID = "SET GENERATOR GEN_CLIENTE_ID TO " + (getMaxID());
//            em.createSQLQuery(rollbackID).executeUpdate();
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public ProfessorTurma get(int id) {

        EntityManager em = new ConnectionFactory().getConnection();
        ProfessorTurma u = null;
        try {
            u = em.find(ProfessorTurma.class, id);
        } catch (Exception e) {
            System.out.println("erro: " + e);
        } finally {
            em.close();
        }
        return u;
    }

    @Override
    public List<ProfessorTurma> list() {

        EntityManager em = new ConnectionFactory().getConnection();
        List<ProfessorTurma> list = null;
        try {
            list = em.createQuery("from ProfessorTurma u").getResultList();
        } catch (Exception e) {
            System.out.println("erro: " + e);
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public boolean remove(int id) {

        EntityManager em = new ConnectionFactory().getConnection();
        try {
            ProfessorTurma u = em.find(ProfessorTurma.class, id);
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("erro: " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    }

    public List<ProfessorTurma> list(String tipo, String nome) {
        System.out.println("Chamou a lista com filtro");
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("tipo", tipo);
        parametros.put("nome", nome);
        try {
            return (List<ProfessorTurma>) createNamedQuery("lista_filtro", parametros).getResultList();
        } catch (NoResultException ne) {
            System.out.println("Erro ao listar " + ne);
            return null;
        }
    }

    public List<ProfessorTurma> listPorProfessor(int professor_id) {
        System.out.println("Chamou a lista com filtro");
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("professor_id", professor_id);
        try {
            return (List<ProfessorTurma>) createNamedQuery("lista_por_professor", parametros).getResultList();
        } catch (NoResultException ne) {
            System.out.println("Erro ao listar " + ne);
            return null;
        }
    }

    public ProfessorTurma getProfessorTurmaByLogin(String login, String senha) throws Exception {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("login", login);
        parametros.put("senha", senha);
        try {
            return (ProfessorTurma) createNamedQuery("login", parametros).getSingleResult();
        } catch (NoResultException ne) {
            return null;
        }
    }

    private Query createNamedQuery(String query, Map<String, Object> parametros) {
        EntityManager em = new ConnectionFactory().getConnection();
        Query q = em.createNamedQuery(query);

        if (parametros != null) {
            parametros.entrySet().forEach((param) -> {
                q.setParameter(param.getKey(), param.getValue());
            });
        }
        return q;
    }

}
