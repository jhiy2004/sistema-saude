package interfaces;

import Persistencia.PersistenciaStrategy;

/**
 * Interface que define o comportamento de qualquer documento emitível.
 * Toda classe que implementar esta interface deve fornecer a capacidade de emitir
 * o conteúdo do documento, salvar o documento em um sistema de persistência utilizando
 * uma estratégia específica e fornecer o ID do documento para permitir a recuperação.
 * 
 * As classes que implementam esta interface precisam fornecer implementação para os
 * métodos de emissão, salvamento e identificação do documento.
 * 
 * @author renna
 */
public interface DocumentoEmitivel {
    
    /**
     * Método responsável por emitir o conteúdo do documento em formato de string.
     * 
     * @return Uma string representando o conteúdo do documento.
     */
    String emitir();
    
    /**
     * Método responsável por salvar o documento utilizando uma estratégia de persistência.
     * A implementação concreta do método de salvamento depende da estratégia fornecida,
     * que pode ser, por exemplo, salvar em banco de dados, arquivo ou memória.
     * 
     * @param strategy A estratégia de persistência a ser utilizada para salvar o documento.
     */
    void salvar(PersistenciaStrategy strategy);
    
    /**
     * Método responsável por retornar o ID único do documento, que será utilizado para
     * identificar o documento de forma exclusiva no sistema.
     * 
     * @return O ID do documento.
     */
    String getDocumentoId();
}
