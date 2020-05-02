package br.com.jsf.dao;

import br.com.jsf.connection.ConnectionFactory;
import br.com.jsf.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

public class UsuarioDAO implements Serializable{

    public boolean save(Usuario u) {

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

    public boolean saveOrUpdate(Usuario u) {

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

    public Usuario get(int id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Usuario u = null;
        try {
            u = em.find(Usuario.class, id);
        } catch (Exception e) {
            System.out.println("erro: " + e);
        } finally {
            em.close();
        }
        return u;
    }

    public List<Usuario> list() {

        EntityManager em = new ConnectionFactory().getConnection();
        List<Usuario> list = null;
        try {
            list = em.createQuery("from Usuario u").getResultList();
        } catch (Exception e) {
            System.out.println("erro: " + e);
        } finally {
            em.close();
        }
        return list;
    }

    public boolean remove(int id) {

        EntityManager em = new ConnectionFactory().getConnection();
        try {
           Usuario u = em.find(Usuario.class, id);
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
