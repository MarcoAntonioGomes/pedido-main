package br.edu.infnet.pedido.model.entidade;

public class Fornecedor {

    private Long codigo;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;

    public Fornecedor() {
    }

    public Fornecedor(Long codigo, String nome, String cnpj, String email, String telefone) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Fornecedor [codigo=" + codigo + ", nome=" + nome + ", cnpj=" + cnpj + ", email=" + email + ", telefone="
                + telefone + "]";
    }



}
