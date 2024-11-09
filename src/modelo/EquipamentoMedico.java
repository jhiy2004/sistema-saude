/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
/**
 *
 * @author renna
 */
public class EquipamentoMedico implements ProdutoHospitalar {
    private String nome;
    private String codigo;
    private LocalDate dataValidade;
    private int quantidade;
    private String fabricante;

    public EquipamentoMedico(String nome, LocalDate dataValidade, String codigo, int quantidade, String fabricante) {
        this.nome = nome;
        this.dataValidade = dataValidade;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.fabricante = fabricante;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    public String getFabricante() {
        return fabricante;
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
    
    @Override
    public String relatorio() {
        return "Equipamento Médico [Nome: " + nome + ", Código: " + codigo +
               ", Quantidade: " + quantidade + ", Fabricante: " + fabricante + 
               ", Data de Validade: " + dataValidade + "]";
    }
}
