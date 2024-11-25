package modelo;

import interfaces.ProdutoHospitalar;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nome;
    private ArrayList<Departamento> departamentos;// C. metodo que mostre os  de medicos de todos os departamentos I.TOtal.
    // conferir as especialidades;
    private Paciente emergencia[]; // pacientes na emergencia, verificar se há vagas nela
    // C. um Diretor para poder acessar o sistema (talvez). diretor herda medico;
    private int limiteEmergencia;
    private int contPacientesEmergencia;
    private EstoqueHospitalar estoque;

    public Hospital(String nome, int limiteEmergencia){
        this.nome = nome;
        this.limiteEmergencia = limiteEmergencia;
        this.departamentos = new ArrayList<>();
        this.emergencia = new Paciente[limiteEmergencia];
        this.contPacientesEmergencia = 0;
    }

    public ArrayList<Departamento> getDepartamentos() {
        return this.departamentos;
    }
    public int getContDepartamentos() {
        return this.departamentos.size();
    }

    public int getContPacientesEmergencia() {
        return this.contPacientesEmergencia;
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
    
    public ArrayList<Medico> getMedicos(){
        ArrayList<Medico> medicos = new ArrayList<>();
        
        for(Departamento d : departamentos){
            medicos.addAll(d.getMedicos());
        }
        
        return medicos;
    }
    
    public void removerMed(Medico m){
        for(Departamento d : this.departamentos){
            if(d.getCod().equals(m.getEspecialidadeMedica())){
                d.removerMed(m);
                return;
            }
        }  
    }

    public void addMed(Medico m){
        for(Departamento d : this.departamentos){
            if(d.getCod().equals(m.getEspecialidadeMedica())){
                d.addMed(m);
                return;
            }
        }    
        
        Departamento novo = new Departamento();
        novo.setNome("Departamento de "+m.getEspecialidadeMedica());
        novo.setCod(m.getEspecialidadeMedica());
        novo.addMed(m);

        this.departamentos.add(novo);
    }

    public boolean internar(Paciente p){
        if(this.contPacientesEmergencia < this.limiteEmergencia){
            this.emergencia[this.contPacientesEmergencia] = p;
            this.contPacientesEmergencia++;
            return true;
        }
        return false;
    }
    
    public List<ProdutoHospitalar> getEstoque(){
        return estoque.getItens();
    }
}
