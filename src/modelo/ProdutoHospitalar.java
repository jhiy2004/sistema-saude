package modelo;

/**
 * Interface que define os métodos para os produtos hospitalares.
 * Um produto hospitalar pode ser qualquer item utilizado em um ambiente hospitalar, como medicamentos, equipamentos ou materiais.
 * 
 * @author renna
 */
public interface ProdutoHospitalar {

    /**
     * Retorna o código único do produto hospitalar.
     * O código pode ser utilizado para identificar o produto de forma única.
     * 
     * @return O código do produto.
     */
    String getCodigo();

    /**
     * Retorna o nome do produto hospitalar.
     * O nome é utilizado para descrever o produto de forma compreensível.
     * 
     * @return O nome do produto.
     */
    String getNome();

    /**
     * Retorna a quantidade disponível do produto hospitalar.
     * Esse valor é útil para gerenciar o estoque do produto.
     * 
     * @return A quantidade disponível do produto.
     */
    int getQuantidade();

    /**
     * Gera um relatório sobre o produto hospitalar.
     * O relatório pode conter informações como descrição, validade e quantidade em estoque.
     * 
     * @return Um relatório com informações sobre o produto.
     */
    String relatorio();

    /**
     * Verifica se o produto hospitalar está dentro do prazo de validade.
     * Produtos fora da validade podem não ser adequados para o uso em tratamentos.
     * 
     * @return True se o produto está dentro do prazo de validade, false caso contrário.
     */
    boolean inValidade();
}
