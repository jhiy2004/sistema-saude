/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.GerenciarConsultasExames;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Hospital {
    private String nome;
    private ArrayList<Departamento> departamentos;// C. metodo que mostre os  de medicos de todos os departamentos I.TOtal.
    // conferir as especialidades;
    private Paciente emergencia[]; // pacientes na emergencia, verificar se há vagas nela
    // C. um Diretor para poder acessar o sistema (talvez). diretor herda medico;
    private GerenciarConsultasExames gce;
    private int limiteEmergencia;
    private int contPacientesEmergencia;

    public Hospital(String nome, int limiteEmergencia){
        this.nome = nome;
        this.limiteEmergencia = limiteEmergencia;
        this.departamentos = new ArrayList<>();
        this.emergencia = new Paciente[limiteEmergencia];
        this.gce = new GerenciarConsultasExames(this);
        this.contPacientesEmergencia = 0;
    }

    public Consulta addConsulta(String especialidade, Paciente p, Medico m, LocalDate data, LocalTime horario){
        return gce.agendarConsulta(especialidade, p, m, data, horario);
    }

    public boolean cancelarConsulta(Consulta c){
        return gce.cancelarConsulta(c);
    }
    
    public Exame addExame(String especialidade, Paciente p, Medico m, LocalDate data, LocalTime horario){
	return gce.agendarExame(especialidade, p, m, data, horario);
    }
    
    public boolean cancelarExame(Exame e){
	return gce.cancelarExame(e);
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

    public void addMed(Medico m){
        for(Departamento d : this.departamentos){
            if(d.getCod().equals(m.getEspecialidadeMedica())){
                d.addMed(m);
                return;
            }

            Departamento novo = new Departamento();
            novo.setNome("Departamento de "+m.getEspecialidadeMedica());
            novo.setCod(m.getEspecialidadeMedica());
            novo.addMed(m);

            this.departamentos.add(novo);
        }    
    }

    public boolean internar(Paciente p){
        if(this.contPacientesEmergencia < this.limiteEmergencia){
            this.emergencia[this.contPacientesEmergencia] = p;
            this.contPacientesEmergencia++;
            return true;
        }
        return false;
    }
}
