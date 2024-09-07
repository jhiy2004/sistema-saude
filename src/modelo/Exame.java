package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Exame {
    private Hospital hospital;
    private String tipoExame;   
    private Medico medico;      
    private LocalDate data;    
    private LocalTime horario; 
    private Paciente paciente;  
    private String resultado;   
    private StatusExame status; 


    public enum StatusExame {
        AGENDADO, REALIZADO, PENDENTE, CANCELADO
    }

    // ========== Construtor ==========
    public Exame(Hospital hospital, String tipoExame, Medico medico, LocalDate data, LocalTime horario, Paciente paciente) {
        this.hospital = hospital;
        this.tipoExame = tipoExame;
        this.medico = medico;
        this.data = data;
        this.horario = horario;
        this.paciente = paciente;
        this.status = StatusExame.AGENDADO;
        this.resultado = null; 
    }

    // =========== Getters e Setters ===========
    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public StatusExame getStatus() {
        return status;
    }

    public void setStatus(StatusExame status) {
        this.status = status;
    }

    // equals() e hashCode() para garantir que dois exames são iguais se forem para o mesmo paciente, médico, data e horário
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

    @Override
    public int hashCode() {
        int result = paciente.hashCode();
        result = 31 * result + medico.hashCode();
        result = 31 * result + data.hashCode();
        result = 31 * result + horario.hashCode();
        return result;
    }
}