package modelo;

import interfaces.Relatorio;
/**
 * Classe que implementa o contrato da interface {@link Relatorio} para gerar e exibir relatórios sobre os departamentos de um hospital.
 */
public class RelatorioDepartamentos implements Relatorio {

/**
     * Gera um relatório com informações sobre os departamentos de um hospital.
     * O relatório inclui o nome do departamento, código, quantidade de médicos e os gastos totais com salários.
     *
     * @param h O hospital cujos departamentos serão incluídos no relatório.
     * @return Uma string contendo o relatório formatado.
     */
    @Override
    public String gerarRelatorio(Hospital h) {
        StringBuilder saida = new StringBuilder();
        
        for (Departamento d : h.getDepartamentos()) {
            saida.append("DEPARTAMENTO: ").append(d.getNome()).append("\n");
            saida.append("CODIGO DEPTO: ").append(d.getCod()).append("\n");
            saida.append("QTD MÉDICOS: ").append(d.getMedicos().size()).append("\n");
            saida.append("GASTOS TOTAIS: ").append(d.totalSalariosM()).append("\n");
            saida.append("\n");
        }
        
        return saida.toString();
    }
     /**
     * Exibe o relatório dos departamentos no console.
     * Este método chama o método {@link #gerarRelatorio(Hospital)} para gerar o relatório 
     * e então imprime a saída gerada no console.
     *
     * @param h O hospital cujos departamentos serão incluídos no relatório.
     */
    @Override
    public void exibirRelatorio(Hospital h) {
        String relatorio = gerarRelatorio(h);
        System.out.println(relatorio);
    }
}
