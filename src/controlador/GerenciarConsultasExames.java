package controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.Consulta;
import modelo.Exame;
import modelo.Medico;
import modelo.Paciente;
import modelo.ReceitaMedica;

public class GerenciarConsultasExames {
    private ArrayList<Consulta> consultas;
    private ArrayList<Exame> exames;
    
    public GerenciarConsultasExames(){
	this.consultas = new ArrayList<>();
	this.exames = new ArrayList<>();
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
    
    public Consulta agendarConsulta(String especialidade, Paciente p, Medico m, LocalDate data, LocalTime horario, ReceitaMedica r){
	Consulta c = new Consulta(especialidade, m, data, horario, p, r);
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
        Exame e = new Exame(especialidade, m, data, horario, p);
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
