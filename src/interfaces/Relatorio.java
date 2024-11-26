package interfaces;

import modelo.Hospital;
/**
 * Interface que define os métodos necessários para gerar e exibir relatórios relacionados ao hospital.
 * As classes que implementam essa interface são responsáveis por fornecer a lógica específica
 * para gerar relatórios diferentes(departamentos, medicamentos)
 */
public interface Relatorio {
     /**
     * Gera um relatório com base nas informações do hospital.
     *
     * @param h O hospital cujas informações serão incluídas no relatório.
     * @return Uma string contendo o relatório formatado.
     */
    String gerarRelatorio(Hospital h);
    /**
     * Exibe o relatório.
     *
     * @param h O hospital cujas informações serão incluídas no relatório.
     */
    void exibirRelatorio(Hospital h);
}
