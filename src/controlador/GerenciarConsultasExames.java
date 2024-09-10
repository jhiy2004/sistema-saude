package controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.Consulta;
import modelo.Exame;
import modelo.Hospital;
import modelo.Medico;
import modelo.Paciente;

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
    
    public Consulta agendarConsulta(String especialidade, Paciente p, Medico m, LocalDate data, LocalTime horario){
	Consulta c = new Consulta(this.hospital, especialidade, m, data, horario, p);
        Consulta retorno = m.adicionarConsulta(c);
	consultas.add(c);
        return retorno;
    }
    
    public boolean cancelarConsulta(Consulta c){
	Medico m = c.getMedico();
	boolean retorno = m.cancelarConsulta(c);
        if(retorno){
            // Se removeu na agenda, remove aqui
            consultas.remove(c);
        }
        return retorno;
    }
    
    public Exame agendarExame(String especialidade, Paciente p, Medico m, LocalDate data, LocalTime horario){
        Exame e = new Exame(this.hospital, especialidade, m, data, horario, p);
        Exame retorno = m.adicionarExame(e);
        exames.add(e);
        return retorno;
    }
    
    public boolean cancelarExame(Exame e){
        Medico m = e.getMedico();
        boolean retorno = m.cancelarExame(e);
        if(retorno){
            // Se removeu na agenda, remove aqui
            exames.remove(e);
        }
        return retorno;
    }
}
