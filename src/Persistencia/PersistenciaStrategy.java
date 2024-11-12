package Persistencia;

import interfaces.DocumentoEmitivel;

/**
 * Interface que define a estratégia de persistência para documentos médicos.
 * A persistência pode envolver o armazenamento, recuperação e verificação da existência de documentos.
 * Essa interface pode ser implementada de diferentes maneiras, como em um banco de dados, arquivos locais ou outros mecanismos de persistência.
 * 
 * @author renna
 */
public interface PersistenciaStrategy {

    /**
     * Salva um documento emitido de acordo com a estratégia de persistência implementada.
     * O método pode ser utilizado para armazenar o documento em um banco de dados, arquivo, etc.
     * 
     * @param documento O documento a ser salvo.
     */
    void salvar(DocumentoEmitivel documento);

    /**
     * Recupera um documento emitido com base no seu ID.
     * O método retorna o documento correspondente ou null caso não seja encontrado.
     * 
     * @param documentoId O ID do documento a ser recuperado.
     * @return O documento correspondente ao ID, ou null caso não seja encontrado.
     */
    DocumentoEmitivel recuperar(String documentoId);

    /**
     * Verifica se um documento com o ID especificado existe.
     * O método pode ser utilizado para verificar a existência de um documento antes de tentar recuperá-lo ou atualizá-lo.
     * 
     * @param documentoId O ID do documento a ser verificado.
     * @return true se o documento existe, false caso contrário.
     */
    boolean existe(String documentoId);
}
