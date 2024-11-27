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
    private String crm;
    private LocalDate data;
    private ReceitaMedica receitaMedica;
    private LocalTime horario;
    private String cpf;
    private ReceitaMedica receita;
    private Status status;
    
     /**
     * Construtor para inicializar os atributos da consulta.
     *
     * @param especialidade A especialidade médica da consulta.
     * @param crm O crm do médico responsável pela consulta.
     * @param data A data da consulta.
     * @param horario O horário da consulta.
     * @param cpf O cpf do paciente que será atendido na consulta.
     * @param receita A receita médica associada à consulta, se existir.
     */
    public Consulta(String especialidade, String crm, LocalDate data, LocalTime horario, String cpf, ReceitaMedica receita){
	this.especialidade = especialidade;
	this.crm = crm;
	this.data = data;
	this.horario = horario;
	this.cpf = cpf;
        this.receita = receita;
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
     * @return crm do médico.
     */
    public String getCrmMedico() {
	return this.crm;
    }
/**
     * Define o medico responsavel pela consulta.
     *
     * @param crm.
     */
    public void setCrmMedico(String crm) {
	this.crm = crm;
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
     * @param data.
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
     * @param horario.
     */
    public void setHorario(LocalTime horario) {
	this.horario = horario;
    }
/**
     * obtem o paciente que marcou a consulta.
     *
     * @return paciente.
     */
    public String getCpfPaciente() {
	return cpf;
    }
 /**
     * Define o paciente que marcou a consulta.
     *
     * @param cpf.
     */
    public void setCpfPaciente(String cpf) {
	this.cpf = cpf;
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
}
