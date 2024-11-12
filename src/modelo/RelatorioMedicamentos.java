package modelo;

import interfaces.Relatorio;

public class RelatorioMedicamentos implements Relatorio {
    
    @Override
    public String gerarRelatorio(Hospital h) {
        // Preciso da classe de estoque e equipamentos
        return "";
    }

    @Override
    public void exibirRelatorio(Hospital h) {
        String relatorio = gerarRelatorio(h);
        System.out.println(relatorio);
    }
}
