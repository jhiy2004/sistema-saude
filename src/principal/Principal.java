package principal;

import modelo.*;
import controlador.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void menuPrincipal(){
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
    }
    
    public static void menuPaciente(){
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
        System.out.println("14 - Histórico médico");
        System.out.println("0 - Voltar para menu principal");
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
        System.out.println("========= Consulta =========");
        System.out.println("1 - Escolher paciente");
        System.out.println("2 - Escolher médico");
        System.out.println("3 - Criar receita");
        System.out.println("0 - Voltar para menu principal");
    }
    
    public static void menuReceita(Paciente p, Medico m){
        System.out.println("========= Receita médica =========");
        System.out.println("1 - Adicionar prescrições");
        System.out.println("2 - Observações");
        System.out.println("0 - Voltar para menu principal");
    }
    
    public static void menuPrecricao(){
        System.out.println("========= Precição =========");
        System.out.println("1 - Medicamento");
        System.out.println("2 - Dosagem");
        System.out.println("3 - Instruções");
        System.out.println("0 - Voltar para menu principal");
    }
    
    public static void menuExame(){
        System.out.println("========= Exame =========");
        System.out.println("1 - Escolher paciente");
        System.out.println("2 - Escolher médico");
        System.out.println("3 - Tipo exame");
        System.out.println("0 - Voltar para menu principal");
    }
    
    public static void menuHistoricoMedico(){
        System.out.println("========= Histórico médico =========");
        System.out.println("1 - Histórico familiar");
        System.out.println("2 - Histórico de medicamentos");
        System.out.println("3 - Doenças prévias");
        System.out.println("4 - Doenças crônicas");
        System.out.println("11 - Já fez uso de medicamentos?");
        System.out.println("12 - Já fez uso de cigarros ou álcool?");
        System.out.println("13 - Pratica exercícios?");
        System.out.println("0 - Voltar para menu principal");
    }
    public static int selecionarPaciente(ArrayList<Paciente> pacientes){
        Scanner sc = new Scanner(System.in);
          
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
        Scanner sc = new Scanner(System.in);
                  
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
        Scanner sc = new Scanner(System.in);
                  
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
    
    public static void seed(){
        GerenciaHospitalar gh = GerenciaHospitalar.getInstance();
        
        Paciente p = new Paciente("jose", "cpf", 12, true, "jsdf", "kjadf", "lkjasdf", 12.21, 12.2, "asfdlk", null);
        
        gh.addPaciente(p);
    }
    
    public static void main(String[] args){
        seed();
        selecionarPaciente(GerenciaHospitalar.getInstance().getCadastrados());
    }
}
