package br.com.jsf.dao;

import br.com.jsf.connection.ConnectionFactory;
import br.com.jsf.interfaces.DAO;
import br.com.jsf.model.Disciplina;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

public class DisciplinaDAO implements DAO<Disciplina>, Serializable {

    @Override
    public boolean save(Disciplina u) {

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
    public boolean saveOrUpdate(Disciplina u) {

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
    public Disciplina get(int id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Disciplina u = null;
        try {
            u = em.find(Disciplina.class, id);
        } catch (Exception e) {
            System.out.println("erro: " + e);
        } finally {
            em.close();
        }
        return u;
    }

    @Override
    public List<Disciplina> list() {

        EntityManager em = new ConnectionFactory().getConnection();
        List<Disciplina> list = null;
        try {
            list = em.createQuery("from Disciplina u").getResultList();
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
            Disciplina u = em.find(Disciplina.class, id);
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
}
