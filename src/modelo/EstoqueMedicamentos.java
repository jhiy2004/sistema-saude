package modelo;

import java.util.ArrayList;

/**
 * Representa o estoque de medicamentos de uma farmácia ou instituição de saúde.
 */
public class EstoqueMedicamentos {
    private ArrayList<Medicamento> medicamentos;
    
     /**
     * Construtor que inicializa o estoque de medicamentos como uma lista vazia.
     */
    public EstoqueMedicamentos(){
        medicamentos = new ArrayList<>();
    }
    /**
     * Adiciona um medicamento ao estoque se ele ainda não estiver presente.
     *
     * @param m O medicamento a ser adicionado.
     */
    public void adicionarMedicamento(Medicamento m){
        if(buscarMedicamentoNome(m.getCodigo()) == null){
            medicamentos.add(m);
        }
    }
    
     /**
     * Remove um medicamento do estoque com base no código do medicamento.
     *
     * @param codigo O código do medicamento a ser removido.
     */
    public void removerMedicamento(String codigo){
        medicamentos.removeIf(medicamento -> medicamento.getCodigo().equals(codigo));
    }
    /**
     * Retorna a quantidade total de medicamentos no estoque.
     *
     * @return A quantidade de medicamentos.
     */
    public int quantidadeMedicamentos(){
        return medicamentos.size();
    }
    
     /**
     * Busca um medicamento no estoque pelo nome.
     *
     * @param nome O nome do medicamento a ser buscado.
     * @return O medicamento correspondente ou {@code null} se não encontrado.
     */
    public Medicamento buscarMedicamentoNome(String nome) {
        for (Medicamento m : medicamentos) {
            if (m.getNome().equals(nome)) {
                return m;
            }
        }
        return null;
    }
     /**
     * Retorna a lista de todos os medicamentos no estoque.
     *
     * @return A lista de medicamentos.
     */
    public ArrayList<Medicamento> getMedicamentos(){
        return medicamentos;
    }
}