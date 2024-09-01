package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private Hospital hospital;
    private String especialidade;
    private Medico medico;
    private LocalDate data;
    private LocalTime horario;
    private Paciente paciente;
    
    public Consulta(Hospital hospital, String especialidade, Medico medico, LocalDate data, LocalTime horario, Paciente paciente){
	this.hospital = hospital;
	this.especialidade = especialidade;
	this.medico = medico;
	this.data = data;
	this.horario = horario;
	this.paciente = paciente;
    }

    public Hospital getHospital() {
	return hospital;
    }

    public void setHospital(Hospital hospital) {
	this.hospital = hospital;
    }

    public String getEspecialidade() {
	return especialidade;
    }

    public void setEspecialidade(String especialidade) {
	this.especialidade = especialidade;
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consulta consulta = (Consulta) o;

        if (!paciente.equals(consulta.paciente)) return false;
        if (!medico.equals(consulta.medico)) return false;
        if (!data.equals(consulta.data)) return false;
        return horario.equals(consulta.horario);
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
