package modelo;

import constantes.Constantes.Status;
import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private Hospital hospital;
    private String especialidade;
    private Medico medico;
    private LocalDate data;
    private ReceitaMedica receitaMedica;
    private LocalTime horario;
    private Paciente paciente;
    private Status status;
    
    public Consulta(Hospital hospital, String especialidade, Medico medico, LocalDate data, LocalTime horario, Paciente paciente){
	this.hospital = hospital;
	this.especialidade = especialidade;
	this.medico = medico;
	this.data = data;
	this.horario = horario;
	this.paciente = paciente;
    }
    
    public String criarReceitaMedica(String receitaId, String medicamento, String observacoes) {
        this.receitaMedica = new ReceitaMedica(receitaId, this, medicamento, observacoes);
        return receitaMedica.toStringReceitaMedica();
    }

    // Método para obter a receita médica associada
    public ReceitaMedica getReceitaMedica() {
        return receitaMedica;
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
    
    public Status getStatus() {
        return this.status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
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
