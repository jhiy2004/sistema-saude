package modelo;

import interfaces.Relatorio;
/**
 * Classe que implementa o contrato da interface {@link Relatorio} para gerar e exibir relatórios sobre os medicamentos de um hospital.
 */
public class RelatorioMedicamentos implements Relatorio {
    /**
     * Gera um relatório com informações sobre os medicamentos presentes no estoque de um hospital.
     * O relatório inclui o nome, código, validade, quantidade e fabricante de cada medicamento.
     *
     * @param h O hospital cujos medicamentos serão incluídos no relatório.
     * @return Uma string contendo o relatório formatado.
     */
    @Override
    public String gerarRelatorio(Hospital h) {
        StringBuilder saida = new StringBuilder();
        
        for (Medicamento m : h.getEstoque()) {
            saida.append("MEDICAMENTO: ").append(m.getNome()).append("\n");
            saida.append("CODIGO: ").append(m.getCodigo()).append("\n");
            saida.append("VALIDADE: ").append(m.getDataValidade()).append("\n");
            saida.append("QUANTIDADE: ").append(m.getQuantidade()).append("\n");
            saida.append("FABRICANTE: ").append(m.getFabricante()).append("\n");
            saida.append("\n");
        }
        
        return saida.toString();
    }
    /**
     * Exibe o relatório dos medicamentos no console.
     * Este método chama o método {@link #gerarRelatorio(Hospital)} para gerar o relatório 
     * e então imprime a saída gerada no console.
     *
     * @param h O hospital cujos medicamentos serão incluídos no relatório.
     */
    @Override
    public void exibirRelatorio(Hospital h) {
        String relatorio = gerarRelatorio(h);
        System.out.println(relatorio);
    }
}
