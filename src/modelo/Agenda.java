package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Agenda {
    private Map<LocalDate, List<LocalTime>> horariosDisponiveis;
    private Map<LocalDate, List<Consulta>> consultasAgendadas;
    private Map<LocalDate, List<Exame>> examesAgendados;

    public Agenda() {
        this.horariosDisponiveis = new HashMap<>();
        this.consultasAgendadas = new HashMap<>();
        inicializarHorariosDisponiveis();
    }

    // Inicializa os horários disponíveis para os próximos 30 dias
    private void inicializarHorariosDisponiveis() {
        LocalDate hoje = LocalDate.now();
        for (int i = 0; i < 30; i++) {
            LocalDate data = hoje.plusDays(i);
            List<LocalTime> horariosDoDia = new ArrayList<>();
	    // Trabalha das 8 as 16 (MUDAR ISSO PARA ALEATORIO)
            for (int j = 0; j < 8; j++) {
                horariosDoDia.add(LocalTime.of(8 + j, 0));
            }
            horariosDisponiveis.put(data, horariosDoDia);
            consultasAgendadas.put(data, new ArrayList<>());
        }
    }

    // Agendar uma nova consulta
    public Consulta adicionarHorarioConsulta(Consulta consulta) {
        LocalDate data = consulta.getData();
        LocalTime horario = consulta.getHorario();

        List<LocalTime> horariosDoDia = horariosDisponiveis.get(data);
        if (horariosDoDia != null && horariosDoDia.contains(horario)) {
            horariosDoDia.remove(horario);
            consultasAgendadas.get(data).add(consulta);
            System.out.println("Consulta agendada com sucesso para " + data + " às " + horario + ".");
            return consulta;
        } else {
            System.out.println("Horário indisponível para " + data + " às " + horario + ".");
            return null;
        }
    }

    // Cancelar uma consulta existente
    public boolean cancelarHorarioConsulta(Consulta consulta) {
        LocalDate data = consulta.getData();
        LocalTime horario = consulta.getHorario();

        List<Consulta> consultasDoDia = consultasAgendadas.get(data);
        if (consultasDoDia != null && consultasDoDia.remove(consulta)) {
            horariosDisponiveis.get(data).add(horario);
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
        LocalDate data = exame.getData();
        LocalTime horario = exame.getHorario();

        List<LocalTime> horariosDoDia = horariosDisponiveis.get(data);
        if (horariosDoDia != null && horariosDoDia.contains(horario)) {
            horariosDoDia.remove(horario);
            examesAgendados.get(data).add(exame);
            System.out.println("Exame agendado com sucesso para " + data + " às " + horario + ".");
            return exame;
        } else {
            System.out.println("Horário indisponível para " + data + " às " + horario + ".");
            return null;
        }
    }

    // Cancelar um exame existente
    public boolean cancelarHorarioExame(Exame exame) {
        LocalDate data = exame.getData();
        LocalTime horario = exame.getHorario();

        List<Exame> examesDoDia = examesAgendados.get(data);
        if (examesDoDia != null && examesDoDia.remove(exame)) {
            horariosDisponiveis.get(data).add(horario);
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
    
    // Obter exames agendados para uma data específica
    public List<Exame> getExamesAgendados(LocalDate data) {
        return examesAgendados.getOrDefault(data, Collections.emptyList());
    }
}
