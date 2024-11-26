package modelo;

import constantes.Constantes.Status;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 * Representa um exame médico que será realizado por um paciente.
 */
public class Exame {
    private String tipoExame;   
    private Medico medico;      
    private LocalDate data;    
    private LocalTime horario; 
    private Paciente paciente;  
    private String resultado;   
    private Status status; 
/**
     * Construtor para inicializar um exame.
     *
     * @param tipoExame O tipo do exame.
     * @param medico O médico responsável.
     * @param data A data do exame.
     * @param horario O horário do exame.
     * @param paciente O paciente que realizará o exame.
     */
    // ========== Construtor ==========
    public Exame(String tipoExame, Medico medico, LocalDate data, LocalTime horario, Paciente paciente) {
        this.tipoExame = tipoExame;
        this.medico = medico;
        this.data = data;
        this.horario = horario;
        this.paciente = paciente;
        this.resultado = null; 
    }

    /**
     * Retorna o tipo do exame.
     *
     * @return O tipo do exame.
     */
    public String getTipoExame() {
        return tipoExame;
    }

    /**
     * Define o tipo do exame.
     *
     * @param tipoExame O tipo do exame.
     */
    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    /**
     * Retorna o médico responsável pelo exame.
     *
     * @return O médico responsável.
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Define o médico responsável pelo exame.
     *
     * @param medico O médico responsável.
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Retorna a data do exame.
     *
     * @return A data do exame.
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Define a data do exame.
     *
     * @param data A nova data do exame.
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Retorna o horário do exame.
     *
     * @return O horário do exame.
     */
    public LocalTime getHorario() {
        return horario;
    }

    /**
     * Define o horário do exame.
     *
     * @param horario O novo horário do exame.
     */
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    /**
     * Retorna o paciente que realizará o exame.
     *
     * @return O paciente do exame.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Define o paciente que realizará o exame.
     *
     * @param paciente O paciente do exame.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Retorna o resultado do exame.
     *
     * @return O resultado do exame.
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Define o resultado do exame.
     *
     * @param resultado O novo resultado do exame.
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Retorna o status atual do exame.
     *
     * @return O status do exame.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Define o status atual do exame.
     *
     * @param status O novo status do exame.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Verifica se dois exames são iguais com base no paciente, médico, data e horário.
     *
     * @param o O objeto a ser comparado.
     * @return {@code true} se os exames forem iguais, {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exame exame = (Exame) o;

        if (!paciente.equals(exame.paciente)) return false;
        if (!medico.equals(exame.medico)) return false;
        if (!data.equals(exame.data)) return false;
        return horario.equals(exame.horario);
    }
     /**
     * Gera um hash code para o exame com base no paciente, médico, data e horário.
     *
     * @return O hash code do exame.
     */
    @Override
    public int hashCode() {
        int result = paciente.hashCode();
        result = 31 * result + medico.hashCode();
        result = 31 * result + data.hashCode();
        result = 31 * result + horario.hashCode();
        return result;
    }
}