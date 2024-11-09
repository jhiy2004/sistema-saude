/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author renna
 */
public interface ProdutoHospitalar {
    String getCodigo();
    String getNome();
    int getQuantidade();
    String relatorio();
    boolean inValidade();
}
