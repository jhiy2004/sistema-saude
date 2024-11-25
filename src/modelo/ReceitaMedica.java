package modelo;

import java.util.ArrayList;
import java.util.List;
import Persistencia.*;

/**
 * Classe que representa uma receita médica.
 * A receita contém prescrições de medicamentos, observações do médico e as informações do paciente e médico responsáveis.
 * Ela estende a classe {@link DocumentoMedico} e adiciona funcionalidades específicas para manipular as prescrições.
 * 
 * @author renna
 */
public class ReceitaMedica extends DocumentoMedico {    
    private List<Prescricao> prescricoes;    // Lista de prescrições
    private String observacoes;
    
    /**
     * Construtor da ReceitaMedica.
     * Inicializa a lista de prescrições e define as observações.
     * 
     * @param paciente O paciente ao qual a receita é destinada.
     * @param medicoResponsavel O médico responsável pela receita.
     * @param observacoes Observações adicionais do médico.
     */
    public ReceitaMedica(Paciente paciente, Medico medicoResponsavel, String observacoes, ArrayList<Prescricao> prescricoes) {
        super(paciente, medicoResponsavel);        
        this.prescricoes = prescricoes;
        this.observacoes = observacoes;
    }    
        
    /**
     * Método para emitir a receita médica.
     * Emula a impressão de uma receita médica com todas as informações relevantes,
     * como dados do médico, paciente, observações e prescrições.
     * 
     * @return Uma string formatada representando a receita médica.
     */
    @Override
    public String emitir(){      // Função que emula a impressão da receita
        StringBuilder sb = new StringBuilder();
        
        sb.append("Receita Médica (ID): ").append(super.getDocumentoId()).append("\nInformações do Emitente:")
        .append("\nNome: ").append(super.getNomeMedicoResponsavel())
        .append("\nCRM: ").append(super.getCrmMedicoResponsavel())
        .append("\nIdentificação do Paciente:")
        .append("\nNome: ").append(super.getNomePaciente())
        .append("\nCPF: ").append(super.getCPFPaciente())
        .append("\nObservações: ").append(this.observacoes)
        .append("\nPrescrições: \n");

        // Exibe todas as prescrições
        for (Prescricao prescricao : prescricoes) {
            sb.append(prescricao.toString()).append("\n");
        }

        return sb.toString();
    }
    
    /**
     * Adiciona uma prescrição à receita médica.
     * 
     * @param medicamento O medicamento prescrito.
     * @param dosagem A dosagem do medicamento.
     * @param instrucoes Instruções adicionais para o uso do medicamento.
     */
    public void adicionarPrescricao(Medicamento medicamento, String dosagem, String instrucoes) {
        Prescricao prescricao = new Prescricao(medicamento, dosagem, instrucoes);
        prescricoes.add(prescricao);
    }   
    
    /**
     * Remove uma prescrição da receita médica.
     * A remoção pode ser feita pelo nome ou código do medicamento.
     * 
     * @param medicamentoNomeOuCodigo Nome ou código do medicamento a ser removido.
     * @return True se a prescrição foi removida com sucesso, caso contrário, false.
     */
    public boolean removerPrescricao(String medicamentoNomeOuCodigo) {
        for (int i = 0; i < prescricoes.size(); i++) {
            Prescricao prescricao = prescricoes.get(i);
            Medicamento medicamento = prescricao.getMedicamento();
            
            if (medicamento.getNome().equalsIgnoreCase(medicamentoNomeOuCodigo) || 
                medicamento.getCodigo().equalsIgnoreCase(medicamentoNomeOuCodigo)) {
                prescricoes.remove(i);
                return true; // Retorna true se a prescrição foi encontrada e removida
            }
        }
        return false; // Retorna false se nenhuma prescrição foi encontrada
    }

    /**
     * Obtém a lista de prescrições da receita médica.
     * 
     * @return A lista de prescrições.
     */
    public List<Prescricao> getPrescricoes() {
        return prescricoes;
    }

    /**
     * Define a lista de prescrições da receita médica.
     * 
     * @param prescricoes A lista de prescrições.
     */
    public void setPrescricoes(List<Prescricao> prescricoes) {
        this.prescricoes = prescricoes;
    }
    
    /**
     * Método para salvar a receita médica utilizando a estratégia de persistência fornecida.
     * 
     * @param strategy A estratégia de persistência para salvar o objeto.
     */
    public void salvar(PersistenciaStrategy strategy){
        strategy.salvar(this);
    }

    /**
     * Obtém as observações da receita médica.
     * 
     * @return As observações da receita médica.
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * Define as observações da receita médica.
     * 
     * @param observacoes As observações da receita médica.
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}
