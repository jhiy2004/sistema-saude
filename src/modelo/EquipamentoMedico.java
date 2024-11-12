package modelo;

import interfaces.ProdutoHospitalar;
import java.time.LocalDate;

/**
 * Classe que representa um equipamento médico, implementando a interface ProdutoHospitalar.
 * Contém informações sobre o nome, código, data de validade, quantidade e fabricante do equipamento.
 * 
 * @author renna
 */
public class EquipamentoMedico implements ProdutoHospitalar {
    private String nome;
    private String codigo;
    private LocalDate dataValidade;
    private int quantidade;
    private String fabricante;

    /**
     * Construtor da classe EquipamentoMedico.
     * 
     * @param nome O nome do equipamento médico.
     * @param dataValidade A data de validade do equipamento médico.
     * @param codigo O código do equipamento médico.
     * @param quantidade A quantidade disponível do equipamento médico.
     * @param fabricante O nome do fabricante do equipamento médico.
     */
    public EquipamentoMedico(String nome, LocalDate dataValidade, String codigo, int quantidade, String fabricante) {
        this.nome = nome;
        this.dataValidade = dataValidade;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.fabricante = fabricante;
    }

    /**
     * Obtém o nome do equipamento médico.
     * 
     * @return String O nome do equipamento.
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o código do equipamento médico.
     * 
     * @return String O código do equipamento.
     */
    @Override
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtém a quantidade disponível do equipamento médico.
     * 
     * @return int A quantidade do equipamento disponível.
     */
    @Override
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Obtém o nome do fabricante do equipamento médico.
     * 
     * @return String O nome do fabricante.
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * Obtém a data de validade do equipamento médico.
     * 
     * @return LocalDate A data de validade do equipamento.
     */
    public LocalDate getDataValidade() {
        return dataValidade;
    }

    /**
     * Define a data de validade do equipamento médico.
     * 
     * @param dataValidade A nova data de validade do equipamento.
     */
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * Método para verificar se o equipamento médico ainda está dentro da validade.
     * Este método compara a data de validade com a data atual.
     * 
     * @return boolean Retorna true se o equipamento está dentro da validade, false caso contrário.
     */
    public boolean inValidade() {
        return LocalDate.now().isBefore(dataValidade);
    }

    /**
     * Gera um relatório com as informações detalhadas sobre o equipamento médico.
     * 
     * @return String O relatório com as informações do equipamento médico.
     */
    @Override
    public String relatorio() {
        return "Equipamento Médico [Nome: " + nome + ", Código: " + codigo +
               ", Quantidade: " + quantidade + ", Fabricante: " + fabricante + 
               ", Data de Validade: " + dataValidade + "]";
    }
}
