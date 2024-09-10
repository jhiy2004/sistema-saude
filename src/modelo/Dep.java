/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistem_saude;

/**
 *
 * @author danie
 */
public class Dep {
    
       private String cod; // codigo da especialidade
private String nome;
private Medico medicos[] ;
private int cont=0;

public void addConsulta(Paciente p, GerenciadorConsultasExames gce){
    gce.addConsulta(p);

}

public Medico buscarMedCrm(String Crm){
for(int i=0;medicos[i]!=null;i++){
if(medicos[i].getCrm==Crm){
return medicos[i];}
}
return null;

}
public Medico buscarMedNome(String nome){
for(int i=0;medicos[i]!=null;i++){
if(medicos[i].getNome==nome){
return medicos[i];}
}
return null;

}




public void addMed(Medico house){
    medicos [cont]=house;
    cont++;

}
    public int getCont() {
        return cont;
    }


    public Dep() {
        cont=0;
    }
    
   
     public String exibir(){
     String mensagem="";
     mensagem=mensagem +"Departamento\n";
     mensagem=mensagem+ "Nome:"+nome+"\n";
     mensagem=mensagem+ "Codigo:"+cod+"\n";
      for(int i=0; medicos[i]!= null;i++){
          mensagem=mensagem +String.valueOf(i)+"-";
      mensagem=mensagem+ medicos[i].exibir();
      mensagem=mensagem+"\n:";
  }
          
           
return mensagem;
}
    
public Medico buscarMedicoN(String nome){
    for(int i=0; medicos[i]!= null;i++){
        if(medicos[i].getNomeMedico().equals(nome)){
        return medicos[i];
        }
    }//System.out.println("Nao encontrado");
    return null;
            }
public Medico buscarMedicoCrm(String crm){
    for(int i=0; medicos[i]!= null;i++){
        if(medicos[i].getCrm().equals(crm)){
        return medicos[i];
        }
    }//System.out.println("Nao encontrado");
    return null;
            }

public double totalSalariosM(){
    double total=0;
for(int i=0; medicos[i]!= null;i++){
    
total=total+medicos[i].getSalario();
}
return total;
}

    public Dep(String cod, String nome, Medico[] medicos) {
        int contagem=0;
        this.cod = cod;
        this.nome = nome;
        this.medicos = medicos;
        
        
        for(int i=0; medicos[i]!= null;i++){
    contagem=i;
    }
      this.cont=contagem;
    }

    public Dep(String cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }
    

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Medico[] getMedicos() {
        Medico medicos[] = new Medico[60];
        
        for(int i=0; this.medicos[i]!= null;i++){
   
    medicos[i]= this.medicos[i];
    }
      
        
        return medicos;
    }

    public void setMedicos(Medico[] medicos) {
        this.medicos = medicos;
        int contagem=0;
 for(int i=0; this.medicos[i]!= null;i++){
    contagem++;
    
    }
 this.cont=contagem;
    }

    }

  
    

