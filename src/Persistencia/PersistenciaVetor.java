package Persistencia;

import java.util.ArrayList;
import java.util.List;
import interfaces.DocumentoEmitivel;

/**
 * Classe que implementa a interface PersistenciaStrategy para armazenar e recuperar documentos médicos
 * utilizando uma estrutura de dados de vetor e uma tabela de hashing simples.
 * A tabela de hashing é calculada com base no documentoId de qualquer documentoEmitível.
 * O tamanho máximo do vetor é limitado por um valor fixo, especificado no código.
 * 
 * @author renna
 */
public class PersistenciaVetor implements PersistenciaStrategy {
    
    private List<DocumentoEmitivel> vetor;

    /**
     * Construtor da classe, inicializa o vetor que armazenará os documentos.
     */
    public PersistenciaVetor() {
        vetor = new ArrayList<>();
    }

    /**
     * Função hash simples que calcula um índice com base no documentoId.
     * A função percorre cada caractere do documentoId, multiplica o valor ASCII do caractere
     * por sua posição elevada ao quadrado e aplica o módulo para restringir o valor ao tamanho do vetor.
     * 
     * @param documentoId O ID do documento utilizado para calcular o índice.
     * @return O índice calculado que será utilizado para armazenar ou recuperar o documento no vetor.
     */
    private int hash(String documentoId) {
        int hash = 0;

        // Multiplica o valor ASCII de cada caractere por sua posição elevada ao quadrado
        for (int i = 0; i < documentoId.length(); i++) {
            char c = documentoId.charAt(i);
            hash += (int) c * (i + 1) * (i + 1);
        }

        // Usamos o valor absoluto e aplicamos o módulo para restringir o resultado ao tamanho desejado
        return Math.abs(hash % 100);  // ou outro tamanho de vetor desejado
    }

    /**
     * Salva um documento no vetor utilizando a tabela de hashing para calcular sua posição.
     * Caso a posição calculada ainda não esteja no vetor, ela é expandida até o tamanho necessário.
     * 
     * @param documento O documento a ser salvo.
     */
    @Override
    public void salvar(DocumentoEmitivel documento) {
        int indice = hash(documento.getDocumentoId());
        
        // Expande o vetor para garantir que o índice esteja dentro dos limites
        if (indice >= vetor.size()) {
            for (int i = vetor.size(); i <= indice; i++) {
                vetor.add(null);
            }
        }

        // Armazena o documento no vetor na posição calculada
        vetor.set(indice, documento);
    }

    /**
     * Recupera um documento armazenado no vetor com base no seu documentoId.
     * 
     * @param documentoId O ID do documento a ser recuperado.
     * @return O documento correspondente ao documentoId, ou null se não encontrado.
     */
    @Override
    public DocumentoEmitivel recuperar(String documentoId) {
        int indice = hash(documentoId);
        return vetor.get(indice);
    }

    /**
     * Verifica se um documento com o documentoId fornecido existe no vetor.
     * 
     * @param documentoId O ID do documento a ser verificado.
     * @return true se o documento existe no vetor, false caso contrário.
     */
    @Override
    public boolean existe(String documentoId) {
        int indice = hash(documentoId);
        return vetor.get(indice) != null;
    }
}
