/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Hospital {
    private String nome;
    private ArrayList<Departamento> departamentos;// C. metodo que mostre os  de medicos de todos os departamentos I.TOtal.
    // conferir as especialidades;
    private Paciente emergencia[]; // pacientes na emergencia, verificar se há vagas nela
    // C. um Diretor para poder acessar o sistema (talvez). diretor herda medico;
    private GerenciarConsultasExames gce;
    private int limiteEmergencia;
    private int contP;

    public Hospital(String nome, int limiteEmergencia){
        this.nome = nome;
        this.limiteEmergencia = limiteEmergencia;
        this.departamentos = new ArrayList<>();
        this.emergencia = new Paciente[limiteEmergencia];
        this.gce = new GerenciarConsultasExames();
        this.contP = 0;
    }

    public void addConsulta(String especialidade, Paciente p){
        this.gce.agendarConsulta(p);
    }

    public void addConsulta(Paciente p,String codEspecialidade){
        for(Departamento d : departamentos){
            if(d.getCod().equals(codEspecialidade)){
                d.addConsulta(p,gce);
            }
        }
        System.out.println("Hospital selecionado não possui nehum medico com essa especialidade");
        //Dificil de acontecer já que possui um filtro para hospitais que possuem a especialidade
    }


    public void cancelarConsulta(Consulta c){
        gce.cancelarConsulta(c);
    }

    public ArrayList<Departamento> getDepartamentos() {
        return this.departamentos;
    }
    public int getContDepartamentos() {
        return this.departamentos.size();
    }

    public int getContP() {
        return this.contP;
    }

    public void setNomeHospital(String nome) {
        this.nome = nome;
    }


    public String getNomeHospital() {
        return nome;
    }

    public int getLimiteEmergencia(){
        return this.limiteEmergencia;
    }

    public void setLimiteEmergencia(int limiteEmergencia){
        this.limiteEmergencia = limiteEmergencia;
    }

    public void addMed(Medico m){
        for(Departamento d : this.departamentos){
            if(d.getCod().equals(m.getEspecialidade().getCod())){
                d.addMed(m);
                return;
            }

            Departamento novo = new Departamento();
            novo.setNome("Departamento de "+m.getEspecialidade().getNome());
            novo.setCod(m.getEspecialidade().getCod());
            novo.addMed(m);

            this.departamentos.add(novo);
        }    

    }
    public String exibirDepartamentos(){
        String mensagem="";
        for(Departamento d : this.departamentos){
            mensagem = d.exibir();
        }
        return mensagem;  
    }

    public boolean internar(Paciente p){
        if(this.contP < this.limiteEmergencia){
            this.emergencia[this.contP] = p;
            this.contP++;
            return true;
        }
        return false;
    }

}
