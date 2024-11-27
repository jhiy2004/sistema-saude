package modelo;

import constantes.Constantes.Status;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 * Representa um exame médico que será realizado por um paciente.
 */
public class Exame {
    private String tipoExame;   
    private String crm;      
    private LocalDate data;    
    private LocalTime horario; 
    private String cpf;  
    private String resultado;   
    private Status status; 
/**
     * Construtor para inicializar um exame.
     *
     * @param tipoExame O tipo do exame.
     * @param crm O crm do médico responsável.
     * @param data A data do exame.
     * @param horario O horário do exame.
     * @param cpf O cpf do paciente que realizará o exame.
     */
    // ========== Construtor ==========
    public Exame(String tipoExame, String crm, LocalDate data, LocalTime horario, String cpf) {
        this.tipoExame = tipoExame;
        this.crm = crm;
        this.data = data;
        this.horario = horario;
        this.cpf = cpf;
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
     * @return O crm do médico responsável.
     */
    public String getCrmMedico() {
        return crm;
    }

    /**
     * Define o médico responsável pelo exame.
     *
     * @param crm O crm do médico responsável.
     */
    public void setCrmMedico(String crm) {
        this.crm = crm;
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
     * Retorna o cpf do paciente que realizará o exame.
     *
     * @return O cpf do paciente do exame.
     */
    public String getCpfPaciente() {
        return cpf;
    }

    /**
     * Define o cpf do paciente que realizará o exame.
     *
     * @param cpf O cpf do paciente do exame.
     */
    public void setCpfPaciente(String cpf) {
        this.cpf = cpf;
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
}