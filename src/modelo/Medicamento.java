package modelo;

import java.time.LocalDate;

/**
 * Classe que representa um medicamento, implementando a interface ProdutoHospitalar.
 * Contém informações como nome, código, data de validade, quantidade e fabricante do medicamento.
 * 
 * @author renna
 */
public class Medicamento implements ProdutoHospitalar {
    private String nome;
    private String codigo;
    private LocalDate dataValidade;
    private int quantidade;
    private String fabricante;

    /**
     * Construtor da classe Medicamento.
     * 
     * @param nome Nome do medicamento.
     * @param codigo Código do medicamento.
     * @param dataValidade Data de validade do medicamento.
     * @param quantidade Quantidade disponível do medicamento.
     * @param fabricante Fabricante do medicamento.
     */
    public Medicamento(String nome, String codigo, LocalDate dataValidade, int quantidade, String fabricante) {
        this.nome = nome;
        this.codigo = codigo;
        this.dataValidade = dataValidade;
        this.quantidade = quantidade;
        this.fabricante = fabricante;
    }

    /**
     * Obtém o nome do medicamento.
     * 
     * @return O nome do medicamento.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do medicamento.
     * 
     * @param nome O nome do medicamento.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o código do medicamento.
     * 
     * @return O código do medicamento.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o código do medicamento.
     * 
     * @param codigo O código do medicamento.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém a data de validade do medicamento.
     * 
     * @return A data de validade do medicamento.
     */
    public LocalDate getDataValidade() {
        return dataValidade;
    }

    /**
     * Define a data de validade do medicamento.
     * 
     * @param dataValidade A data de validade do medicamento.
     */
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * Verifica se o medicamento está dentro do prazo de validade.
     * 
     * @return true se a data de validade não foi atingida; false caso contrário.
     */
    public boolean inValidade() {
        return LocalDate.now().isBefore(dataValidade);
    }

    /**
     * Obtém a quantidade disponível do medicamento.
     * 
     * @return A quantidade disponível do medicamento.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade disponível do medicamento.
     * 
     * @param quantidade A quantidade disponível do medicamento.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Obtém o nome do fabricante do medicamento.
     * 
     * @return O nome do fabricante do medicamento.
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * Define o nome do fabricante do medicamento.
     * 
     * @param fabricante O nome do fabricante do medicamento.
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * Retorna um relatório completo sobre o medicamento, incluindo seu nome, código, 
     * data de validade, quantidade disponível e fabricante.
     * 
     * @return Uma string contendo todas as informações sobre o medicamento.
     */
    @Override
    public String relatorio() {
        return "Medicamento [Nome: " + nome + ", Código: " + codigo +
               ", Data de Validade: " + dataValidade + ", Quantidade: " + quantidade +
               ", Fabricante: " + fabricante + "]";
    }
}
