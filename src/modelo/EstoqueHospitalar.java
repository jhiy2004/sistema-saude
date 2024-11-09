/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renna
 */
public class EstoqueHospitalar {
    private List<ProdutoHospitalar> itens;

    public EstoqueHospitalar() {
        this.itens = new ArrayList<>();
    }
    
    /**
    * Método para adicionar um item ao estoque
    * @param item objeto que implementa a interface ProdutoHospitalar
    * @return String confirmando a adição
    */
    public String adicionarItem(ProdutoHospitalar item) {
        itens.add(item);
        return item.getNome() + " foi adicionado ao estoque.";
    }

    /**
    * Método para remover um item do estoque pelo código
    * @param item objeto que implementa a interface ProdutoHospitalar
    * @return String confirmando a adição
    */
    public String removerItem(String codigo) {
        boolean removido = itens.removeIf(item -> item.getCodigo().equals(codigo));
        return removido ? "Item com código " + codigo + " foi removido do estoque."
                        : "Item com código " + codigo + " não encontrado no estoque.";
    }

    // Método para buscar um item pelo código
    public ProdutoHospitalar buscarItemCodigo(String codigo) {
        for (ProdutoHospitalar item : itens) {
            if (item.getCodigo().equals(codigo)) {
                return item;
            }
        }
        return null; // Retorna null caso o item não seja encontrado
    }
    
    public ProdutoHospitalar buscarItemNome(String nome) {
        for (ProdutoHospitalar item : itens) {
            if (item.getNome().equals(nome)) {
                return item;
            }
        }
        return null; // Retorna null caso o item não seja encontrado
    }

    // Método para listar todos os itens no estoque
    public String listarItens() {
        if (itens.isEmpty()) {
            return "O estoque está vazio.";
        } else {
            StringBuilder sb = new StringBuilder("Itens no estoque:\n");
            for (ProdutoHospitalar item : itens) {
                sb.append(item.relatorio()).append("\n");
            }
            return sb.toString();
        }
    }

    // Método para verificar a quantidade de um item específico
    public String verificarQuantidade(String codigo) {
        ProdutoHospitalar item = buscarItemCodigo(codigo);
        return item != null ? "Quantidade de " + item.getNome() + ": " + item.getQuantidade()
                            : "Item com código " + codigo + " não encontrado no estoque.";
    }
}
