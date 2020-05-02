package br.com.jsf.dao;

import br.com.jsf.connection.ConnectionFactory;
import br.com.jsf.interfaces.DAO;
import br.com.jsf.model.Curso;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

public class CursoDAO implements DAO<Curso>, Serializable{
    
    @Override
    public boolean save(Curso u) {

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
    public boolean saveOrUpdate(Curso u) {

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
    public Curso get(int id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Curso u = null;
        try {
            u = em.find(Curso.class, id);
        } catch (Exception e) {
            System.out.println("erro: " + e);
        } finally {
            em.close();
        }
        return u;
    }

    @Override
    public List<Curso> list() {

        EntityManager em = new ConnectionFactory().getConnection();
        List<Curso> list = null;
        try {
            list = em.createQuery("from Curso u").getResultList();
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
            Curso u = em.find(Curso.class, id);
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
