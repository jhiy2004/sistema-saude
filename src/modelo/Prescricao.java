package modelo;

/**
 * Classe que representa uma prescrição médica para um medicamento.
 * Ela contém informações sobre o medicamento, a dosagem prescrita e as instruções de uso.
 * 
 * @author renna
 */
public class Prescricao {
    private Medicamento medicamento;
    private String dosagem;
    private String instrucoes;  // Opcional: para adicionar instruções de uso

    /**
     * Construtor da classe Prescricao.
     * 
     * @param medicamento O medicamento prescrito.
     * @param dosagem A dosagem do medicamento prescrita.
     * @param instrucoes Instruções adicionais sobre como usar o medicamento (opcional).
     */
    public Prescricao(Medicamento medicamento, String dosagem, String instrucoes) {
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.instrucoes = instrucoes;
    }

    /**
     * Obtém o medicamento prescrito.
     * 
     * @return O medicamento prescrito.
     */
    public Medicamento getMedicamento() {
        return medicamento;
    }

    /**
     * Define o medicamento prescrito.
     * 
     * @param medicamento O medicamento a ser prescrito.
     */
    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    /**
     * Obtém a dosagem prescrita para o medicamento.
     * 
     * @return A dosagem prescrita.
     */
    public String getDosagem() {
        return dosagem;
    }

    /**
     * Define a dosagem prescrita para o medicamento.
     * 
     * @param dosagem A dosagem prescrita.
     */
    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    /**
     * Obtém as instruções adicionais sobre como usar o medicamento.
     * 
     * @return As instruções sobre o uso do medicamento.
     */
    public String getInstrucoes() {
        return instrucoes;
    }

    /**
     * Define as instruções adicionais sobre como usar o medicamento.
     * 
     * @param instrucoes As instruções sobre o uso do medicamento.
     */
    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }

    /**
     * Retorna uma representação em forma de string da prescrição médica, 
     * incluindo o nome do medicamento, a dosagem prescrita e as instruções, se disponíveis.
     * 
     * @return Uma string com as informações completas da prescrição.
     */
    @Override
    public String toString() {
        return "Medicamento: " + medicamento.getNome() +                
               " | Dosagem: " + dosagem + 
               (instrucoes != null ? " | Instruções: " + instrucoes : "");
    }
}
