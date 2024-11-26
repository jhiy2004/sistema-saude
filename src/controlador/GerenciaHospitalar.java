/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.Consulta;
import modelo.Departamento;
import modelo.Exame;
import modelo.Hospital;
import modelo.Medico;
import modelo.Paciente;
import modelo.ReceitaMedica;
import modelo.Medicamento;

/**
 *
 * @author danie
 *
 * A classe GerenciaHospitalar é responsável por gerenciar o funcionamento do hospital,
 * incluindo o gerenciamento de pacientes, médicos, consultas, exames e estoque de medicamentos.
 * Ela também implementa o padrão Singleton para garantir que exista apenas uma instância
 * de gerenciamento de hospital no sistema.
 */
public class GerenciaHospitalar {
    private ArrayList <Paciente> cadastrados;
    private Hospital hospital;
    private GerenciarConsultasExames gce;
    private static GerenciaHospitalar instance;

    /**
     * Construtor privado para inicializar o hospital e o gerenciamento de consultas/exames.
     * Este construtor é chamado apenas uma vez quando a instância é criada via Singleton.
     *
     * @param nome Nome do hospital
     * @param limiteEmergencia Limite de pacientes na emergência
     */
    private GerenciaHospitalar(String nome, int limiteEmergencia) {
        this.cadastrados = new ArrayList<>();
        this.gce = new GerenciarConsultasExames();
        this.hospital = new Hospital(nome, limiteEmergencia);
    }
    /**
     * Retorna a instância única da classe GerenciaHospitalar (padrão Singleton).
     * Caso a instância ainda não tenha sido criada, ela será inicializada com valores padrão.
     *
     * @return A instância única de GerenciaHospitalar.
     */
    public static GerenciaHospitalar getInstance(){
        if(instance == null){
            instance = new GerenciaHospitalar("Hospital", 10);
        }
        return instance;
    }
    /**
     * Retorna o objeto Hospital associado à gerência hospitalar.
     *
     * @return O hospital gerenciado.
     */

    public Hospital getHospital(){
        return hospital;
    }
    /**
     * Adiciona um paciente ao hospital e registra a ação no log.
     *
     * @param p O paciente a ser adicionado.
     */

    public void addPaciente(Paciente p){
        Logger logger = Logger.getInstance();
        
        this.cadastrados.add(p);
        
        logger.gravaArquivo(String.format("Paciente '%s' adicionado", p.getNome()), Logger.Level.INFO);
    }
    /**
     * Remove um paciente do hospital e registra a ação no log.
     *
     * @param p O paciente a ser removido.
     */
    public void removerPaciente(Paciente p){
        Logger logger = Logger.getInstance();

        this.cadastrados.remove(p);
        
        logger.gravaArquivo(String.format("Paciente '%s' removido", p.getNome()), Logger.Level.INFO);

    }

