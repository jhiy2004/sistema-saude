/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistem_saude;


public class Hospital {
    private String nome;
    private Dep departamentos[];// C. metodo que mostre os  de medicos de todos os departamentos I.TOtal.
    // conferir as especialidades;
    private int contD;
   
    private Paciente emergencia[]; // pacientes na emergencia, verificar se há vagas nela
    // C. um Diretor para poder acessar o sistema (talvez). diretor herda medico;
    private final int max=60;
private int contP;
private GerenciadorConsultasExames gce;




public void addConsulta(Paciente p){
    gce.addConsulta(p);
}

public void addConsulta(Paciente p,String codEspecialidade){
    for(int i=0;departamentos[i]!=null;i++){
    if(departamentos[i].getCod()==codEspecialidade){
    departamentos[i].addConsulta(p,gce);
    }
    }
    System.out.println("Hospital selecionado não possui nehum medico com essa especialidade");
    //Dificil de acontecer já que possui um filtro para hospitais que possuem a especialidade
}


public void cancelarConsulta(Consulta c){
gce.cancelarConsulta(c);
}

public Dep[] getDepartamentos() {
        Dep dep[] = new Dep[40];
        int contagem=0;
        for(int i=0; this.departamentos[i]!= null;i++){
    contagem++;
    
    dep[i]= this.departamentos[i];
    }
        contD=contagem;
        return dep;
}
    public int getContD() {
        return contD;
    }

  
    public int getContP() {
        return contP;
    }




    public void setNomeHospital(String nome) {
        this.nome = nome;
    }


    public String getNomeHospital() {
        return nome;
    }

    public Hospital() {
        contD=0;
        contP=0;
         emergencia=new Paciente()[max];
        
    }
    
   
    public Hospital(String nome, Dep[] departamentos,GerenciadorConsultasExames gce) {
      int contD=0;
      this.gce=gce;
        this.nome = nome;
        this.departamentos = departamentos;
          for(int i=0; departamentos[i]!= null;i++){
    contD=i;
    }
    this.contD = contD;
    emergencia=new Paciente()[max];
     
    
    }
 
    

    public void addMed(Medico m){
    for(int i=0; departamentos[i]!=null;i++){
    if(departamentos[i].getCod()==m.getEspecialidade().getCod()){
        departamentos[i].addMed(m);
        contD++;
        return;
    }
   departamentos[contD]=new Dep( );
   departamentos[contD].setNome("Departamento de "+m.getEspecialidade().getNome());
   departamentos[contD].setCod(m.getEspecialidade().getCod());
   departamentos[contD].addMed(m);
   
    }    
        
    }
    public String exibirDepartamentos(){
     String mensagem="";
  for(int i=0; this.departamentos[i]!= null;i++){
      mensagem=departamentos[i].exibir();
  }
      return mensagem;  
    }
    public int internar(Paciente p){
        if(contP<max){
        emergencia[contP]=p;
        contP=contP+1;
        return 1;
        }
        return 0; //sem vagas
    
    }
    
}
    
    
    
    
    
    

