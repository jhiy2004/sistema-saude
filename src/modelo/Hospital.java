package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um hospital com departamentos, estoque de medicamentos e pacientes na emergência.
 */

public class Hospital {
    private String nome;
    private ArrayList<Departamento> departamentos;// C. metodo que mostre os  de medicos de todos os departamentos I.TOtal.
    // conferir as especialidades;
    private Paciente emergencia[]; // pacientes na emergencia, verificar se há vagas nela
    // C. um Diretor para poder acessar o sistema (talvez). diretor herda medico;
    private int limiteEmergencia;
    private int contPacientesEmergencia;
    private EstoqueMedicamentos estoque;

    /**
     * Construtor que inicializa o hospital com um nome e um limite de pacientes na emergência.
     *
     * @param nome O nome do hospital.
     * @param limiteEmergencia O limite de pacientes que podem ser internados na emergência.
     */

    public Hospital(String nome, int limiteEmergencia){
        this.nome = nome;
        this.limiteEmergencia = limiteEmergencia;
        this.departamentos = new ArrayList<>();
        this.emergencia = new Paciente[limiteEmergencia];
        this.contPacientesEmergencia = 0;
        this.estoque = new EstoqueMedicamentos();
    }
    /**
     * Retorna a lista de departamentos do hospital.
     *
     * @return Uma lista de departamentos.
     */
    public ArrayList<Departamento> getDepartamentos() {
        return this.departamentos;
    }
    /**
     * Retorna a quantidade de departamentos no hospital.
     *
     * @return O número de departamentos.
     */
    public int getContDepartamentos() {
        return this.departamentos.size();
    }
    /**
     * Retorna a quantidade de pacientes internados na emergência.
     *
     * @return O número de pacientes na emergência.
     */
    public int getContPacientesEmergencia() {
        return this.contPacientesEmergencia;
    }


    /**
     * Define o nome do hospital.
     *
     * @param nome O nome do hospital.
     */

    public void setNomeHospital(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome do hospital.
     *
     * @return O nome do hospital.
     */
    public String getNomeHospital() {
        return nome;
    }
    /**
     * Retorna o limite de pacientes que podem ser atendidos na emergência.
     *
     * @return O limite de pacientes na emergência.
     */
    public int getLimiteEmergencia(){
        return this.limiteEmergencia;
    }
    /**
     * Define o limite de pacientes para a emergência.
     *
     * @param limiteEmergencia O novo limite de pacientes na emergência.
     */

    public void setLimiteEmergencia(int limiteEmergencia){
        this.limiteEmergencia = limiteEmergencia;
    }
    
    /**
     * Retorna uma lista de todos os médicos do hospital.
     *
     * @return Uma lista de médicos.
     */
    public ArrayList<Medico> getMedicos(){
        ArrayList<Medico> medicos = new ArrayList<>();
        
        for(Departamento d : departamentos){
            medicos.addAll(d.getMedicos());
        }
        
        return medicos;
    }
    /**
     * Remove um médico do departamento correspondente.
     *
     * @param m O médico a ser removido.
     */
    public void removerMed(Medico m){
        for(Departamento d : this.departamentos){
            if(d.getCod().equals(m.getEspecialidadeMedica())){
                d.removerMed(m);
                return;
            }
        }  
    }
    /**
     * Adiciona um médico ao departamento correspondente ou cria um novo departamento.
     *
     * @param m O médico a ser adicionado.
     */
    public void addMed(Medico m){
        for(Departamento d : this.departamentos){
            if(d.getCod().equals(m.getEspecialidadeMedica())){
                d.addMed(m);
                return;
            }
        }    
        
        Departamento novo = new Departamento();
        novo.setNome("Departamento de "+m.getEspecialidadeMedica());
        novo.setCod(m.getEspecialidadeMedica());
        novo.addMed(m);

        this.departamentos.add(novo);
    }
    /**
     * Interna um paciente na emergência, se houver vaga disponível.
     *
     * @param p O paciente a ser internado.
     * @return {@code true} se o paciente foi internado com sucesso, {@code false} caso contrário.
     */
    public boolean internar(Paciente p){
        if(this.contPacientesEmergencia < this.limiteEmergencia){
            this.emergencia[this.contPacientesEmergencia] = p;
            this.contPacientesEmergencia++;
            return true;
        }
        return false;
    }
    /**
     * Adiciona um medicamento ao estoque do hospital.
     *
     * @param m O medicamento a ser adicionado ao estoque.
     */
    public void adicionarMedicamento(Medicamento m){
        estoque.adicionarMedicamento(m);
    }
    
    /**
     * Remove um medicamento do estoque do hospital, baseado no nome.
     *
     * @param nome O nome do medicamento a ser removido.
     */
    public void removerMedicamento(String nome){
        estoque.removerMedicamento(nome);
    }
    /**
     * Retorna a lista de medicamentos disponíveis no estoque do hospital.
     *
     * @return Uma lista de medicamentos.
     */
    public ArrayList<Medicamento> getEstoque(){
        return estoque.getMedicamentos();
    }
}
