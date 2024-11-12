package modelo;

import interfaces.DocumentoEmitivel;
import java.time.LocalDate;
import java.util.UUID;
import Persistencia.PersistenciaStrategy;

/**
 * Classe abstrata que representa um documento médico. 
 * Todos os documentos médicos devem possuir os seguintes atributos:
 * data de emissão, paciente, médico responsável e um identificador de documento único.
 * 
 * @author renna
 */
public abstract class DocumentoMedico implements DocumentoEmitivel {        
    private LocalDate dataDeEmissao;
    private Paciente paciente;
    private Medico medicoResponsavel;
    private String documentoId;
    
    /**
     * Construtor da classe DocumentoMedico.
     * A data de emissão é definida como a data atual no momento da criação do objeto.
     * O código do documento (documentoId) é gerado automaticamente.
     * 
     * @param paciente O paciente ao qual o documento está associado.
     * @param medicoResponsavel O médico responsável pelo documento.
     */
    public DocumentoMedico(Paciente paciente, Medico medicoResponsavel) {        
        this.dataDeEmissao = LocalDate.now();
        this.paciente = paciente;
        this.medicoResponsavel = medicoResponsavel;
        this.documentoId = gerarDocumentoId();
    }
    
    /**
     * Método abstrato que deve ser implementado por classes concretas.
     * Este método deve emitir o conteúdo do documento.
     * 
     * @return String O conteúdo do documento.
     */
    @Override
    public abstract String emitir();
    
    /**
     * Método abstrato que deve ser implementado por classes concretas.
     * Este método permite salvar o documento de acordo com a estratégia de persistência fornecida.
     * 
     * @param strategy A estratégia de persistência utilizada para salvar o documento.
     */
    @Override
    public abstract void salvar(PersistenciaStrategy strategy);
    
    /**
     * Gera um identificador único para o documento. O ID é baseado em um UUID,
     * sem hífens, e limitado a 10 caracteres.
     * 
     * @return String O identificador gerado para o documento.
     */
    private String gerarDocumentoId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }

    /**
     * Obtém o identificador do documento.
     * 
     * @return String O ID do documento.
     */
    public String getDocumentoId() {
        return documentoId;
    }

    /**
     * Obtém a data de emissão do documento.
     * 
     * @return LocalDate A data de emissão do documento.
     */
    public LocalDate getDataDeEmissao() {
        return dataDeEmissao;
    }

    /**
     * Define a data de emissão do documento.
     * 
     * @param dataDeEmissao A nova data de emissão para o documento.
     */
    public void setDataDeEmissao(LocalDate dataDeEmissao) {
        this.dataDeEmissao = dataDeEmissao;
    }

    /**
     * Obtém o paciente associado ao documento.
     * 
     * @return Paciente O paciente associado ao documento.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Define o paciente associado ao documento.
     * 
     * @param paciente O paciente a ser associado ao documento.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Obtém o médico responsável pelo documento.
     * 
     * @return Medico O médico responsável pelo documento.
     */
    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    /**
     * Define o médico responsável pelo documento.
     * 
     * @param medicoResponsavel O médico a ser associado ao documento.
     */
    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }   
    
    /**
     * Obtém o nome do médico responsável pelo documento.
     * 
     * @return String O nome do médico responsável.
     */
    public String getNomeMedicoResponsavel() {
        return medicoResponsavel.getNome();
    }

    /**
     * Obtém o CRM do médico responsável pelo documento.
     * 
     * @return String O CRM do médico responsável.
     */
    public String getCrmMedicoResponsavel() {
        return medicoResponsavel.getCrm();
    }
    
    /**
     * Obtém o nome do paciente associado ao documento.
     * 
     * @return String O nome do paciente.
     */
    public String getNomePaciente() {
        return paciente.getNome();
    }
    
    /**
     * Obtém o CPF do paciente associado ao documento.
     * 
     * @return String O CPF do paciente.
     */
    public String getCPFPaciente() {
        return paciente.getCPF();
    }
}
