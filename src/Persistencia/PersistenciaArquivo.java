package Persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import modelo.DocumentoEmitivel;

/**
 * Classe que implementa a interface PersistenciaStrategy para armazenar e recuperar documentos médicos
 * utilizando arquivos binários para persistência.
 * Cada documento é salvo em um arquivo separado com o nome baseado no documentoId.
 * 
 * @author renna
 */
public class PersistenciaArquivo implements PersistenciaStrategy {

    private List<DocumentoEmitivel> vetor;

    public PersistenciaArquivo() {
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
        for (int i = 0; i < documentoId.length(); i++) {
            char c = documentoId.charAt(i);
            hash += (int) c * (i + 1) * (i + 1);
        }
        return Math.abs(hash % 100);
    }

    /**
     * Salva um documento em um arquivo binário. Cada documento é salvo em um arquivo com o nome
     * baseado no documentoId. Se o arquivo já existir, ele não é sobrescrito.
     * 
     * @param documento O documento a ser salvo.
     */
    @Override
    public void salvar(DocumentoEmitivel documento) {
        int indice = hash(documento.getDocumentoId());
        
        // Nome do arquivo baseado no documentoId
        String fileName = "documento_" + documento.getDocumentoId() + ".bin";
        File file = new File(fileName);

        // Verifica se o arquivo já existe
        if (!file.exists()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(documento); // Salva o documento no arquivo binário
                vetor.add(indice, documento); // Adiciona o documento ao vetor na posição calculada
                System.out.println("Documento salvo no arquivo: " + fileName);
            } catch (IOException e) {
                System.out.println("Erro ao salvar o documento: " + e.getMessage());
            }
        } else {
            System.out.println("O documento já existe no arquivo: " + fileName);
        }
    }

    /**
     * Recupera um documento armazenado em um arquivo binário com base no seu documentoId.
     * 
     * @param documentoId O ID do documento a ser recuperado.
     * @return O documento correspondente ao documentoId, ou null se não encontrado.
     */
    @Override
    public DocumentoEmitivel recuperar(String documentoId) {
        String fileName = "documento_" + documentoId + ".bin";
        File file = new File(fileName);

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (DocumentoEmitivel) ois.readObject(); // Recupera o documento do arquivo
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao recuperar o documento: " + e.getMessage());
            }
        }
        return null;
    }

    /**
     * Verifica se um documento com o documentoId fornecido existe no vetor.
     * 
     * @param documentoId O ID do documento a ser verificado.
     * @return true se o documento existe no vetor, false caso contrário.
     */
    @Override
    public boolean existe(String documentoId) {
        String fileName = "documento_" + documentoId + ".bin";
        File file = new File(fileName);
        return file.exists();
    }
}
