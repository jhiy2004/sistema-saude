/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Consulta;
import modelo.Exame;
import modelo.Hospital;
import modelo.Paciente;

/**
 *
 * @author danie
 */
public class GerenciaHospitalar {
    private ArrayList <Paciente> cadastrados;
    private ArrayList <Hospital> hospitais;


    public GerenciaHospitalar() {
        this.cadastrados = new ArrayList<>();
        this.hospitais = new ArrayList<>();
    }

    public void addHospital(Hospital h){
        this.hospitais.add(h);
    }

    public void addPaciente(Paciente p){
        this.cadastrados.add(p);
    }

    public ArrayList<Hospital> getHospitais() {
        return this.hospitais;
    }

    public ArrayList<Paciente> getCadastrados() {
        return cadastrados;
    }


    public Consulta addConsulta(Paciente p, int numeroHospitalSelec, String especialidade){ 
        for(Paciente cadastrado : this.cadastrados){
            if(cadastrado == p){
                Consulta c = hospitais.get(numeroHospitalSelec).addConsulta(especialidade, p);
		return c;
            }
        }
	// não está cadastrado
        cadastrados.add(p);
        Consulta c = hospitais.get(numeroHospitalSelec).addConsulta(especialidade, p);
	return c;
    }

    public boolean cancelarConsulta(Consulta c){
        return c.getHospital().cancelarConsulta(c);
    }
    
    public Exame addExame(Paciente p, int numeroHospitalSelec, String especialidade){
	for(Paciente cadastrado : this.cadastrados){
	    if(cadastrado == p){
		Exame e = hospitais.get(numeroHospitalSelec).addExame(especialidade, p);
		return e;
	    }
	}
	// não está cadastrado
	cadastrados.add(p);
	Exame e = hospitais.get(numeroHospitalSelec).addExame(especialidade, p);
	return e;
    }
    
    public boolean cancelarExame(Exame e){
	return e.getHospital().cancelarExame(e);
    }
}
