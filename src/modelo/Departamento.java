/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author danie
 *
 * Representa um departamento em uma instituição de saúde.
 * Cada departamento possui um código único que representa a especialidade medica
 * ,um nome e uma lista de médicos associados.
 */
public class Departamento {

    private String cod; // Código da especialidade
    private String nome;
    private ArrayList<Medico> medicos;

    /**
     * Construtor que inicializa o departamento com código e nome específicos.
     *
     * @param cod  Código do departamento.
     * @param nome Nome do departamento.
     */
    public Departamento(String cod, String nome) {
        this.cod = cod;
        this.nome = nome;
        this.medicos = new ArrayList<>();
    }

    /**
     * Construtor vazio
     */
    public Departamento() {
        this.medicos = new ArrayList<>();
    }

    /**
     * Remove um médico do departamento.
     *
     * @param m O médico a ser removido.
     */
    public void removerMed(Medico m) {
        this.medicos.remove(m);
    }

    /**
     * Busca um médico no departamento com base no CRM.
     *
     * @param crm CRM do médico a ser buscado.
     * @return O médico correspondente, ou {@code null} se não encontrado.
     */
    public Medico buscarMedCrm(String crm) {
        for (Medico m : this.medicos) {
            if (m.getCrm().equals(crm)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Busca um médico no departamento com base no nome.
     *
     * @param nome Nome do médico a ser buscado.
     * @return O médico correspondente, ou {@code null} se não encontrado.
     */
    public Medico buscarMedNome(String nome) {
        for (Medico m : this.medicos) {
            if (m.getNome().equals(nome)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Adiciona um médico ao departamento.
     *
     * @param house O médico a ser adicionado.
     */
    public void addMed(Medico house) {
        this.medicos.add(house);
    }

    /**
     * Retorna o número total de médicos no departamento.
     *
     * @return A quantidade de médicos.
     */
    public int getContMedicos() {
        return this.medicos.size();
    }

    /**
     * Busca um médico no departamento com base no nome.
     * 
     * @param nome Nome do médico a ser buscado.
     * @return O médico correspondente, ou {@code null} se não encontrado.
     */
    public Medico buscarMedicoN(String nome) {
        for (Medico m : this.medicos) {
            if (m.getNome().equals(nome)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Busca um médico no departamento com base no CRM.
     *
     * @param crm CRM do médico a ser buscado.
     * @return O médico correspondente, ou {@code null} se não encontrado.
     */
    public Medico buscarMedicoCrm(String crm) {
        for (Medico m : this.medicos) {
            if (m.getCrm().equals(crm)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Calcula o total dos salários de todos os médicos no departamento.
     *
     * @return O valor total dos salários.
     */
    public double totalSalariosM() {
        double total = 0;
        for (Medico m : this.medicos) {
            total += m.getSalario();
        }
        return total;
    }

    /**
     * Obtém o código do departamento.
     *
     * @return O código do departamento.
     */
    public String getCod() {
        return cod;
    }

    /**
     * Define o código do departamento.
     *
     * @param cod O novo código do departamento.
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * Obtém o nome do departamento.
     *
     * @return O nome do departamento.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do departamento.
     *
     * @param nome O novo nome do departamento.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a lista de médicos associados ao departamento.
     *
     * @return A lista de médicos.
     */
    public ArrayList<Medico> getMedicos() {
        return this.medicos;
    }
}

