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
    
    public void agendarConsulta(String especialidade, Paciente p, Medico m, LocalDate data, LocalTime horario){
	Consulta c = new Consulta(this.hospital, especialidade, m, data, horario, p);
        m.adicionarConsulta(c);
	consultas.add(c);
    }
    
    public void cancelarConsulta(Consulta c){
	Medico m = c.getMedico();
	m.cancelarConsulta(c);
	consultas.remove(c);
    }
    
    public void agendarExame(String especialidade, Paciente p, Medico m, LocalDate data, LocalTime horario){
        Exame e = new Exame(this.hospital, especialidade, m, data, data, horario, p);
        m.adicionarExame(e);
        exames.add(e);
    }
    
    public void cancelarExame(Exame e){
        Medico m = e.getMedico();
        m.cancelarExame(e);
        exames.remove(e);
    }
}
