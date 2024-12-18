package principal;

import constantes.Constantes;
import modelo.*;
import controlador.*;
import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static Scanner sc = new Scanner(System.in);
    
    public static void menuPrincipal(){
        int opc;
        
        do{
            System.out.println("========= Principal =========");
            System.out.println("1 - Menu adicionar");
            System.out.println("2 - Menu remover");
            System.out.println("3 - Menu listar");
            System.out.println("4 - Menu relatório");
            System.out.println("5 - Menu internar");
            
            System.out.println("0 - Sair");
            
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();            
            
            sc.nextLine();
            
            switch(opc){
                case 1:
                    menuAdicionar();
                    break;
                
                case 2:
                    menuRemover();
                    break;
                    
                case 3:
                    menuListar();
                    break;
                
                case 4:
                    menuRelatorio();
                    break;
                    
                case 5:
                    menuInternar();
                    break;
                    
                case 0:
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opc != 0);
    }
    
    public static void menuAdicionar(){
        int opc;
        
        while(true){
            System.out.println("========= Adicionar =========");
            System.out.println("1 - Adicionar paciente");
            System.out.println("2 - Adicionar médico");
            System.out.println("3 - Adicionar exame");
            System.out.println("4 - Adicionar consulta");
            System.out.println("5 - Adicionar medicamento");
            
            System.out.println("0 - Voltar para o menu principal");
            
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();            
            
            sc.nextLine();
            
            switch(opc){
                case 1:
                    menuPaciente();
                    break;
                
                case 2:
                    menuMedico();
                    break;
                    
                case 3:
                    menuExame();
                    break;
                
                case 4:
                    menuConsulta();
                    break;
                    
                case 5:
                    menuMedicamento();
                    break;
                    
                case 0:
                    System.out.println("Voltando...");
                    return;
                    
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
    
    public static void menuRemover(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        int opc, indicePaciente, indiceMedico;
        ArrayList<Paciente> pacientes;
        ArrayList<Medico> medicos;
        Paciente paciente;
        Medicamento medicamento;
        
        
        
        while(true){
            System.out.println("========= Remover =========");
            System.out.println("1 - Remover paciente");
            System.out.println("2 - Remover médico");
            System.out.println("3 - Remover exame");
            System.out.println("4 - Remover consulta");
            System.out.println("5 - Remover medicamento");
            
            System.out.println("0 - Voltar para o menu principal");
            
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();            
            
            sc.nextLine();
            
            switch(opc){
                case 1:
                    pacientes = gh.getCadastrados();
                    indicePaciente = selecionarPaciente(pacientes);
                    if(indicePaciente != -1){
                        gh.removerPaciente(pacientes.get(indicePaciente));
                    }
                    break;
                    
                case 2:
                    medicos = gh.getMedicos();
                    indiceMedico = selecionarMedico(medicos);
                    if(indiceMedico != -1){
                        gh.removerMedico(medicos.get(indiceMedico));
                    }
                    break;
                         
                case 3:
                    Exame e = selecionarExame();
                    if(e != null){
                        paciente = gh.buscarPacienteCpf(e.getCpfPaciente());
                        paciente.removerExame(e);
                        gh.cancelarExame(e);
                    }
                    break;
                
                case 4:
                    Consulta c = selecionarConsulta();
                    if(c != null){
                        paciente = gh.buscarPacienteCpf(c.getCpfPaciente());
                        paciente.removerConsulta(c);
                        gh.cancelarConsulta(c);
                    }
                    break;
                    
                case 5:
                    medicamento = selecionarMedicamento();
                    if(medicamento != null){
                        gh.removerMedicamento(medicamento.getCodigo());
                    }
                    break;
                    
                case 0:
                    System.out.println("Voltando...");
                    return;
                    
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
    
    public static void menuListar(){
        int opc;
        
        while(true){
            System.out.println("========= Listar =========");
            System.out.println("1 - Listar pacientes");
            System.out.println("2 - Listar médicos");
            System.out.println("3 - Listar exames por médico");
            System.out.println("4 - Listar exames por paciente");
            System.out.println("5 - Listar consultas por médico");
            System.out.println("6 - Listar consultas por paciente");
            System.out.println("7 - Listar departamentos");
            
            System.out.println("0 - Voltar para o menu principal");
            
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();            
            
            sc.nextLine();
            
            switch(opc){
                case 1:
                    listarPacientes();
                    break;
                    
                case 2:
                    listarMedicos();
                    break;
                
                case 3:
                    listarExamesMedico();
                    break;
                    
                case 4:
                    listarExamesPaciente();
                    break;
                
                case 5:
                    listarConsultasMedico();
                    break;
                
                case 6:
                    listarConsultasPaciente();
                    break;
                    
                case 7:
                    listarDepartamentos();
                    break;
                    
                case 0:
                    System.out.println("Voltando...");
                    return;
                    
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
    
    public static void menuRelatorio(){
        int opc;
        
        while(true){
            System.out.println("========= Relatório =========");
            System.out.println("1 - Gerar relatório de estoque");
            System.out.println("2 - Gerar relatório de departamentos");
            
            System.out.println("0 - Voltar para o menu principal");
            
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();            
            
            sc.nextLine();
            
            switch(opc){
                case 1:
                    gerarRelatorioEstoque();
                    break;
                    
                case 2:
                    gerarRelatorioDepartamentos();
                    break;
                    
                case 0:
                    System.out.println("Voltando...");
                    return;
                    
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
    
    public static void menuInternar(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        int opc, indicePaciente;
        ArrayList<Paciente> pacientes;
        
        while(true){
            System.out.println("========= Internar =========");
            System.out.println("1 - Internar paciente");
            
            System.out.println("0 - Voltar para o menu internar");
            
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();            
            
            sc.nextLine();
            
            switch(opc){
                case 1:
                    pacientes = gh.getCadastrados();
                    indicePaciente = selecionarPaciente(pacientes);
                    if(indicePaciente != -1){
                        gh.internarPaciente(pacientes.get(indicePaciente));
                    }
                    break;
                    
                case 0:
                    System.out.println("Voltando...");
                    return;
                    
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
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
            System.out.println("0 - Voltar para o menu adicionar");
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
                    System.out.println("Digite o cpf do paciente (xxx.xxx.xxx-xx): ");
                    cpf = sc.nextLine();
                    
                    if(validarCpf(cpf)){
                        p.setCPF(cpf);
                    }else{
                        System.out.println("O cpf digitado está inválido");
                    }
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
                    System.out.println("Voltando para o menu principal");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opc != 0);
    }
    
    public static void menuMedico(){
        int opc = 0;
        boolean salvar = false;
        
        String crm = "";
        String especialidade = Constantes.CARDIOLOGIA;
        String nome = "";
        float salario = 0.0f;
        
        Medico m = new Medico(crm, especialidade, nome, salario);
        
        do{
            System.out.println("========= Medico =========");
            System.out.println("1 - Nome");
            System.out.println("2 - Crm");
            System.out.println("3 - Especialidade médica");
            System.out.println("4 - Salário");
            System.out.println("0 - Voltar para o menu adicionar");
            
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();
            
            sc.nextLine();
            
            switch(opc){
                case 1:
                    System.out.print("Digite o nome do médico: ");
                    nome = sc.nextLine();
                    
                    m.setNome(nome);
                    break;
                    
                case 2:
                    System.out.print("Digite o CRM do médico: ");
                    crm = sc.nextLine();
                    
                    m.setCrm(crm);
                    break;
                case 3:
                    especialidade = selecionarEspecialidade();
                    
                    m.setEspecialidadeMedica(especialidade);
                    break;
                case 4:
                    System.out.print("Digite o salário do médico: ");
                    salario = sc.nextFloat();
                    
                    m.setSalario(salario);
                    break;
                case 0:
                    relatorioMedico(m);
                    salvar = selecionarSimNao("O médico está dessa forma, deseja salvar");
                    
                    if(salvar == true){
                        System.out.println("Salvando médico");
                        
                        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();

                        gh.addMedico(m);
                    }else{
                        m = null;
                        System.out.println("Saindo sem salvar");
                    }
                    System.out.println("Voltando para o menu principal");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opc != 0);
    }
    
    public static void menuConsulta(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        int opc;
        Paciente paciente = null;
        Medico medico = null;
        ReceitaMedica receita = null;
        LocalDate data = null;
        LocalTime horario = null;
        
        while(true){
            System.out.println("========= Consulta =========");
            System.out.println("1 - Escolher paciente");
            System.out.println("2 - Escolher médico");
            System.out.println("3 - Criar receita");
            System.out.println("4 - Escolher data");
            System.out.println("5 - Escolher horário");
            System.out.println("0 - Voltar para o menu adicionar");
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();
            sc.nextLine();
            
            switch(opc){
                case 1:
                    ArrayList<Paciente> pacientes = gh.getCadastrados();
                    int pacienteIndex = selecionarPaciente(pacientes);
                    if(pacienteIndex != -1){
                        paciente = pacientes.get(pacienteIndex);
                    }
                    break;
                case 2:
                    ArrayList<Medico> medicos = gh.getMedicos();
                    int medicoIndex = selecionarMedico(medicos);
                    if(medicoIndex != -1){
                        medico = medicos.get(medicoIndex);
                    }
                    break;
                case 3:
                    if(paciente != null && medico != null && receita == null){
                        receita = menuReceita(paciente, medico);
                    }else{
                        System.out.println("Impossível criar a Receita");
                    }
                    break;
                case 4:
                    if(medico != null){
                        data = selecionarDataMedico(medico);
                    }else{
                        System.out.println("Selecione o médico antes!");
                    }
                    break;
                case 5:
                    if(data != null){
                        horario = selecionarHorarioMedico(medico, data);
                    }else{
                        System.out.println("Selecione a data antes!");
                    }
                    break;
                case 0:
                    if(medico != null && paciente != null && receita != null && data != null && horario != null){
                        Consulta consulta = new Consulta(medico.getEspecialidadeMedica(), medico.getCrm(), data, horario, paciente.getCPF(), receita);
                        medico.adicionarConsulta(consulta);
                        paciente.addConsulta(consulta);
                        
                        System.out.println("Dados da Consulta:");
                        relatorioConsulta(consulta);
                        
                        return;
                    }else{
                        if(medico == null){
                            System.out.println("Médico não preenchido");
                        }
                        if(paciente == null){
                            System.out.println("Paciente não preenchido");
                        }
                        if(receita == null){
                            System.out.println("Receita não preenchida");
                        }
                        if(data == null){
                            System.out.println("Data não preenchida");
                        }
                        if(horario == null){
                            System.out.println("Horário não preenchido");
                        }
                        if(selecionarSimNao("Consulta não criada por falta de informações, voltar sem salvar?")){
                            System.out.println("Voltando...");
                            return;
                        }
                    }
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }
        }
    }
    
    public static ReceitaMedica menuReceita(Paciente p, Medico m){
        ArrayList<Prescricao> prescricoes = null;
        String observacao = null;
        int opc;
        
        while(true){
            System.out.println("========= Receita médica =========");
            System.out.println("1 - Adicionar prescrições");
            System.out.println("2 - Observações");
            System.out.println("0 - Voltar para o menu adicionar");
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();
            sc.nextLine();
            
            switch(opc){
                case 1:
                    Prescricao prescricao = menuPrescricao();
                    if(prescricoes == null){
                        prescricoes = new ArrayList<>();
                    }
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
                        
                        return receita;
                    }else{
                        if(prescricoes == null){
                            System.out.println("Prescrições não preenchidas");
                        }
                        if(observacao == null){
                            System.out.println("Observação não preenchida");
                        }
                        if(selecionarSimNao("Receita não criada por falta de informações, voltar sem salvar?")){
                            System.out.println("Voltando...");
                            return null;
                        }
                    }
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
            }
        }
    }
    
    public static Prescricao menuPrescricao(){
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
            System.out.println("0 - Voltar para o menu adicionar");
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();
            sc.nextLine();
            
            switch(opc){
                case 1:
                    medicamento = selecionarMedicamento();
                   break;
                case 2:
                    System.out.print("Digite a dosagem: ");
                    dosagem = sc.nextLine();
                    break;
                case 3:
                    System.out.print("Digite as instruções: ");
                    instrucoes = sc.nextLine();
                    break;
                case 0:
                    if(medicamento != null && !instrucoes.isEmpty() && !dosagem.isEmpty()){
                        Prescricao prescricao = new Prescricao(medicamento, dosagem, instrucoes);
                        System.out.println("Dados da prescrição:");
                        relatorioPrescricao(prescricao);
                        return prescricao;
                    }else{
                        if(medicamento == null){
                            System.out.println("Medicamento não preenchido");
                        }
                        if(dosagem.isEmpty()){
                            System.out.println("Dosagem não preenchida");
                        }
                        if(instrucoes.isEmpty()){
                            System.out.println("Instruções não preenchidas");
                        }
                        if(selecionarSimNao("Prescrição não criada por falta de informações, voltar sem salvar?")){
                            System.out.println("Voltando...");
                            return null;
                        }
                    }
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
            }
        }
    }
    
    public static void menuMedicamento(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        String nome="", codigo="", fabricante="";
        LocalDate validade = null;
        int quantidade=0;
        int opc;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        while(true){
            System.out.println("========= Medicamento =========");
            System.out.println("1 - Nome");
            System.out.println("2 - Data validade");
            System.out.println("3 - Quantidade");
            System.out.println("4 - Fabricante");
            System.out.println("0 - Voltar para o menu adicionar");
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();
            sc.nextLine();
            
            switch(opc){
                case 1:
                    System.out.print("Digite o nome: ");
                    nome = sc.nextLine();
                    break;
                case 2:
                    System.out.print("Digite a data de validade (dd/MM/yyyy): ");
                    String dataValidade = sc.nextLine();
                    try {
                        validade = LocalDate.parse(dataValidade, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Data inválida. Por favor, use o formato dd/MM/yyyy.");
                    }
                case 3:
                    System.out.print("Digite a quantidade: ");
                    quantidade = sc.nextInt();
                    break;
                case 4:
                    System.out.print("Digite o fabricante: ");
                    fabricante = sc.nextLine();
                    break;
                case 0:
                    if(!nome.isEmpty() && !codigo.isEmpty() && validade != null && quantidade > 0 && !fabricante.isEmpty()){
                        codigo = UUID.randomUUID().toString();
                        Medicamento medicamento = new Medicamento(nome, codigo, validade, quantidade, fabricante);
                        
                        System.out.println("Dados do medicamento:");
                        relatorioMedicamento(medicamento);
                        
                        gh.addMedicamento(medicamento);
                        return;
                    }else{
                        if(nome.isEmpty()){
                            System.out.println("Nome não preenchido");
                        }
                        if(codigo.isEmpty()){
                            System.out.println("Código não preenchido");
                        }
                        if(validade == null){
                            System.out.println("Validade não preenchida");
                        }
                        if(quantidade <= 0){
                            System.out.println("Quantidade escolhida inválida");
                        }
                        if(fabricante.isEmpty()){
                            System.out.println("Fabricante não preenchido");
                        }
                        if(selecionarSimNao("Medicamento não criado por falta de informações, voltar sem salvar?")){
                            System.out.println("Voltando...");
                        }
                    }
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
            }
        }
    }
    
    public static void menuExame(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        int opc;
        Paciente paciente = null;
        Medico medico = null;
        String tipoExame = "";
        LocalDate data = null;
        LocalTime horario = null;
        
        while(true){
            System.out.println("========= Exame =========");
            System.out.println("1 - Escolher paciente");
            System.out.println("2 - Escolher médico");
            System.out.println("3 - Tipo exame");
            System.out.println("4 - Escolher data");
            System.out.println("5 - Escolher horário");
            System.out.println("0 - Voltar para o menu adicionar");
            System.out.print("Digite a opção: ");
            opc = sc.nextInt();
            sc.nextLine();
            
            switch(opc){
                case 1:
                    ArrayList<Paciente> pacientes = gh.getCadastrados();
                    int pacienteIndex = selecionarPaciente(pacientes);
                    if(pacienteIndex != -1){
                        paciente = pacientes.get(pacienteIndex);
                    }
                    break;
                case 2:
                    ArrayList<Medico> medicos = gh.getMedicos();
                    int medicoIndex = selecionarMedico(medicos);
                    if(medicoIndex != -1){
                        medico = medicos.get(medicoIndex);
                    }
                    break;
                case 3:
                    System.out.print("Digite o tipo de exame: ");
                    tipoExame = sc.nextLine();
                    break;
                case 4:
                    if(medico != null){
                        data = selecionarDataMedico(medico);
                    }else{
                        System.out.println("Selecione o médico antes!");
                    }
                    break;
                case 5:
                    if(data != null){
                        horario = selecionarHorarioMedico(medico, data);
                    }else{
                        System.out.println("Selecione a data antes!");
                    }
                    break;
                case 0:
                    if(!tipoExame.isEmpty() && paciente != null && medico != null && data != null && horario != null){
                        Exame exame = new Exame(tipoExame, medico.getCrm(), data, horario, paciente.getCPF());
                        medico.adicionarExame(exame);
                        paciente.addExame(exame);
                        
                        System.out.println("Dados do Exame:");
                        relatorioExame(exame);
                        
                        return;
                    }else{
                        if(tipoExame.isEmpty()){
                            System.out.println("Tipo exame não preenchido");
                        }
                        if(paciente == null){
                            System.out.println("Paciente não selecionado");
                        }
                        if(medico == null){
                            System.out.println("Médico não selecionado");
                        }
                        if(data == null){
                            System.out.println("Data não preenchida");
                        }
                        if(horario == null){
                            System.out.println("Horário não preenchido");
                        }
                        if(selecionarSimNao("Exame não criado por falta de informações, voltar sem salvar?")){
                            System.out.println("Voltando...");
                            return;
                        }
                    }
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
            }
        }
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
            System.out.println("0 - Voltar para o menu adicionar");
    
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
    
    public static void listarDepartamentos(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        System.out.println("========== Departamentos ===========");
        for(Departamento d : gh.getDepartamentos()){
            relatorioDepartamento(d);
        }
        System.out.println("====================================");

    }
    
    public static void listarMedicos(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        System.out.println("============= Medicos ==============");
        for(Medico m : gh.getMedicos()){
            relatorioMedico(m);
        }
        System.out.println("====================================");

    }
    
    public static void listarPacientes(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        System.out.println("============ Pacientes =============");
        for(Paciente p : gh.getCadastrados()){
            relatorioPaciente(p);
        }
        System.out.println("====================================");

    }
    
    public static void listarExamesMedico(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        System.out.println("======= Exames por médicos =======");
        for(Medico m : gh.getMedicos()){
            System.out.println("=====================\n");
            System.out.println("Nome do médico: " + m.getNome());
            System.out.println("CRM: " + m.getCrm());
            Agenda a = m.getAgenda();
            List<Exame> examesAgendados = a.getTodosExamesAgendados();
            
            if(!examesAgendados.isEmpty()){
                for(Exame e : examesAgendados){
                    relatorioExame(e);
                }
            }else{
                System.out.println("Não possui exames agendados!");
            }
            System.out.println("\n=====================\n");
        }
        System.out.println("=====================================");
    }
    
    public static void listarExamesPaciente(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        System.out.println("======= Exames por pacientes =======");
        for(Paciente p : gh.getCadastrados()){
            System.out.println("=====================\n");
            System.out.println("Nome do paciente: " + p.getNome());
            List<Exame> examesAgendados = p.getExames();
            
            if(!examesAgendados.isEmpty()){
                for(Exame e : examesAgendados){
                    relatorioExame(e);
                }
            }else{
                System.out.println("Não possui exames agendados!");
            }
            System.out.println("\n=====================\n");
        }
        System.out.println("=====================================");
    }
    
    public static void listarConsultasMedico(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        System.out.println("======= Consultas por médicos =======");
        for(Medico m : gh.getMedicos()){
            System.out.println("=====================\n");
            System.out.println("Nome do médico: " + m.getNome());
            System.out.println("CRM: " + m.getCrm());
            Agenda a = m.getAgenda();
            List<Consulta> consultasAgendadas = a.getTodasConsultasAgendadas();
            
            if(!consultasAgendadas.isEmpty()){
                for(Consulta c : consultasAgendadas){
                    relatorioConsulta(c);
                }
            }else{
                System.out.println("Não possui consultas agendadas!");
            }
            System.out.println("\n=====================\n");
        }
        System.out.println("=====================================");
    }
    
    public static void listarConsultasPaciente(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        System.out.println("======= Consultas por pacientes =======");
        for(Paciente p : gh.getCadastrados()){
            System.out.println("=====================\n");
            System.out.println("Nome do paciente: " + p.getNome());
            List<Consulta> consultasAgendadas = p.getConsultas();
            
            if(!consultasAgendadas.isEmpty()){
                for(Consulta c : consultasAgendadas){
                    relatorioConsulta(c);
                }
            }else{
                System.out.println("Não possui consultas agendadas!");
            }
            System.out.println("\n=====================\n");
        }
        System.out.println("=====================================");
    }
    
    public static void relatorioExame(Exame exame){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        Medico medico = gh.buscarMedicoCrm(exame.getCrmMedico());
        Paciente paciente = gh.buscarPacienteCpf(exame.getCpfPaciente());
        
        System.out.println("Médico responsável:");
        relatorioMedico(medico);
        System.out.println("Paciente do exame:");
        relatorioPaciente(paciente);
        System.out.println("Tipo de exame:");
        System.out.println(exame.getTipoExame());
        System.out.println("Data do exame:");
        System.out.println(exame.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Horário do exame:");
        System.out.println(exame.getHorario().format(DateTimeFormatter.ofPattern("HH:mm")));
    }
    
    public static void relatorioConsulta(Consulta consulta){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        Medico medico = gh.buscarMedicoCrm(consulta.getCrmMedico());
        Paciente paciente = gh.buscarPacienteCpf(consulta.getCpfPaciente());
        
        System.out.println("Médico responsável:");
        relatorioMedico(medico);
        System.out.println("Paciente da consulta:");
        relatorioPaciente(paciente);
        System.out.println("Receita medica:");
        relatorioReceita(consulta.getReceita());
        System.out.println("Data da consulta:");
        System.out.println(consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Horário da consulta:");
        System.out.println(consulta.getHorario().format(DateTimeFormatter.ofPattern("HH:mm")));
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
    
    public static void relatorioDepartamento(Departamento d){
        if(d == null){
            System.out.println("Departamento ainda não foi criado");
            return;
        }
             
        System.out.println("============== Departamento ==============");
        
        System.out.println(String.format("Nome: %s", d.getNome()));
        System.out.println(String.format("Cod: %s", d.getCod()));
        System.out.println("Médicos:");
        System.out.println("============= Medicos ==============");
        for(Medico m : d.getMedicos()){
            relatorioMedico(m);
        }
        System.out.println("====================================");
    }
    
    public static void relatorioMedico(Medico m){
        if(m == null){
            System.out.println("Médico ainda não foi criado");
            return;
        }
             
        System.out.println("============== Médico ==============");
        
        System.out.println(String.format("Nome: %s", m.getNome()));
        System.out.println(String.format("Especialidade médica: %s", m.getEspecialidadeMedica()));
        System.out.println(String.format("CRM: %s", m.getCrm()));
        System.out.println(String.format("Salário: %.2f", m.getSalario()));
        
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
        System.out.println(String.format("Peso: %.2f kg", p.getPeso()));
        System.out.println(String.format("Altura: %.2f m", p.getAltura()));
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

    public static void gerarRelatorioEstoque(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        RelatorioMedicamentos relatorio = new RelatorioMedicamentos();
        
        relatorio.exibirRelatorio(gh.getHospital());
    }
    
    public static void gerarRelatorioDepartamentos(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        RelatorioDepartamentos relatorio = new RelatorioDepartamentos();
        
        relatorio.exibirRelatorio(gh.getHospital());
    }
    
    public static Medicamento selecionarMedicamento(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        ArrayList<Medicamento> medicamentos = gh.getEstoque();
        
        if (medicamentos == null || medicamentos.isEmpty()) {
            System.out.println("Nenhum medicamento encontrado.");
            return null;
        }
        
        int i = 1;
        for(Medicamento m : medicamentos){
            System.out.println(String.format("%d) %s", i, m.getNome()));
            i++;
        }
        System.out.print("Digite o número do medicamento desejado: ");
        i = sc.nextInt();
        i--;
        Medicamento medicamento = medicamentos.get(i);
        
        return medicamento;
    }
    
    public static Consulta selecionarConsulta(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        ArrayList<Medico> medicos = gh.getMedicos();
        int indiceMedico = selecionarMedico(gh.getMedicos());
        if(indiceMedico == -1){
            System.out.println("Nenhum médico encontrado");
            return null;
        }
        Medico m = medicos.get(indiceMedico);
        Agenda a = m.getAgenda();
        List<Consulta> consultas = a.getTodasConsultasAgendadas();
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        
        if (consultas == null || consultas.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada.");
            return null;
        }
        
        int i=1;
        for(Consulta c : consultas){
            System.out.println(String.format("%d) Data: %s Horário: %s", 
            i, 
            c.getData().format(dateFormatter), 
            c.getHorario().format(timeFormatter)));
            i++;
        }
        System.out.print("Digite o número da consulta desejada: ");
        i = sc.nextInt();
        i--;
        
        return consultas.get(i);
    }
    
    public static Exame selecionarExame(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        ArrayList<Medico> medicos = gh.getMedicos();
        int indiceMedico = selecionarMedico(gh.getMedicos());
        if(indiceMedico == -1){
            System.out.println("Nenhum médico encontrado");
            return null;
        }
        Medico m = medicos.get(indiceMedico);
        Agenda a = m.getAgenda();
        List<Exame> exames = a.getTodosExamesAgendados();
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        
        if (exames == null || exames.isEmpty()) {
            System.out.println("Nenhum exame encontrado.");
            return null;
        }
        
        int i=1;
        for(Exame e : exames){
            System.out.println(String.format("%d) Data: %s Horário: %s", 
            i, 
            e.getData().format(dateFormatter), 
            e.getHorario().format(timeFormatter)));
            i++;
        }
        System.out.print("Digite o número do exame desejado: ");
        i = sc.nextInt();
        i--;
        
        return exames.get(i);
    }
    
    public static LocalDate selecionarDataMedico(Medico medico){
        Agenda agenda = medico.getAgenda();
        LocalDate data;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        while(true){
            System.out.print("Digite a data desejada (dd/MM/yyyy): ");
            String dataStr = sc.nextLine();
            
            try {
                data = LocalDate.parse(dataStr, formatter);
                List<LocalTime> horariosDisponiveis = agenda.getHorariosDisponiveis(data);
                
                if(horariosDisponiveis.isEmpty()){
                    System.out.println("Não há horários disponíveis para essa data. Tente outra.");
                }else{
                    return data;
                }
                
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Por favor, use o formato dd/MM/yyyy.");
            }
        }
    }
    
    public static LocalTime selecionarHorarioMedico(Medico medico, LocalDate data){
        Agenda agenda = medico.getAgenda();
        List<LocalTime> horariosDisponiveis = agenda.getHorariosDisponiveis(data);
        int opc;
        
        if (horariosDisponiveis.isEmpty()) {
            System.out.println("Não há horários disponíveis para esta data.");
            return null;
        }
        
        System.out.println("Horários disponíveis para " + data + ":");
        for (int i = 0; i < horariosDisponiveis.size(); i++) {
            System.out.println((i + 1) + ") " + horariosDisponiveis.get(i));
        }
        
        System.out.print("Selecione um horário pelo número: ");
        opc = sc.nextInt();
        
        if (opc < 1 || opc > horariosDisponiveis.size()) {
            System.out.println("Opção inválida.");
            return null;
        }
        
        return horariosDisponiveis.get(opc - 1);
    }
        
    public static boolean validarCpf(String cpf){
        String limpo = cpf.replaceAll("[.|-]", "");
        
        return VerificadorCPF.isCPF(limpo);     
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
        
        while(opc < 1 || opc > tipos.length){
            for(int cont=1; cont < tipos.length; cont++){
                int pos = cont - 1;
                System.out.println(String.format("%d - %s", cont, tipos[pos]));
            }
            
            System.out.print("Escolha o tipo sanguíneo: ");
            opc = sc.nextInt();
            
            sc.nextLine();
        }
        opc--;
        return tipos[opc];
    }
    
    public static String selecionarEspecialidade(){
        int opc = 0;
        String[] especialidades = {Constantes.CARDIOLOGIA, Constantes.DERMATOLOGIA, Constantes.ENDOCRINOLOGIA, Constantes.GASTROENTEROLOGIA,
                            Constantes.GERIATRIA, Constantes.GINECOLOGIA, Constantes.NEUROLOGIA, Constantes.OFTALMOLOGIA, Constantes.ORTOPEDIA,
                            Constantes.PEDIATRIA, Constantes.PSIQUIATRIA, Constantes.UROLOGIA};
        
        while(opc < 1 || opc > especialidades.length){
            for(int cont=1; cont < especialidades.length; cont++){
                int pos = cont - 1;
                System.out.println(String.format("%d - %s", cont, especialidades[pos]));
            }
            
            System.out.print("Escolha a especialidade médica: ");
            opc = sc.nextInt();
            
            sc.nextLine();
        }
        opc--;
        return especialidades[opc];
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
        
        if(pacientes == null || pacientes.isEmpty()){
            System.out.println("Nenhum paciente encontrado");
            return -1;
        }
        
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
        
        if(medicos == null || medicos.isEmpty()){
            System.out.println("Nenhum médico encontrado");
            return -1;
        }
        
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
    
    public static void seed(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        HistoricoMedico h1 = new HistoricoMedico(
            "Diabetes na família",
            "Nenhum medicamento em uso",
            "Apendicectomia em 2015",
            "Nenhuma doença prévia",
            "Hipertensão",
            false,
            false,
            true
        );
        Paciente p1 = new Paciente(
            "Carlos Silva",
            "123.456.789-00",
            34,
            true,
            "Engenheiro",
            "Rua das Palmeiras, 123",
            "(11) 98765-4321",
            78.5,
            1.75,
            Constantes.O_MAIS,
            h1
        );
        // Paciente 2
        HistoricoMedico h2 = new HistoricoMedico(
            "Histórico familiar limpo",
            "Anti-inflamatórios esporádicos",
            "Cirurgia no joelho em 2020",
            "Varicela na infância",
            "Nenhuma doença crônica",
            false,
            true,
            false
        );
        Paciente p2 = new Paciente(
            "Ana Maria Oliveira",
            "987.654.321-00",
            28,
            false,
            "Professora",
            "Avenida Central, 456",
            "(21) 99876-5432",
            62.0,
            1.65,
            Constantes.A_MAIS,
            h2
        );
        // Paciente 3
        HistoricoMedico h3 = new HistoricoMedico(
            "Câncer de mama na família",
            "Pílula anticoncepcional",
            "Nenhuma cirurgia",
            "Bronquite na infância",
            "Nenhuma doença crônica",
            true,
            false,
            true
        );
        Paciente p3 = new Paciente(
            "Beatriz Santos",
            "321.654.987-00",
            42,
            false,
            "Designer",
            "Rua do Sol, 789",
            "(31) 91234-5678",
            70.0,
            1.60,
            Constantes.B_MAIS,
            h3
        );
        // Paciente 4
        HistoricoMedico h4 = new HistoricoMedico(
            "Histórico familiar limpo",
            "Antiácidos e vitaminas",
            "Cirurgia de hérnia em 2018",
            "Nenhuma doença prévia",
            "Diabetes tipo 2",
            true,
            false,
            true
        );
        Paciente p4 = new Paciente(
            "João Pedro Almeida",
            "456.789.123-00",
            50,
            true,
            "Advogado",
            "Travessa dos Pioneiros, 890",
            "(41) 92345-6789",
            85.0,
            1.80,
            Constantes.AB_MENOS,
            h4
        );
        // Paciente 5
        HistoricoMedico h5 = new HistoricoMedico(
            "Histórico de doenças cardíacas na família",
            "Analgésicos esporádicos",
            "Cirurgia cardíaca em 2010",
            "Hipertensão",
            "Cardiopatia",
            true,
            true,
            false
        );
        Paciente p5 = new Paciente(
            "Miguel Costa",
            "654.321.987-00",
            60,
            true,
            "Aposentado",
            "Praça das Rosas, 321",
            "(61) 98765-1234",
            90.0,
            1.70,
            Constantes.O_MENOS,
            h5
        );
        
        gh.addPaciente(p1);
        gh.addPaciente(p2);
        gh.addPaciente(p3);
        gh.addPaciente(p4);
        gh.addPaciente(p5);
        
        // Criação dos médicos, um para cada especialidade
        Medico[] medicos = {
            new Medico("CRM/SP 123456", Constantes.CARDIOLOGIA, "Dr. Carlos Cardio", 20000.0f),
            new Medico("CRM/RJ 234567", Constantes.DERMATOLOGIA, "Dra. Daniela Derma", 18000.0f),
            new Medico("CRM/MG 345678", Constantes.ENDOCRINOLOGIA, "Dr. Eduardo Endócrino", 19000.0f),
            new Medico("CRM/RS 456789", Constantes.GASTROENTEROLOGIA, "Dr. Gustavo Gastro", 21000.0f),
            new Medico("CRM/BA 567890", Constantes.GERIATRIA, "Dra. Gabriela Geriatria", 17000.0f),
            new Medico("CRM/PR 678901", Constantes.GINECOLOGIA, "Dra. Giovana Gineco", 18500.0f),
            new Medico("CRM/SC 789012", Constantes.NEUROLOGIA, "Dr. Nelson Neuro", 22000.0f),
            new Medico("CRM/PE 890123", Constantes.OFTALMOLOGIA, "Dra. Olivia Oftalmo", 19000.0f),
            new Medico("CRM/DF 901234", Constantes.ORTOPEDIA, "Dr. Otávio Ortopedia", 20000.0f),
            new Medico("CRM/GO 012345", Constantes.PEDIATRIA, "Dra. Paula Pediatria", 18500.0f),
            new Medico("CRM/CE 112233", Constantes.PSIQUIATRIA, "Dr. Pedro Psiquiatria", 21000.0f),
            new Medico("CRM/AM 223344", Constantes.UROLOGIA, "Dr. Ubirajara Urologia", 19500.0f),
        };
        
        for(Medico m : medicos){
            gh.addMedico(m);
        }
        
        Medicamento[] medicamentos = {
            new Medicamento("Paracetamol", UUID.randomUUID().toString(), LocalDate.of(2025, 5, 10), 50, "Farmacêutica ABC"),
            new Medicamento("Ibuprofeno", UUID.randomUUID().toString(), LocalDate.of(2026, 3, 15), 30, "Laboratório XYZ"),
            new Medicamento("Amoxicilina", UUID.randomUUID().toString(), LocalDate.of(2024, 11, 20), 100, "Químicos Nacionais"),
            new Medicamento("Cetoconazol", UUID.randomUUID().toString(), LocalDate.of(2025, 7, 1), 70, "Medicamentos Beta"),
            new Medicamento("Captopril", UUID.randomUUID().toString(), LocalDate.of(2025, 2, 8), 40, "Saúde Farma"),
            new Medicamento("Dipirona", UUID.randomUUID().toString(), LocalDate.of(2024, 12, 5), 90, "Farmacêutica ABC"),
            new Medicamento("Aspirina", UUID.randomUUID().toString(), LocalDate.of(2026, 1, 18), 60, "Laboratório XYZ"),
            new Medicamento("Metformina", UUID.randomUUID().toString(), LocalDate.of(2025, 6, 22), 120, "Químicos Nacionais"),
            new Medicamento("Omeprazol", UUID.randomUUID().toString(), LocalDate.of(2025, 9, 11), 80, "Medicamentos Beta"),
            new Medicamento("Losartana", UUID.randomUUID().toString(), LocalDate.of(2025, 4, 25), 110, "Saúde Farma"),
            new Medicamento("Levotiroxina", UUID.randomUUID().toString(), LocalDate.of(2026, 2, 3), 50, "Farmacêutica ABC"),
            new Medicamento("Atorvastatina", UUID.randomUUID().toString(), LocalDate.of(2024, 10, 27), 35, "Laboratório XYZ"),
            new Medicamento("Simvastatina", UUID.randomUUID().toString(), LocalDate.of(2025, 8, 30), 95, "Químicos Nacionais"),
            new Medicamento("Furosemida", UUID.randomUUID().toString(), LocalDate.of(2026, 7, 10), 45, "Medicamentos Beta"),
            new Medicamento("Cloridrato de Sertralina", UUID.randomUUID().toString(), LocalDate.of(2024, 12, 19), 85, "Saúde Farma"),
            new Medicamento("Cloridrato de Fluoxetina", UUID.randomUUID().toString(), LocalDate.of(2025, 1, 12), 25, "Farmacêutica ABC"),
            new Medicamento("Lorazepam", UUID.randomUUID().toString(), LocalDate.of(2025, 3, 9), 75, "Laboratório XYZ"),
            new Medicamento("Ranitidina", UUID.randomUUID().toString(), LocalDate.of(2025, 5, 18), 95, "Químicos Nacionais"),
            new Medicamento("Bromoprida", UUID.randomUUID().toString(), LocalDate.of(2025, 10, 5), 65, "Medicamentos Beta"),
            new Medicamento("Azitromicina", UUID.randomUUID().toString(), LocalDate.of(2026, 4, 21), 55, "Saúde Farma"),
            new Medicamento("Ciclosporina", UUID.randomUUID().toString(), LocalDate.of(2025, 11, 15), 105, "Farmacêutica ABC"),
            new Medicamento("Prednisona", UUID.randomUUID().toString(), LocalDate.of(2024, 9, 30), 90, "Laboratório XYZ"),
            new Medicamento("Hidroxicloroquina", UUID.randomUUID().toString(), LocalDate.of(2025, 2, 20), 60, "Químicos Nacionais"),
            new Medicamento("Alprazolam", UUID.randomUUID().toString(), LocalDate.of(2025, 8, 25), 35, "Medicamentos Beta"),
            new Medicamento("Carbamazepina", UUID.randomUUID().toString(), LocalDate.of(2025, 3, 14), 75, "Saúde Farma"),
            new Medicamento("Lamotrigina", UUID.randomUUID().toString(), LocalDate.of(2026, 6, 17), 95, "Farmacêutica ABC"),
            new Medicamento("Valproato de Sódio", UUID.randomUUID().toString(), LocalDate.of(2025, 12, 29), 50, "Laboratório XYZ"),
            new Medicamento("Clonazepam", UUID.randomUUID().toString(), LocalDate.of(2026, 8, 13), 85, "Químicos Nacionais"),
            new Medicamento("Midazolam", UUID.randomUUID().toString(), LocalDate.of(2024, 11, 22), 45, "Medicamentos Beta"),
            new Medicamento("Diazepam", UUID.randomUUID().toString(), LocalDate.of(2025, 7, 7), 70, "Saúde Farma")
        };
        
        for(Medicamento m : medicamentos){
            gh.addMedicamento(m);
        }
        
    }
    
    public static void main(String[] args){
        seed();
        menuPrincipal();
    }
}