    /**
     * Adiciona um médico ao hospital e registra a ação no log.
     *
     * @param m O médico a ser adicionado.
     */

    
    public void addMedico(Medico m){
        Logger logger = Logger.getInstance();

        this.hospital.addMed(m);
        
        logger.gravaArquivo(String.format("Médico '%s' adicionado", m.getNome()), Logger.Level.INFO);
    }
    /**
     * Remove um médico do hospital e registra a ação no log.
     *
     * @param m O médico a ser removido.
     */
    public void removerMedico(Medico m){
        Logger logger = Logger.getInstance();

        this.hospital.removerMed(m);
        logger.gravaArquivo(String.format("Médico '%s' removido", m.getNome()), Logger.Level.INFO);
    }
    /**
     * Retorna a lista de pacientes cadastrados no hospital.
     *
     * @return Lista de pacientes cadastrados.
     * 
     */
    public ArrayList<Paciente> getCadastrados() {
        return cadastrados;
    }
     /**
     * Retorna a lista de médicos cadastrados no hospital.
     *
     * @return Lista de médicos cadastrados.
     */
    public ArrayList<Medico> getMedicos(){
        return hospital.getMedicos();
    }
    /**
     * Retorna a lista de departamentos do hospital.
     *
     * @return Lista de departamentos do hospital.
     */
    public ArrayList<Departamento> getDepartamentos(){
        return hospital.getDepartamentos();
    }
    /**
     * Adiciona uma consulta para o paciente e registra a ação no sistema.
     * Se o paciente não estiver cadastrado, ele será adicionado ao cadastro.
     *
     * @param p O paciente a ser consultado.
     * @param numeroHospitalSelec Número do hospital onde a consulta será realizada (não utilizado diretamente aqui).
     * @param especialidade A especialidade médica relacionada à consulta.
     * @param m O médico responsável pela consulta.
     * @param data A data da consulta.
     * @param horario O horário da consulta.
     * @param r A receita médica associada à consulta.
     * @return A consulta agendada.
     */
    public Consulta addConsulta(Paciente p, int numeroHospitalSelec, String especialidade, Medico m, LocalDate data, LocalTime horario, ReceitaMedica r){ 
        for(Paciente cadastrado : this.cadastrados){
            if(cadastrado == p){
                Consulta c = gce.agendarConsulta(especialidade, p, m, data, horario, r);
		return c;
            }
        }
	// não está cadastrado
        cadastrados.add(p);
        Consulta c = gce.agendarConsulta(especialidade, p, m, data, horario, r);
	return c;
    }
    /**
     * Cancela uma consulta e retorna se a operação foi bem-sucedida.
     *
     * @param c A consulta a ser cancelada.
     * @return True se a consulta foi cancelada com sucesso, false caso contrário.
     */
    public boolean cancelarConsulta(Consulta c){
        return gce.cancelarConsulta(c);
    }
    /**
     * Adiciona um exame para o paciente e registra a ação no sistema.
     * Se o paciente não estiver cadastrado, ele será adicionado ao cadastro.
     *
     * @param p O paciente que fará o exame.
     * @param numeroHospitalSelec Número do hospital onde o exame será realizado (não utilizado diretamente aqui).
     * @param especialidade A especialidade médica relacionada ao exame.
     * @param m O médico responsável pelo exame.
     * @param data A data do exame.
     * @param horario O horário do exame.
     * @return O exame agendado.
     */
    public Exame addExame(Paciente p, int numeroHospitalSelec, String especialidade, Medico m, LocalDate data, LocalTime horario){
	for(Paciente cadastrado : this.cadastrados){
	    if(cadastrado == p){
		Exame e = gce.agendarExame(especialidade, p, m, data, horario);
		return e;
	    }
	}
	// não está cadastrado
	cadastrados.add(p);
	Exame e = gce.agendarExame(especialidade, p, m, data, horario);
	return e;
    }
     /**
     * Cancela um exame e retorna se a operação foi bem-sucedida.
     *
     * @param e O exame a ser cancelado.
     * @return True se o exame foi cancelado com sucesso, false caso contrário.
     */
    public boolean cancelarExame(Exame e){
	return gce.cancelarExame(e);
    }
    /**
     * Retorna a lista de medicamentos disponíveis no estoque do hospital.
     *
     * @return Lista de medicamentos disponíveis no estoque.
     */
    public ArrayList<Medicamento> getEstoque(){
        return hospital.getEstoque();
    }
    /**
     * Adiciona um medicamento ao estoque do hospital.
     *
     * @param m O medicamento a ser adicionado.
     */
    public void addMedicamento(Medicamento m){
        hospital.adicionarMedicamento(m);
    }
    /**
     * Remove um medicamento do estoque do hospital com base no código do medicamento.
     *
     * @param codigo O código do medicamento a ser removido.
     */
    public void removerMedicamento(String codigo){
        hospital.removerMedicamento(codigo);
    }
    /**
     * Interna um paciente no hospital, caso haja vaga disponível na emergência.
     *
     * @param p O paciente a ser internado.
     * @return True se o paciente foi internado com sucesso, false caso contrário.
     */
    public boolean internarPaciente(Paciente p){
        return this.hospital.internar(p);
    }
}
