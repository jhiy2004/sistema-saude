package modelo;

import constantes.Constantes.Status;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private String especialidade;
    private Medico medico;
    private LocalDate data;
    private ReceitaMedica receitaMedica;
    private LocalTime horario;
    private Paciente paciente;
    private ReceitaMedica receita;
    private Status status;
    
    public Consulta(String especialidade, Medico medico, LocalDate data, LocalTime horario, Paciente paciente, ReceitaMedica receita){
	this.especialidade = especialidade;
	this.medico = medico;
	this.data = data;
	this.horario = horario;
	this.paciente = paciente;
        this.receita = receita;
    }
    
    public String criarReceitaMedica(String medicamento, String observacoes, ArrayList<Prescricao> prescricoes) {
        this.receitaMedica = new ReceitaMedica(paciente, medico, observacoes, prescricoes);
        return receitaMedica.toString();
    }

    // Método para obter a receita médica associada
    public ReceitaMedica getReceitaMedica() {
        return receitaMedica;
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
        return status;
    }
    
    public void setReceita(ReceitaMedica receita){
        this.receita = receita;
    }
    
    public ReceitaMedica getReceita(){
        return receita;
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
