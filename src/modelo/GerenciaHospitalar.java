/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistem_saude;
import java.util.ArrayList;
/**
 *
 * @author danie
 */
public class GerenciaHospitalar {
    private Hospital hospitais[];
    private ArrayList <Pacientes> cadastrados;
//private ArrayList <Hospital> hospitais;

    
    public GerenciaHospitalar(Hospital[] hospitais, ArrayList<Pacientes> cadastrados) {
        this.hospitais = hospitais;
        this.cadastrados = cadastrados;
    }

    public GerenciaHospitalar() {
    }

    public Hospital[] getHospitais() {
        return hospitais;
    }

    public void setHospitais(Hospital[] hospitais) {
        this.hospitais = hospitais;
    }

    public ArrayList<Pacientes> getCadastrados() {
        return cadastrados;
    }

    public void setCadastrados(ArrayList<Pacientes> cadastrados) {
        this.cadastrados = cadastrados;
    }

    
    
    
public String exibirHospitais(){
    String mensagem="";
for(int i=0;hospitais[i]!=null;i++){
mensagem=i+"-"+hospitais[i].getNomeHospital()+"\n"; // Exibindo os nomes dos hospitais com seus numeros para a seleção
} 
return mensagem;
}
public String exibirHospitais(String codEspecialidade){
    String mensagem="";
for(int i=0;hospitais[i]!=null;i++){
    for(int k=0;hospitais[i].getDepartamentos()[k]!=null;k++){
    if(hospitais[i].getDepartamentos()[k].getCod().equals(codEspecialidade)){
    
mensagem=i+"-"+hospitais[i].getNomeHospital()+"\n"; // Exibindo os nomes dos hospitais com seus numeros para a seleção
    } }                                     //filtrando de acordo com as especialidades
}
return mensagem;
}

public void addConsulta(Paciente p, int numeroHospitalSelec){ 
    for(int i = 0; i < cadastrados.size(); i++){
        if(cadastrados.get(i) == p){
         hospitais[numeroHospitalSelec].addConsulta(p);
    
        }
      }// não está cadastrado
    cadastrados.add(p);
    //pronto
     hospitais[numeroHospitalSelec].addConsulta(p);
    }
public void addConsulta(Paciente p, int numeroHospitalSelec, String codEspecialidade){ 
    for(int i = 0; i < cadastrados.size(); i++){
        if(cadastrados.get(i) == p){
         hospitais[numeroHospitalSelec].addConsulta(p,codEspecialidade);
    
        }
      }// não está cadastrado
    cadastrados.add(p);
    //pronto
     hospitais[numeroHospitalSelec].addConsulta(p,codEspecialidade);
    }    


public void cancelarConsulta(Consulta c){
c.getHospital.cancelarConsulta(c);
}
   
}
    

