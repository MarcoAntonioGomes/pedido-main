package br.edu.infnet.pedido.model.persistencia;


import br.edu.infnet.pedido.model.entidade.Fornecedor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FornecedorDAOTest {

    IDAO fornecedorDAO = new FornecedorDAO();

    @Before
    public void inicializar() {

        Fornecedor fornecedor = new Fornecedor(null, "ABC Paulista", "46.926.226/0001-19", "abcpaulista@teste.com","999998888" );
        fornecedorDAO.salvar(fornecedor);
    }


    @Test
    public void testSalvar() {

        Fornecedor fornecedor = new Fornecedor(null, "Atacadao Supremo", "56.788.652/0001-97", "atacadaosupremo@teste.com","999995555" );
        boolean validacao = fornecedorDAO.salvar(fornecedor);
        Assert.assertTrue(validacao);
    }


    @Test
    public void testUpdate() {
        List<Fornecedor> fornecedores = fornecedorDAO.listarTodos();
        Fornecedor fornecedor = new Fornecedor(fornecedores.get(0).getCodigo(), "ABC Paulista 2", "46.926.226/0001-19", "abcpaulista@teste.com","999998888" );
        boolean validacao = fornecedorDAO.atualizar(fornecedor);
        Assert.assertTrue(validacao);
    }

    @Test
    public void testDelete() {
        List<Fornecedor> fornecedores = fornecedorDAO.listarTodos();
        Fornecedor fornecedor = new Fornecedor(fornecedores.get(fornecedores.size()-1).getCodigo(), "ABC Paulista 2", "46.926.226/0001-19", "abcpaulista@teste.com","999998888" );
        boolean validacao = fornecedorDAO.deletar(fornecedor);
        Assert.assertTrue(validacao);
    }


    @Test
    public void testListaClientes() {
        List<Fornecedor> fornecedores = fornecedorDAO.listarTodos();
        Assert.assertTrue(fornecedores.size() > 0);
    }


    @Test
    public void testObterCliente() {
        List<Fornecedor> fornecedores = fornecedorDAO.listarTodos();
        Fornecedor fornecedor = (Fornecedor) fornecedorDAO.obter(fornecedores.get(0).getCodigo());
        Assert.assertNotNull(fornecedor);
    }

}
