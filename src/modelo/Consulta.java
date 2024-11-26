package modelo;

import constantes.Constantes.Status;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Representa uma consulta médica agendada entre um paciente e um médico.
 * Contém informações sobre especialidade, médico, data, horário, paciente, 
 * receita médica associada e status da consulta.
 */
public class Consulta {
    private String especialidade;
    private Medico medico;
    private LocalDate data;
    private ReceitaMedica receitaMedica;
    private LocalTime horario;
    private Paciente paciente;
    private ReceitaMedica receita;
    private Status status;
    
     /**
     * Construtor para inicializar os atributos da consulta.
     *
     * @param especialidade A especialidade médica da consulta.
     * @param medico O médico responsável pela consulta.
     * @param data A data da consulta.
     * @param horario O horário da consulta.
     * @param paciente O paciente que será atendido na consulta.
     * @param receita A receita médica associada à consulta, se existir.
     */
    public Consulta(String especialidade, Medico medico, LocalDate data, LocalTime horario, Paciente paciente, ReceitaMedica receita){
	this.especialidade = especialidade;
	this.medico = medico;
	this.data = data;
	this.horario = horario;
	this.paciente = paciente;
        this.receita = receita;
    }
    
    /**
     * Cria uma receita médica.
     *
     * @param medicamento O medicamento prescrito na receita.
     * @param observacoes Observações adicionais para a receita.
     * @param prescricoes Lista de prescrições incluídas na receita.
     * @return A representação textual(String) da receita médica criada.
     */
    public String criarReceitaMedica(String medicamento, String observacoes, ArrayList<Prescricao> prescricoes) {
        this.receitaMedica = new ReceitaMedica(paciente, medico, observacoes, prescricoes);
        return receitaMedica.toString();
    }

    /**
     * Obtém a receita médica associada à consulta.
     *
     * @return A receita médica associada, ou {@code null} se nenhuma receita tiver sido criada.
     */
    public ReceitaMedica getReceitaMedica() {
        return receitaMedica;
    }

    /**
     * Obtém a especialidade da consulta.
     *
     * @return A especialidade médica.
     */
    public String getEspecialidade() {
	return especialidade;
    }


    /**
     * Define a especialidade da consulta.
     *
     * @param especialidade A especialidade médica.
     */
    public void setEspecialidade(String especialidade) {
	this.especialidade = especialidade;
    }
    /**
     * Obtem o medico responsavel pela consulta.
     *
     * @return especialidade medio.
     */
    public Medico getMedico() {
	return medico;
    }
/**
     * Define o medico responsavel pela consulta.
     *
     * @param médico.
     */
    public void setMedico(Medico medico) {
	this.medico = medico;
    }
    /**
     * obtem a data da consulta.
     *
     * @return data da consulta.
     */
    public LocalDate getData() {
	return data;
    }
    /**
     * Define a data da consulta.
     *
     * @param especialidade data.
     */
    public void setData(LocalDate data) {
	this.data = data;
    }
    /**
     * obtem o horario da consulta.
     *
     * @return horario.
     */
    public LocalTime getHorario() {
	return horario;
    }
    /**
     * Define o horario da consulta.
     *
     * @param especialidade horario.
     */
    public void setHorario(LocalTime horario) {
	this.horario = horario;
    }
/**
     * obtem o paciente que marcou a consulta.
     *
     * @return paciente.
     */
    public Paciente getPaciente() {
	return paciente;
    }
 /**
     * Define o paciente que marcou a consulta.
     *
     * @param paciente.
     */
    public void setPaciente(Paciente paciente) {
	this.paciente = paciente;
    }
    /**
     * obtem o status da consulta.
     *
     * @return status.
     */
    public Status getStatus() {
        return status;
    }
     /**
     * Define a Receita medica.
     *
     * @param ReceitaMedica .
     */
    public void setReceita(ReceitaMedica receita){
        this.receita = receita;
    }
    /**
     * obtem o a receita medica.
     *
     * @return a receita medica como um objeto do tipo ReceitaMedica.
     */
    public ReceitaMedica getReceita(){
        return receita;
    }
     /**
     * Define o Status.
     *
     * @param status.
     */
    public void setStatus(Status status) {
        this.status = status;
    }
     /**
     * Verifica se dois objetos Consulta são iguais com base em paciente, médico, data e horário.
     *
     * @param o O objeto a ser comparado.
     * @return {@code true} se os objetos forem iguais; {@code false} caso contrário.
     */
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
    /**
     * Gera um código hash para a consulta baseado em paciente, médico, data e horário.
     *
     * @return O código hash gerado.
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
