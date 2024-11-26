package modelo;

import constantes.Constantes;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * Classe responsável por gerenciar e representar a agenda de um medico, consultas e exames.
 * 
 * A agenda contém os horários disponíveis, consultas agendadas, consultas canceladas, 
 * exames agendados e exames cancelados, além de permitir operações como agendamento, 
 * cancelamento e remarcação.
 */
public class Agenda {
    private Map<LocalDate, List<LocalTime>> horariosDisponiveis;
    private Map<LocalDate, List<Consulta>> consultasAgendadas;
    private Map<LocalDate, List<Exame>> examesAgendados;
    private Map<LocalDate, List<Consulta>> consultasCanceladas;
    private Map<LocalDate, List<Exame>> examesCancelados;
    private Random random;

/**
     * Construtor da classe Agenda.
     * Inicializa as estruturas de dados e configura os horários disponíveis para os próximos 120 dias.
     */
    public Agenda() {
        this.horariosDisponiveis = new HashMap<>();
        this.consultasAgendadas = new HashMap<>();
        this.examesAgendados = new HashMap<>();
        this.consultasCanceladas = new HashMap<>();
        this.examesCancelados = new HashMap<>();
        this.random = new Random();
        inicializarHorariosDisponiveis();
    }

     /**
     * Inicializa os horários disponíveis para os próximos 120 dias, 
     * gerando horários aleatórios para cada dia.
     */
    private void inicializarHorariosDisponiveis() {
        LocalDate hoje = LocalDate.now();
        for (int i = 0; i < 120; i++) {
            LocalDate data = hoje.plusDays(i);
            List<LocalTime> horariosDoDia = new ArrayList<>();
            
            // Define a hora de início aleatória entre 7h e 10h
            int horaInicio = random.nextInt(4) + 7; // Gera números entre 7 e 10
            
            // Define a quantidade de horas trabalhadas no dia aleatoriamente entre 4 e 8
            int horasTrabalhadas = random.nextInt(5) + 4; // Gera números entre 4 e 8
            
            // Gerar os horários baseados na hora de início e na quantidade de horas trabalhadas
            for (int j = 0; j < horasTrabalhadas; j++) {
                horariosDoDia.add(LocalTime.of(horaInicio + j, 0));
            }
            
            horariosDisponiveis.put(data, horariosDoDia);
            consultasAgendadas.put(data, new ArrayList<>());
            consultasCanceladas.put(data, new ArrayList<>());
            examesAgendados.put(data, new ArrayList<>());
            examesCancelados.put(data, new ArrayList<>());
        }
    }

    /**
     * Agenda uma nova consulta em um horário disponível.
     *
     * @param Objeto do tipo Consulta contendo a data e o horário desejados.
     * @return A consulta agendada, ou {@code null} se o horário não estiver disponível.
     */
    public Consulta adicionarHorarioConsulta(Consulta consulta) {
        // Pega o dia e horario da consulta
        LocalDate data = consulta.getData();
        LocalTime horario = consulta.getHorario();

        // Verifica os horarios disponiveis do dia da consulta para verificar se é possível agendar
        List<LocalTime> horariosDoDia = horariosDisponiveis.get(data);
        if (horariosDoDia != null && horariosDoDia.contains(horario)) {
            // Remove o horario dos disponíveis
            horariosDoDia.remove(horario);
            
            // Adiciona a consulta as consultas agendadas e seta o status dela
            consultasAgendadas.get(data).add(consulta);
            consulta.setStatus(Constantes.Status.AGENDADO);
            
            System.out.println("Consulta agendada com sucesso para " + data + " às " + horario + ".");
            return consulta;
        } else {
            System.out.println("Horário indisponível para " + data + " às " + horario + ".");
            return null;
        }
    }

    
    /**
     * Cancela uma consulta agendada, liberando o horário.
     *
     * @param consulta A consulta a ser cancelada.
     * @return {@code true} se o cancelamento for bem-sucedido, ou {@code false} caso contrário.
     */
    public boolean cancelarHorarioConsulta(Consulta consulta) {
        // Pega o dia e horario da consulta
        LocalDate data = consulta.getData();
        LocalTime horario = consulta.getHorario();
        
        // Seleciona as consultas do dia para remover a consulta selecionada
        List<Consulta> consultasDoDia = consultasAgendadas.get(data);
        if (consultasDoDia != null && consultasDoDia.remove(consulta)) {
            // Seta o horário novamente como disponível
            horariosDisponiveis.get(data).add(horario);
            
            // Adiciona a consulta as consultas canceladas e seta o status dela
            consultasCanceladas.get(data).add(consulta);
            consulta.setStatus(Constantes.Status.CANCELADO);
            
            System.out.println("Consulta cancelada com sucesso para " + data + " às " + horario + ".");
            return true;
        } else {
            System.out.println("Consulta não encontrada para " + data + " às " + horario + ".");
            return false;
        }
    }

