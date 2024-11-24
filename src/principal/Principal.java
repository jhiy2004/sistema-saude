package principal;

import constantes.Constantes;
import modelo.*;
import controlador.*;
import interfaces.ProdutoHospitalar;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Principal {
    public static Scanner sc = new Scanner(System.in);
    
    public static void menuPrincipal(){
        int opc = 0;
        
        do{
            System.out.println("========= Principal =========");
            System.out.println("1 - Adicionar paciente");
            System.out.println("2 - Adicionar médico");
            System.out.println("3 - Adicionar exame");
            System.out.println("4 - Adicionar consulta");
            System.out.println("5 - Adicionar medicamento");
            System.out.println("6 - Adicionar departamento");

            System.out.println("7 - Remover paciente");
            System.out.println("8 - Remover médico");
            System.out.println("9 - Remover exame");
            System.out.println("10 - Remover consulta");
            System.out.println("11 - Remover medicamento");
            System.out.println("12 - Remover departamento");

            System.out.println("13 - Listar pacientes");
            System.out.println("14 - Listar médicos");
            System.out.println("15 - Listar exames por médico");
            System.out.println("16 - Listar exames por paciente");
            System.out.println("17 - Listar consultas por médico");
            System.out.println("18 - Listar consultas por paciente");

            System.out.println("19 - Gerar relatório de estoque");
            System.out.println("20 - Gerar relatório de departamentos");
            System.out.println("0 - Sair");
            
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();            
            
            sc.nextLine();
            
            switch(opc){
                case 1:
                    menuPaciente();
                    break;
                case 4:
                    menuConsulta();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 13:
                    listarPacientes();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opc != 0);
        
    }
    
    public static void menuPaciente(){
        int opc = 0;
        boolean salvar = false;
        
        String nome = "";
        int idade = 0;
        boolean sexo = false;
        String profissao = "";
        String endereco = "";
        String telefone = "";
        double peso = 0.0;
        double altura = 0.0;
        String cpf = "";
        String tipoSanguineo = "";
        HistoricoMedico hm = null;
        
        Paciente p = new Paciente(nome, cpf, idade, sexo, profissao, endereco, telefone, peso, altura, tipoSanguineo, hm);

        do{
            System.out.println("========= Paciente =========");
            System.out.println("1 - Nome");
            System.out.println("2 - Idade");
            System.out.println("3 - Sexo");
            System.out.println("4 - Profissão");
            System.out.println("5 - Endereço");
            System.out.println("6 - Telefone");
            System.out.println("7 - Peso");
            System.out.println("8 - Altura");
            System.out.println("9 - CPF");
            System.out.println("10 - Tipo sanguíneo");
            System.out.println("11 - Histórico médico");
            System.out.println("0 - Voltar para menu principal");
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();
            
            sc.nextLine();
            
            switch(opc){
                case 1:
                    System.out.print("Digite o nome do paciente: ");
                    nome = sc.nextLine();
                    
                    p.setNome(nome);
                    break;
                case 2:
                    System.out.print("Digite a idade do paciente: ");
                    idade = sc.nextInt();
                    sc.nextLine();
                    
                    p.setIdade(idade);
                    break;
                case 3:
                    sexo = selecionarSexo();
                    
                    p.setSexo(sexo);
                    break;
                case 4:
                    System.out.print("Digite a profissão do paciente: ");
                    profissao = sc.nextLine();
                    
                    p.setProfissao(profissao);
                    break;
                case 5:
                    System.out.print("Digite o endereço do paciente: ");
                    endereco = sc.nextLine();
                    
                    p.setEndereco(endereco);
                    break;
                case 6:
                    System.out.print("Digite o telefone do paciente: ");
                    telefone = sc.nextLine();
                    
                    p.setTelefone(telefone);
                    break;
                case 7:
                    System.out.print("Digite o peso do paciente (Kg): ");
                    peso = sc.nextDouble();
                    sc.nextLine();
                    
                    p.setPeso(peso);
                    break;
                case 8:
                    System.out.print("Digite a altura do paciente (metros): ");
                    altura = sc.nextDouble();
                    sc.nextLine();
                    
                    p.setAltura(altura);
                    break;
                case 9:
                    System.out.print("Digite o cpf do paciente: ");
                    cpf = sc.nextLine();
                    
                    p.setCPF(cpf);
                    break;
                case 10:
                    tipoSanguineo = selecionarTipoSanguineo();
                    
                    p.setTipoSanguineo(tipoSanguineo);
                    break;
                case 11:
                    hm = menuHistoricoMedico();
                    p.setHistoricoMedico(hm);
                    break;
                case 0:
                    relatorioPaciente(p);
                    salvar = selecionarSimNao("O paciente está dessa forma, deseja salvar");
                    
                    if(salvar == true){
                        System.out.println("Salvando paciente");
                        
                        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
                        gh.addPaciente(p);
                    }else{
                        p = null;
                        System.out.println("Saindo sem salvar");
                    }
                    System.out.println("Voltando para o menu principal");                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opc != 0);
    }
    
    public static void menuMedico(){
        System.out.println("========= Medico =========");
        System.out.println("1 - Nome");
        System.out.println("2 - Crm");
        System.out.println("3 - Especialidade médica");
        System.out.println("4 - Salário");
        System.out.println("5 - Escolher departamento");
        System.out.println("0 - Voltar para menu principal");
    }
    
    public static void menuMedicamento(){
        System.out.println("========= Medicamento =========");
        System.out.println("1 - Nome");
        System.out.println("2 - Codigo");
        System.out.println("3 - Data validade");
        System.out.println("4 - Quantidade");
        System.out.println("5 - Fabricante");
        System.out.println("0 - Voltar para menu principal");
    }
    
    public static void menuDepartamento(){
        System.out.println("========= Departamento =========");
        System.out.println("1 - Nome");
        System.out.println("2 - Codigo");
        System.out.println("0 - Voltar para menu principal");
    }
    
    public static void menuConsulta(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        int opc;
        Paciente paciente = null;
        Medico medico = null;
        String observacoes = null;
        ReceitaMedica receita = null;
        
        while(true){
            System.out.println("========= Consulta =========");
            System.out.println("1 - Escolher paciente");
            System.out.println("2 - Escolher médico");
            System.out.println("3 - Criar receita");
            System.out.println("0 - Voltar para menu principal");
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();
            
            switch(opc){
                case 1:
                    ArrayList<Paciente> pacientes = gh.getCadastrados();
                    int pacienteIndex = selecionarPaciente(pacientes);
                    paciente = pacientes.get(pacienteIndex);
                    break;
                case 2:
                    ArrayList<Medico> medicos = gh.getMedicos();
                    int medicoIndex = selecionarMedico(medicos);
                    medico = medicos.get(medicoIndex);
                    break;
                case 3:
                    if(paciente != null && medico != null && receita == null){
                        menuReceita(paciente, medico);
                    }else{
                        System.out.println("Impossível criar Receita");
                    }
                    break;
                case 0:
                    // MODIFICAR O DATE E TIME
                    Consulta consulta = new Consulta(medico.getEspecialidadeMedica(), medico, LocalDate.MAX, LocalTime.MIN, paciente, receita);
                    System.out.println("Dados da Consulta:");
                    relatorioConsulta(consulta);
                    // Salvar a consulta
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }
        }
    }
    
    public static void menuReceita(Paciente p, Medico m){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        ArrayList<Prescricao> prescricoes = new ArrayList<>();
        String observacao = null;
        int opc;
        
        while(true){
            System.out.println("========= Receita médica =========");
            System.out.println("1 - Adicionar prescrições");
            System.out.println("2 - Observações");
            System.out.println("0 - Voltar para menu principal");
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();
            
            switch(opc){
                case 1:
                    Prescricao prescricao = menuPrecricao();
                    prescricoes.add(prescricao);
                    break;
                case 2:
                    System.out.print("Digite a observação da receita: ");
                    observacao = sc.nextLine();
                    break;
                case 0:
                    if(prescricoes != null && observacao != null){
                        ReceitaMedica receita = new ReceitaMedica(p, m, observacao, prescricoes);
                        
                        System.out.println("Dados da receita:");
                        relatorioReceita(receita);
                        return;
                    }else{
                        System.out.println("Faltam elementos da receita a serem preenchidos");
                    }
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
            }
        }
    }
    
    public static Prescricao menuPrecricao(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        Medicamento medicamento = null;
        String dosagem = "";
        String instrucoes = "";
        int opc;
        
        while(true){
            System.out.println("========= Prescrição =========");
            System.out.println("1 - Medicamento");
            System.out.println("2 - Dosagem");
            System.out.println("3 - Instruções");
            System.out.println("0 - Voltar para menu principal");
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();
            
            switch(opc){
                case 1:
                    // Selecionar medicamento
                   break;
                case 2:
                    System.out.print("Digite a dosagem : ");
                    dosagem = sc.nextLine();
                    break;
                case 3:
                    System.out.print("Digite as instruções:");
                    instrucoes = sc.nextLine();
                    break;
                case 4:
                    if(medicamento != null){
                        Prescricao prescricao = new Prescricao(medicamento, dosagem, instrucoes);
                        System.out.println("Dados da prescrição:");
                        relatorioPrescricao(prescricao);
                        return prescricao;
                    }else{
                        System.out.println("Medicamento não selecionado ainda");
                    }
            }
        }
        
    }
    
    public static void menuExame(){
        System.out.println("========= Exame =========");
        System.out.println("1 - Escolher paciente");
        System.out.println("2 - Escolher médico");
        System.out.println("3 - Tipo exame");
        System.out.println("0 - Voltar para menu principal");
    }
    
    public static HistoricoMedico menuHistoricoMedico(){  
        String historicoFamiliar = "";
	String historicoMedicamentos = "";
	String historicoCirurgias = "";
	String doencasPrevias = "";
	String doencasCronicas = "";
        
        boolean usoMedicamentos = false;
	boolean usoCigarroAlcool = false;
	boolean praticaExercicios = false;
        
        HistoricoMedico hm = new HistoricoMedico(historicoFamiliar, historicoMedicamentos, historicoCirurgias,
                                    doencasPrevias, doencasCronicas, usoMedicamentos, usoCigarroAlcool, praticaExercicios);

        int opc = 0;
        boolean salvar = false;
        
        do{
            System.out.println("========= Histórico médico =========");
            System.out.println("1 - Histórico familiar");
            System.out.println("2 - Histórico de medicamentos");
            System.out.println("3 - Histórico de cirurgias");
            System.out.println("4 - Doenças prévias");
            System.out.println("5 - Doenças crônicas");
            System.out.println("6 - Já fez uso de medicamentos?");
            System.out.println("7 - Já fez uso de cigarros ou álcool?");
            System.out.println("8 - Pratica exercícios?");
            System.out.println("0 - Voltar para menu principal");
    
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();
            
            sc.nextLine();
            
            switch(opc){
                case 1:
                    System.out.print("Digite o histórico familiar: ");
                    historicoFamiliar = sc.nextLine();
                    
                    hm.setHistoricoFamiliar(historicoFamiliar);
                    break;
                case 2:
                    System.out.print("Digite o histórico de medicamentos: ");
                    historicoMedicamentos = sc.nextLine();
                    
                    hm.setHistoricoMedicamentos(historicoMedicamentos);
                    break;
                case 3:
                    System.out.print("Digite o histórico de cirurgias: ");
                    historicoCirurgias = sc.nextLine();
                    
                    hm.setHistoricoCirurgias(historicoCirurgias);
                    break;
                case 4:
                    System.out.print("Digite as doenças prévias: ");
                    doencasPrevias = sc.nextLine();
                    
                    hm.setDoencasPrevias(doencasPrevias);
                    break;
                case 5:
                    System.out.print("Digite as doenças crônicas: ");
                    doencasCronicas = sc.nextLine();
                    
                    hm.setDoencasCronicas(doencasCronicas);
                    break;
                case 6:
                    usoMedicamentos = selecionarSimNao("Já fez uso de medicamentos");
                    
                    hm.setUsoMedicamentos(usoMedicamentos);
                    break;
                case 7:
                    usoCigarroAlcool = selecionarSimNao("Já fez uso de cigarros ou álcool");
                    
                    hm.setUsoCigarroAlcool(usoCigarroAlcool);
                    break;
                case 8:
                    praticaExercicios = selecionarSimNao("Pratica exercicios atualmente");
                    
                    hm.setPraticaExercicios(praticaExercicios);
                    break;
                case 0:
                    relatorioHistoricoMedico(hm);
                    salvar = selecionarSimNao("O histórico médico está dessa forma, deseja salvar");
                    
                    if(salvar == true){
                        System.out.println("Salvando histórico médico");
                    }else{
                        hm = null;
                        System.out.println("Saindo sem salvar");
                    }
                    System.out.println("Voltando para o menu principal");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;             
            }
        }while(opc != 0);
        
        return hm;
    }    
    public static void listarPacientes(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        System.out.println("============ Pacientes =============");
        for(Paciente p : gh.getCadastrados()){
            relatorioPaciente(p);
        }
        System.out.println("====================================");

    }
    public static void relatorioPaciente(Paciente p){
        if(p == null){
            System.out.println("Paciente ainda não foi criado");
            return;
        }
        System.out.println("============ Paciente =============");
        System.out.println(String.format("Nome: %s", p.getNome()));
        System.out.println(String.format("Idade: %d", p.getIdade()));
        System.out.println(String.format("Cpf: %s", p.getCPF()));
        
        System.out.print("Sexo: ");
        if(p.getSexo() == true){
            System.out.println("Masculino");
        }else{
            System.out.println("Feminino");
        }        
        System.out.println(String.format("Profissão: %s", p.getProfissao()));
        System.out.println(String.format("Endereço: %s", p.getEndereco()));
        System.out.println(String.format("Telefone: %s", p.getTelefone()));
        System.out.println(String.format("Peso: %.2f", p.getPeso()));
        System.out.println(String.format("Altura: %.2f", p.getAltura()));
        System.out.println(String.format("Tipo Sanguíneo: %s", p.getTipoSanguineo()));
        
        System.out.println("Histórico médico:");
        relatorioHistoricoMedico(p.getHistoricoMedico());

        System.out.println("====================================");

        
    }
    
    public static void relatorioHistoricoMedico(HistoricoMedico hm){
        if(hm == null){
            System.out.println("Histórico médico ainda não foi criado");
            return;
        }
             
        System.out.println("========= Histórico médico =========");
        
        System.out.println(String.format("Data de modificação: %s", hm.getData().toString()));
        System.out.println(String.format("Histórico familiar: %s", hm.getHistoricoFamiliar()));
        System.out.println(String.format("Histórico de medicamentos: %s", hm.getHistoricoMedicamentos()));
        System.out.println(String.format("Histórico de cirurgias: %s", hm.getHistoricoCirurgias()));
        System.out.println(String.format("Doenças prévias: %s", hm.getDoencasPrevias()));
        System.out.println(String.format("Doenças crônicas: %s", hm.getDoencasCronicas()));
        
        System.out.print("Já fez uso de medicamentos: ");
        if(hm.getUsoMedicamentos() == true){
            System.out.println("Sim");
        }else{
            System.out.println("Não");
        }
        
        System.out.print("Já fez uso de cigarros ou álcool: ");
        if(hm.getUsoCigarroAlcool()== true){
            System.out.println("Sim");
        }else{
            System.out.println("Não");
        }
        
        System.out.print("Pratica exercicios: ");
        if(hm.getPraticaExercicios()== true){
            System.out.println("Sim");
        }else{
            System.out.println("Não");
        }
        
        System.out.println("====================================");
    }
    
    public static boolean selecionarSimNao(String pergunta){
        int opc = 0;
        
        while(opc < 1 || opc > 2){
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print(String.format("%s (1 ou 2)? ", pergunta));
            opc = sc.nextInt();
            
            sc.nextLine();
        }
        
        if(opc == 1)
            return true;
        return false;
    }
    
    public static String selecionarTipoSanguineo(){
        int opc = 0;
        String[] tipos = {Constantes.A_MAIS, Constantes.A_MENOS, Constantes.B_MAIS, Constantes.B_MENOS,
                            Constantes.AB_MAIS, Constantes.AB_MENOS, Constantes.O_MAIS, Constantes.O_MENOS};
        
        while(opc < 1 || opc > 8){
            System.out.println(String.format("1 - %s", Constantes.A_MAIS));
            System.out.println(String.format("2 - %s", Constantes.A_MENOS));
            System.out.println(String.format("3 - %s", Constantes.B_MAIS));
            System.out.println(String.format("4 - %s", Constantes.B_MENOS));
            System.out.println(String.format("5 - %s", Constantes.AB_MAIS));
            System.out.println(String.format("6 - %s", Constantes.AB_MENOS));
            System.out.println(String.format("7 - %s", Constantes.O_MAIS));
            System.out.println(String.format("8 - %s", Constantes.O_MENOS));
            
            System.out.print("Escolha o tipo sanguíneo: ");
            opc = sc.nextInt();
            
            sc.nextLine();
        }
        opc--;
        return tipos[opc];
     }
    
    public static boolean selecionarSexo(){
        int opc = 0;
        
        while(opc < 1 || opc > 2){
            System.out.println("1 - Masculino");
            System.out.println("2 - Feminino");
            System.out.print("Escolha o sexo: ");
            opc = sc.nextInt();
        }
        
        if(opc == 1)
            return true;
        return false;
     }
    
    public static int selecionarPaciente(ArrayList<Paciente> pacientes){        
        int opc = 0;
        
        while(opc < 1 || opc > pacientes.size()){
            int cont = 1;
            for(Paciente p : pacientes){
                System.out.println(String.format("%d - %s", cont, p.getNome()));
                cont++;
            }
            System.out.print("\nDigite o número do paciente: ");
            opc = sc.nextInt();
        }
        
        opc--;
        return opc;
    }

    public static int selecionarMedico(ArrayList<Medico> medicos){
        int opc = 0;
        
        while(opc < 1 || opc > medicos.size()){
            int cont = 1;
            for(Medico m : medicos){
                System.out.println(String.format("%d - %s", cont, m.getNome()));
                cont++;
            }
            System.out.print("\nDigite o número do médico: ");
            opc = sc.nextInt();
        }
        
        opc--;
        return opc;
    }
        
    public static int selecionarDepartamento(ArrayList<Departamento> departamentos){
        int opc = 0;
        
        while(opc < 1 || opc > departamentos.size()){
            int cont = 1;
            for(Departamento d : departamentos){
                System.out.println(String.format("%d - %s", cont, d.getNome()));
                cont++;
            }
            System.out.print("\nDigite o número do departamento: ");
            opc = sc.nextInt();
        }
        
        opc--;
        return opc;
    }
    
    public static int selecionarMedicamento(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        int i = 1;
        for(ProdutoHospitalar p : gh.getEstoque()){
            if(p instanceof Medicamento){
                System.out.println(String.format("%d) %s", i, p.getNome()));
            }
        }
        
        return 0;
    }
    
    public static void relatorioConsulta(Consulta consulta){
        System.out.println("Médico responsável:");
        relatorioMedico(consulta.getMedico());
        System.out.println("Paciente da consulta:");
        relatorioPaciente(consulta.getPaciente());
        System.out.println("Receita medica:");
        relatorioReceita(consulta.getReceita());
    }
    
    public static void relatorioMedico(Medico medico){
        System.out.println("Nome: " + medico.getNome());
        System.out.println("CRM: " + medico.getCrm());
        System.out.println("Especialidade: " + medico.getEspecialidadeMedica());
        System.out.println("Salário: " + medico.getSalario());
    }
    
    public static void relatorioReceita(ReceitaMedica receita){
        System.out.println("Observações: " + receita.getObservacoes());
        System.out.println("Prescrições:");
        if(receita.getPrescricoes() != null){
            for(Prescricao p : receita.getPrescricoes()){
                relatorioPrescricao(p);
            }
        }else{
            System.out.println("Não existem prescrições cadastradas");
        }
    }
    
    public static void relatorioPrescricao(Prescricao prescricao){
        System.out.println("Medicamento:");
        relatorioMedicamento(prescricao.getMedicamento());
        System.out.println("Dosagem: " + prescricao.getDosagem());
        System.out.println("Instruções: " + prescricao.getInstrucoes());
    }
    
    public static void relatorioMedicamento(Medicamento medicamento){
        System.out.println("Nome: " + medicamento.getNome());
        System.out.println("Código: " + medicamento.getCodigo());
        System.out.println("Fabricante: " + medicamento.getFabricante());
    }
    
    public static void seed(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        Paciente p = new Paciente("jose", "cpf", 12, true, "jsdf", "kjadf", "lkjasdf", 12.21, 12.2, "asfdlk", null);
        Medico m = new Medico("crm", "especialidade", "vitor", 1000);
        
        gh.addPaciente(p);
    }
    
    public static void main(String[] args){
        seed();
        menuPrincipal();
    }
}
