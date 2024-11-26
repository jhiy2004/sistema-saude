package controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.Consulta;
import modelo.Exame;
import modelo.Medico;
import modelo.Paciente;
import modelo.ReceitaMedica;
/**
 * A classe GerenciarConsultasExames é responsável por gerenciar todas as consultas e exames no sistema,
 * permitindo o agendamento e o cancelamento tanto de consultas quanto de exames, e mantendo listas
 * dessas entidades.
 */
public class GerenciarConsultasExames {
    private ArrayList<Consulta> consultas;
    private ArrayList<Exame> exames;
    
    /**
     * Construtor da classe GerenciarConsultasExames. Inicializa as listas de consultas e exames.
     */
    public GerenciarConsultasExames(){
	this.consultas = new ArrayList<>();
	this.exames = new ArrayList<>();
    }
    /**
     * Retorna a lista de consultas agendadas.
     *
     * @return Lista de consultas agendadas.
     */
    public ArrayList<Consulta> getConsultas() {
	return consultas;
    }
    /**
     * Define a lista de consultas agendadas.
     *
     * @param consultas Lista de consultas a ser definida.
     */
    public void setConsultas(ArrayList<Consulta> consultas) {
	this.consultas = consultas;
    }
    /**
     * Retorna a lista de exames agendados.
     *
     * @return Lista de exames agendados.
     */
    public ArrayList<Exame> getExames() {
	return exames;
    }
     /**
     * Define a lista de exames agendados.
     *
     * @param exames Lista de exames a ser definida.
     */
    public void setExames(ArrayList<Exame> exames) {
	this.exames = exames;
    }
    /**
     * Agenda uma nova consulta para um paciente com um médico específico em uma data e horário.
     * A consulta também inclui uma receita médica, caso necessário.
     *
     * @param especialidade A especialidade da consulta.
     * @param p O paciente que será atendido.
     * @param m O médico que realizará a consulta.
     * @param data A data da consulta.
     * @param horario O horário da consulta.
     * @param r A receita médica associada à consulta, se houver.
     * @return A consulta agendada.
     */
    public Consulta agendarConsulta(String especialidade, Paciente p, Medico m, LocalDate data, LocalTime horario, ReceitaMedica r){
	Consulta c = new Consulta(especialidade, m, data, horario, p, r);
        Consulta retorno = m.adicionarConsulta(c);
	consultas.add(c);
        return retorno;
    }
     /**
     * Cancela uma consulta agendada, removendo-a tanto da agenda do médico quanto da lista de consultas.
     *
     * @param c A consulta a ser cancelada.
     * @return Retorna true se a consulta foi cancelada com sucesso, false caso contrário.
     */
    public boolean cancelarConsulta(Consulta c){
	Medico m = c.getMedico();
	boolean retorno = m.cancelarConsulta(c);
        if(retorno){
            // Se removeu na agenda, remove aqui
            consultas.remove(c);
        }
        return retorno;
    }
    /**
     * Agenda um novo exame para um paciente com um médico específico em uma data e horário.
     *
     * @param especialidade A especialidade do exame.
     * @param p O paciente que será submetido ao exame.
     * @param m O médico que solicitará o exame.
     * @param data A data do exame.
     * @param horario O horário do exame.
     * @return O exame agendado.
     */
    public Exame agendarExame(String especialidade, Paciente p, Medico m, LocalDate data, LocalTime horario){
        Exame e = new Exame(especialidade, m, data, horario, p);
        Exame retorno = m.adicionarExame(e);
        exames.add(e);
        return retorno;
    }
    /**
     * Cancela um exame agendado, removendo-o tanto da agenda do médico quanto da lista de exames.
     *
     * @param e O exame a ser cancelado.
     * @return Retorna true se o exame foi cancelado com sucesso, false caso contrário.
     */
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
