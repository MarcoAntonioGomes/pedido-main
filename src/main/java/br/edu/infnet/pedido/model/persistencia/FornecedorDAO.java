package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Cliente;
import br.edu.infnet.pedido.model.entidade.Fornecedor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO extends  JdbcDAO<Fornecedor>{


    @Override
    public Boolean salvar(Fornecedor fornecedor) {
        String sql = "insert into fornecedor(nome, cnpj, email, telefone ) values (?, ?, ?, ?)";

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1,  fornecedor.getNome());
            pstm.setString(2,  fornecedor.getCnpj());
            pstm.setString(3,  fornecedor.getEmail());
            pstm.setString(4,  fornecedor.getTelefone());

            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public Boolean atualizar(Fornecedor fornecedor) {

        String sql = "update  fornecedor set nome = ?, cnpj = ?, email = ?, telefone = ?  where codigo = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getCnpj());
            pstm.setString(3, fornecedor.getEmail());
            pstm.setString(4, fornecedor.getTelefone());
            pstm.setLong(5, fornecedor.getCodigo());

            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deletar(Fornecedor fornecedor) {

        String sql = "delete from fornecedor where codigo = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, fornecedor.getCodigo());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }

    @Override
    public Fornecedor obter(Long codigo) {

        String sql = "select * from fornecedor where codigo = ?";
        Fornecedor fornecedor = new Fornecedor();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, codigo);
            rs = pstm.executeQuery();
            if(rs.next()) {

                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCodigo(rs.getLong("codigo"));

            }
            return fornecedor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Fornecedor> listarTodos() {
        String sql = "select * from fornecedor";
        List<Fornecedor> fornecedores = new ArrayList<>();
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCodigo(rs.getLong("codigo"));
                fornecedores.add(fornecedor);
            }
            return fornecedores;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
