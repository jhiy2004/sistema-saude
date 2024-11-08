/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.Consulta;
import modelo.Exame;
import modelo.Hospital;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author danie
 */
public class GerenciaHospitalar {
    private ArrayList <Paciente> cadastrados;
    private Hospital hospital; // Ainda nao esta sendo utilizado, mas será
    private GerenciarConsultasExames gce;


    public GerenciaHospitalar(String nome, int limiteEmergencia) {
        this.cadastrados = new ArrayList<>();
        this.gce = new GerenciarConsultasExames();
        this.hospital = new Hospital(nome, limiteEmergencia);
    }

    public void addPaciente(Paciente p){
        this.cadastrados.add(p);
    }
    
    public ArrayList<Paciente> getCadastrados() {
        return cadastrados;
    }

    public Consulta addConsulta(Paciente p, int numeroHospitalSelec, String especialidade, Medico m, LocalDate data, LocalTime horario){ 
        for(Paciente cadastrado : this.cadastrados){
            if(cadastrado == p){
                Consulta c = gce.agendarConsulta(especialidade, p, m, data, horario);
		return c;
            }
        }
	// não está cadastrado
        cadastrados.add(p);
        Consulta c = gce.agendarConsulta(especialidade, p, m, data, horario);
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