    /**
     * Reagenda uma consulta para uma nova data e horário.
     *
     * @param consulta A consulta a ser remarcada.
     * @param novaData A nova data para a consulta.
     * @param novoHorario O novo horário para a consulta.
     * @return A consulta remarcada, ou {@code null} no caso da consulta não ser marcada.
     */
    public Consulta remarcarHorarioConsulta(Consulta consulta, LocalDate novaData, LocalTime novoHorario) {
        if (cancelarHorarioConsulta(consulta)) {
            consulta.setData(novaData);
            consulta.setHorario(novoHorario);
            return adicionarHorarioConsulta(consulta);
        } else {
            System.out.println("Falha ao remarcar a consulta. Consulta original não encontrada.");
            return null;
        }
    }
    
    /**
     * Agenda um novo exame em um horário disponível.
     *
     * @param exame Objeto do tipo Exame contendo a data e o horário desejados.
     * @return O exame agendado, ou {@code null} se o horário não estiver disponível.
     */
    public Exame adicionarHorarioExame(Exame exame) {
        // Pega o dia e o horário do exame
        LocalDate data = exame.getData();
        LocalTime horario = exame.getHorario();

        // Verifica os horarios disponiveis do dia do exame para verificar se é possível agendar
        List<LocalTime> horariosDoDia = horariosDisponiveis.get(data);
        if (horariosDoDia != null && horariosDoDia.contains(horario)) {
            // Remove o horario dos disponíveis
            horariosDoDia.remove(horario);
            
            // Adiciona o exame aos exames agendados e seta o status dele
            examesAgendados.get(data).add(exame);
            exame.setStatus(Constantes.Status.AGENDADO);
            
            System.out.println("Exame agendado com sucesso para " + data + " às " + horario + ".");
            return exame;
        } else {
            System.out.println("Horário indisponível para " + data + " às " + horario + ".");
            return null;
        }
    }

    /**
     * Cancela um exame agendado, liberando o horário.
     *
     * @param exame O exame a ser cancelado.
     * @return {@code true} se o cancelamento for bem-sucedido, ou {@code false} caso contrário.
     */
    public boolean cancelarHorarioExame(Exame exame) {
        // Pega o dia e horario do exame
        LocalDate data = exame.getData();
        LocalTime horario = exame.getHorario();

        // Seleciona os exames do dia para remover o exame selecionado
        List<Exame> examesDoDia = examesAgendados.get(data);
        if (examesDoDia != null && examesDoDia.remove(exame)) {
            // Seta o horário novamente como disponível
            horariosDisponiveis.get(data).add(horario);
            
            // Adiciona o exame aos exames cancelados e seta o status dele
            examesCancelados.get(data).add(exame);
            exame.setStatus(Constantes.Status.CANCELADO);
            
            System.out.println("Exame cancelado com sucesso para " + data + " às " + horario + ".");
            return true;
        } else {
            System.out.println("Consulta não encontrada para " + data + " às " + horario + ".");
            return false;
        }
    }

    /**
     * Reagenda um exame para uma nova data e horário.
     *
     * @param exame O exame a ser remarcado.
     * @param novaData A nova data para o exame.
     * @param novoHorario O novo horário para o exame.
     * @return O exame remarcado, ou {@code null} se a remarcação falhar.
     */
    public Exame remarcarHorarioConsulta(Exame exame, LocalDate novaData, LocalTime novoHorario) {
        if (cancelarHorarioExame(exame)) {
            exame.setData(novaData);
            exame.setHorario(novoHorario);
            return adicionarHorarioExame(exame);
        } else {
            System.out.println("Falha ao remarcar o exame. Exame original não encontrada.");
            return null;
        }
    }

    /**
     * Obtém os horários disponíveis para uma data específica.
     *
     * @param data A data para a qual se deseja obter os horários disponíveis.
     * @return Uma lista de horários disponíveis na data especificada.
     */
    public List<LocalTime> getHorariosDisponiveis(LocalDate data) {
        return horariosDisponiveis.getOrDefault(data, Collections.emptyList());
    }

     /**
     * Obtém todas as consultas agendadas para uma data específica.
     *
     * @param data A data para a qual se deseja obter as consultas agendadas.
     * @return Uma lista de consultas agendadas na data especificada.
     */
    public List<Consulta> getConsultasAgendadas(LocalDate data) {
        return consultasAgendadas.getOrDefault(data, Collections.emptyList());
    }
    
      /**
     * Obtém todas as consultas agendadas no sistema.
     *
     * @return Uma lista de todas as consultas agendadas.
     */
    public List<Consulta> getTodasConsultasAgendadas() {
        List<Consulta> todasConsultas = new ArrayList<>();
        for (List<Consulta> consultasDoDia : consultasAgendadas.values()) {
            todasConsultas.addAll(consultasDoDia);
        }
        return todasConsultas;
    }
    
    /**
     * Obtém todas os exames agendados para uma data específica.
     *
     * @param data A data para a qual se deseja obter as consultas agendadas.
     * @return Uma lista de consultas agendadas na data especificada.
     */
    public List<Exame> getExamesAgendados(LocalDate data) {
        return examesAgendados.getOrDefault(data, Collections.emptyList());
    }
    
      /**
     * Obtém todas os exames agendadas no sistema.
     *
     * @return Uma lista de todas as consultas agendadas.
     */
    public List<Exame> getTodosExamesAgendados() {
        List<Exame> todosExames = new ArrayList<>();
        for (List<Exame> examesDoDia : examesAgendados.values()) {
            todosExames.addAll(examesDoDia);
        }
        return todosExames;
    }
}
