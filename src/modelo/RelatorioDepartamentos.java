package modelo;

import interfaces.Relatorio;

public class RelatorioDepartamentos implements Relatorio {

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

    @Override
    public void exibirRelatorio(Hospital h) {
        String relatorio = gerarRelatorio(h);
        System.out.println(relatorio);
    }
}
