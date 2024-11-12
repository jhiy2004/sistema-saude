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

/**
 *
 * @author danie
 */
public class GerenciaHospitalar {
    private ArrayList <Paciente> cadastrados;
    private Hospital hospital; // Ainda nao esta sendo utilizado, mas será
    private GerenciarConsultasExames gce;
    private static GerenciaHospitalar instance;


    private GerenciaHospitalar(String nome, int limiteEmergencia) {
        this.cadastrados = new ArrayList<>();
        this.gce = new GerenciarConsultasExames();
        this.hospital = new Hospital(nome, limiteEmergencia);
    }

    public static GerenciaHospitalar getInstance(){
        if(instance == null){
            instance = new GerenciaHospitalar("Hospital", 10);
        }
        return instance;
    }
    
    public void addPaciente(Paciente p){
        Logger logger = Logger.getInstance();
        
        this.cadastrados.add(p);
        
        logger.gravaArquivo(String.format("Paciente '%s' adicionado", p.getNome()), Logger.Level.INFO);
    }
    
    public void removerPaciente(Paciente p){
        Logger logger = Logger.getInstance();

        this.cadastrados.remove(p);
        
        logger.gravaArquivo(String.format("Paciente '%s' removido", p.getNome()), Logger.Level.INFO);

    }
    
    public void addMedico(Medico m){
        Logger logger = Logger.getInstance();

        this.hospital.addMed(m);
        
        logger.gravaArquivo(String.format("Médico '%s' adicionado", m.getNome()), Logger.Level.INFO);
    }
    
    public void removerMedico(Medico m){
        Logger logger = Logger.getInstance();

        this.hospital.removerMed(m);
        logger.gravaArquivo(String.format("Médico '%s' removido", m.getNome()), Logger.Level.INFO);
    }
    
    public Hospital getHospital(){
        return hospital;
    }
    public ArrayList<Paciente> getCadastrados() {
        return cadastrados;
    }
    
    public ArrayList<Medico> getMedicos(){
        return hospital.getMedicos();
    }
    
    public ArrayList<Departamento> getDepartamentos(){
        return hospital.getDepartamentos();
    }

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

    public boolean cancelarConsulta(Consulta c){
        return gce.cancelarConsulta(c);
    }
    
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
    
    public boolean cancelarExame(Exame e){
	return gce.cancelarExame(e);
    }
}
