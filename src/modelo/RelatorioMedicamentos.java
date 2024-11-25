package modelo;

import interfaces.Relatorio;

public class RelatorioMedicamentos implements Relatorio {
    
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

    @Override
    public void exibirRelatorio(Hospital h) {
        String relatorio = gerarRelatorio(h);
        System.out.println(relatorio);
    }
}
