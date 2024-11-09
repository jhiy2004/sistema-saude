package modelo;

import java.time.LocalDate;
import java.time.LocalDate;

public class Medicamento implements ProdutoHospitalar{
    private String nome;
    private String codigo;
    private LocalDate dataValidade;
    private int quantidade;
    private String fabricante;

    public Medicamento(String nome, String codigo, LocalDate dataValidade, int quantidade, String fabricante) {
        this.nome = nome;
        this.codigo = codigo;
        this.dataValidade = dataValidade;
        this.quantidade = quantidade;
        this.fabricante = fabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    // Método para verificar se o equipamento está na validade
    public boolean inValidade() {
        return LocalDate.now().isBefore(dataValidade);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    
    
    public String relatorio() {
        return "Medicamento [Nome: " + nome + ", Código: " + codigo +
               ", Data de Validade: " + dataValidade + ", Quantidade: " + quantidade +
               ", Fabricante: " + fabricante + "]";
    }
}
