package interfaces;

import modelo.Hospital;

public interface Relatorio {
    String gerarRelatorio(Hospital h);
    void exibirRelatorio(Hospital h);
}
