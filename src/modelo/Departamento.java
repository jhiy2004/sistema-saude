/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author danie
 */
public class Departamento {

    private String cod; // codigo da especialidade
    private String nome;
    private ArrayList<Medico> medicos ;

    public Departamento(String cod, String nome){
        this.cod = cod;
        this.nome = nome;
        this.medicos = new ArrayList<>();
    }

    public Departamento(){
        this.medicos = new ArrayList<>();
    }

    public void addConsulta(Paciente p, GerenciadorConsultasExames gce){
        gce.addConsulta(p);

    }

    public Medico buscarMedCrm(String Crm){
        for(Medico m : this.medicos){
            if(m.getCrm().equals(Crm)){
                return m;
            }
        }
        return null;

    }

    public Medico buscarMedNome(String nome){
        for(Medico m : this.medicos){
            if(m.getNome().equals(nome)){
                return m;
            }
        }
        return null;
    }

    public void addMed(Medico house){
        this.medicos.add(house);
    }

    public int getContMedicos() {
        return this.medicos.size();
    }

    public String exibir(){
        String mensagem="";
        mensagem=mensagem +"Departamento\n";
        mensagem=mensagem+ "Nome:"+nome+"\n";
        mensagem=mensagem+ "Codigo:"+cod+"\n";
        for(int i=0; i < this.medicos.size(); i++){
            mensagem=mensagem +String.valueOf(i)+"-";
            mensagem=mensagem+ medicos.get(i).exibir();
            mensagem=mensagem+"\n:";
        }

        return mensagem;
    }

    public Medico buscarMedicoN(String nome){
        for(Medico m : this.medicos){
            if(m.getNomeMedico().equals(nome)){
                return m;
            }
        }//System.out.println("Nao encontrado");
        return null;
    }
    public Medico buscarMedicoCrm(String crm){
        for(Medico m : this.medicos){
            if(m.getCrm().equals(crm)){
                return m;
            }
        }//System.out.println("Nao encontrado");
        return null;
    }

    public double totalSalariosM(){
        double total=0;
        for(Medico m : this.medicos){
            total = total + m.getSalario();
        }
        return total;
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

    public ArrayList<Medico> getMedicos() {
        return this.medicos;
    }
}
