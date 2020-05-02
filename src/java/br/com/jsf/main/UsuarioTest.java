package br.com.jsf.main;

import br.com.jsf.dao.PessoaDAO;
import br.com.jsf.model.Pessoa;


public class UsuarioTest {

    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Administrador");
        p.setCpf("10020030040");
        p.setEndereco("Rede");
        p.setEmail("admin@email.com");
        p.setTelefone("010010101");
        p.setLogin("admin");
        p.setSenha("admin@ad");
        p.setTipo("admin");
        new PessoaDAO().save(p);
    }

    public void rollBack() throws Exception {
//        if (sessao.getTransaction() != null) {
//            sessao.getTransaction().rollback();
//            String rollbackID = "SET GENERATOR GEN_CLIENTE_ID TO " + (getMaxID());
//            sessao.createSQLQuery(rollbackID).executeUpdate();
//        }
//        sessao.close();
    }
}
