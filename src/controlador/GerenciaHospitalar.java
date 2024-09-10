/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;

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

    public addHospital(Hospital h){
        this.hospitais.add(h);
    }

    public addPaciente(Paciente p){
        this.cadastrados.add(p);
    }

    public ArrayList<Hospital> getHospitais() {
        return this.hospitais;
    }

    public ArrayList<Paciente> getCadastrados() {
        return cadastrados;
    }


    public void addConsulta(Paciente p, int numeroHospitalSelec){ 
        for(Paciente cadastrado : this.cadastrados){
            if(cadastrado == p){
                hospitais.get(numeroHospitalSelec).addConsulta(p);

            }
        }// não está cadastrado
        cadastrados.add(p);
        //pronto
        hospitais.get(numeroHospitalSelec).addConsulta(p);
    }
    public void addConsulta(Paciente p, int numeroHospitalSelec, String codEspecialidade){ 
        for(Paciente cadastrado : this.cadastrados){
            if(cadastrado == p){
                hospitais.get(numeroHospitalSelec).addConsulta(p,codEspecialidade);
            }
        }// não está cadastrado
        cadastrados.add(p);
        //pronto
        hospitais.get(numeroHospitalSelec).addConsulta(p,codEspecialidade);
    }    

    public void cancelarConsulta(Consulta c){
        c.getHospital().cancelarConsulta(c);
    }

    public String exibirHospitais(){
        String mensagem="";
        int i = 1;
        for(Hospital h : this.hospitais){
            mensagem=i+"-"+h.getNomeHospital()+"\n"; // Exibindo os nomes dos hospitais com seus numeros para a seleção
            i++;
        } 
        return mensagem;
    }
    public String exibirHospitais(String codEspecialidade){
        String mensagem="";
        for(Hospital h : this.hospitais){
            ArrayList<Departamento> deptos = h.getDepartamentos();
            for(Departamento depto : deptos){
                if(depto.getCod().equals(codEspecialidade)){
                    mensagem=i+"-"+hospitais[i].getNomeHospital()+"\n"; // Exibindo os nomes dos hospitais com seus numeros para a seleção
                    break;
                }
            }                                     //filtrando de acordo com as especialidades
        }
        return mensagem;
    }
}
