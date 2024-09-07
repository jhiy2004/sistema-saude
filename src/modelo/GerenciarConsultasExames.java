package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GerenciarConsultasExames {
    private final Hospital hospital;
    private ArrayList<Consulta> consultas;
    private ArrayList<Exame> exames;
    
    public GerenciarConsultasExames(Hospital hospital){
	this.consultas = new ArrayList<>();
	this.exames = new ArrayList<>();
	this.hospital = hospital;
    }

    public ArrayList<Consulta> getConsultas() {
	return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
	this.consultas = consultas;
    }

    public ArrayList<Exame> getExames() {
	return exames;
    }

    public void setExames(ArrayList<Exame> exames) {
	this.exames = exames;
    }
    
    public void agendarConsulta(String especialidade, Paciente p){
	// Mudar isso para perguntar ao paciente (DECIDIR COM O GRUPO COMO FAZER)
	Medico m = new Medico();
	LocalDate data = LocalDate.of(1999, 10, 24);
	LocalTime horario = LocalTime.of(12, 0, 0, 0);
	// Ate aqui
	
	// Seleciona os dados da consulta e passa para o medico adicionar
        m.adicionarConsulta(c);
	Consulta c = new Consulta(this.hospital, especialidade, m, data, horario, p);
	consultas.add(c);
    }
    
    public void cancelarConsulta(Consulta c){
	Medico m = c.getMedico();
	m.cancelarConsulta(c);
	consultas.remove(c);
    }
    
    public void agendarExame(){
	
    }
}
