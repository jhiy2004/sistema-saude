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

public class Agenda {
    private Map<LocalDate, List<LocalTime>> horariosDisponiveis;
    private Map<LocalDate, List<Consulta>> consultasAgendadas;
    private Map<LocalDate, List<Exame>> examesAgendados;
    private Map<LocalDate, List<Consulta>> consultasCanceladas;
    private Map<LocalDate, List<Exame>> examesCancelados;
    private Random random;

    public Agenda() {
        this.horariosDisponiveis = new HashMap<>();
        this.consultasAgendadas = new HashMap<>();
        this.examesAgendados = new HashMap<>();
        this.consultasCanceladas = new HashMap<>();
        this.examesCancelados = new HashMap<>();
        this.random = new Random();
        inicializarHorariosDisponiveis();
    }

    // Inicializa os horários disponíveis para os próximos 120 dias a partir de hoje
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

    // Agendar uma nova consulta
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

    // Cancelar uma consulta existente
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

    // Remarcar uma consulta existente para um novo horário
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
    
    // Agendar um novo exame
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

    // Cancelar um exame existente
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

    // Remarcar um exame existente para um novo horário
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

    // Obter horários disponíveis para uma data específica
    public List<LocalTime> getHorariosDisponiveis(LocalDate data) {
        return horariosDisponiveis.getOrDefault(data, Collections.emptyList());
    }

    // Obter consultas agendadas para uma data específica
    public List<Consulta> getConsultasAgendadas(LocalDate data) {
        return consultasAgendadas.getOrDefault(data, Collections.emptyList());
    }
    
    // Obter todas as consultas agendadas
    public List<Consulta> getTodasConsultasAgendadas() {
        List<Consulta> todasConsultas = new ArrayList<>();
        for (List<Consulta> consultasDoDia : consultasAgendadas.values()) {
            todasConsultas.addAll(consultasDoDia);
        }
        return todasConsultas;
    }
    
    // Obter exames agendados para uma data específica
    public List<Exame> getExamesAgendados(LocalDate data) {
        return examesAgendados.getOrDefault(data, Collections.emptyList());
    }
    
    // Obter todos os exames agendados
    public List<Exame> getTodosExamesAgendados() {
        List<Exame> todosExames = new ArrayList<>();
        for (List<Exame> examesDoDia : examesAgendados.values()) {
            todosExames.addAll(examesDoDia);
        }
        return todosExames;
    }
}
