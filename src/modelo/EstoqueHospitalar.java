package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o estoque hospitalar, contendo uma lista de itens que implementam
 * a interface ProdutoHospitalar. Permite adicionar, remover, buscar e listar itens no estoque.
 * 
 * @author renna
 */
public class EstoqueHospitalar {
    private List<ProdutoHospitalar> itens;

    /**
     * Construtor da classe EstoqueHospitalar.
     * Inicializa a lista de itens do estoque.
     */
    public EstoqueHospitalar() {
        this.itens = new ArrayList<>();
    }

    /**
     * Adiciona um item ao estoque.
     * 
     * @param item O objeto que implementa a interface ProdutoHospitalar a ser adicionado ao estoque.
     * @return String Mensagem confirmando a adição do item ao estoque.
     */
    public String adicionarItem(ProdutoHospitalar item) {
        itens.add(item);
        return item.getNome() + " foi adicionado ao estoque.";
    }

    /**
     * Remove um item do estoque com base no código do item.
     * 
     * @param codigo O código do item a ser removido do estoque.
     * @return String Mensagem confirmando a remoção do item ou informando que o item não foi encontrado.
     */
    public String removerItem(String codigo) {
        boolean removido = itens.removeIf(item -> item.getCodigo().equals(codigo));
        return removido ? "Item com código " + codigo + " foi removido do estoque."
                        : "Item com código " + codigo + " não encontrado no estoque.";
    }

    /**
     * Busca um item no estoque pelo seu código.
     * 
     * @param codigo O código do item a ser buscado.
     * @return ProdutoHospitalar O item encontrado, ou null caso o item não seja encontrado.
     */
    public ProdutoHospitalar buscarItemCodigo(String codigo) {
        for (ProdutoHospitalar item : itens) {
            if (item.getCodigo().equals(codigo)) {
                return item;
            }
        }
        return null; // Retorna null caso o item não seja encontrado
    }

    /**
     * Busca um item no estoque pelo seu nome.
     * 
     * @param nome O nome do item a ser buscado.
     * @return ProdutoHospitalar O item encontrado, ou null caso o item não seja encontrado.
     */
    public ProdutoHospitalar buscarItemNome(String nome) {
        for (ProdutoHospitalar item : itens) {
            if (item.getNome().equals(nome)) {
                return item;
            }
        }
        return null; // Retorna null caso o item não seja encontrado
    }

    /**
     * Lista todos os itens disponíveis no estoque.
     * 
     * @return String A lista de itens no estoque, ou uma mensagem informando que o estoque está vazio.
     */
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

    /**
     * Verifica a quantidade de um item específico no estoque, baseado no código do item.
     * 
     * @param codigo O código do item a ser verificado.
     * @return String A quantidade do item ou uma mensagem informando que o item não foi encontrado.
     */
    public String verificarQuantidade(String codigo) {
        ProdutoHospitalar item = buscarItemCodigo(codigo);
        return item != null ? "Quantidade de " + item.getNome() + ": " + item.getQuantidade()
                            : "Item com código " + codigo + " não encontrado no estoque.";
    }
}
