package modelo;

import java.util.ArrayList;
/**
 * Representa um paciente com informações pessoais, histórico médico, consultas e exames realizados.
 */
public class Paciente{
	private String nome;
        private String CPF;
	private int idade;
	private boolean sexo; // true -> masculino; false -> feminino
	private String profissao;
	private String endereco;
	private String telefone;
	private double peso;
	private double altura;
	private String tipoSanguineo;


	private ArrayList<Consulta> consultas;
	private ArrayList<Exame> exames;
	private HistoricoMedico historicoMedico;
	/**
     * Construtor para criar um paciente com as informações fornecidas.
     *
     * @param nome O nome do paciente.
     * @param CPF O CPF do paciente.
     * @param idade A idade do paciente.
     * @param sexo O sexo do paciente (true -> masculino; false -> feminino).
     * @param profissao A profissão do paciente.
     * @param endereco O endereço do paciente.
     * @param telefone O telefone de contato do paciente.
     * @param peso O peso do paciente.
     * @param altura A altura do paciente.
     * @param tipoSanguineo O tipo sanguíneo do paciente.
     * @param historicoMedico O histórico médico do paciente.
     */
	public Paciente(String nome, String CPF,int idade, boolean sexo, String profissao, String endereco, String telefone,
					double peso, double altura, String tipoSanguineo, HistoricoMedico historicoMedico){
		this.nome = nome;
		this.idade = idade;
                this.CPF = CPF;
		this.sexo = sexo;
		this.profissao = profissao;
		this.endereco = endereco;
		this.telefone = telefone;
		this.peso = peso;
		this.altura = altura;
		this.tipoSanguineo = tipoSanguineo;
                this.historicoMedico = historicoMedico;

		this.consultas = new ArrayList<>();
		this.exames = new ArrayList<>();
	}
/**
     * Retorna o nome do paciente.
     *
     * @return O nome do paciente.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Retorna o CPF do paciente.
     *
     * @return O CPF do paciente.
     */
    public String getCPF() {
        return this.CPF;
    }

    /**
     * Retorna a idade do paciente.
     *
     * @return A idade do paciente.
     */
    public int getIdade() {
        return this.idade;
    }

    /**
     * Retorna o sexo do paciente.
     *
     * @return O sexo do paciente (true -> masculino; false -> feminino).
     */
    public boolean getSexo() {
        return this.sexo;
    }

    /**
     * Retorna a profissão do paciente.
     *
     * @return A profissão do paciente.
     */
    public String getProfissao() {
        return this.profissao;
    }

    /**
     * Retorna o endereço do paciente.
     *
     * @return O endereço do paciente.
     */
    public String getEndereco() {
        return this.endereco;
    }

    /**
     * Retorna o telefone de contato do paciente.
     *
     * @return O telefone do paciente.
     */
    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Retorna o peso do paciente.
     *
     * @return O peso do paciente.
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * Retorna a altura do paciente.
     *
     * @return A altura do paciente.
     */
    public double getAltura() {
        return this.altura;
    }

    /**
     * Retorna o tipo sanguíneo do paciente.
     *
     * @return O tipo sanguíneo do paciente.
     */
    public String getTipoSanguineo() {
        return this.tipoSanguineo;
    }

    /**
     * Retorna o histórico médico do paciente.
     *
     * @return O histórico médico do paciente.
     */
    public HistoricoMedico getHistoricoMedico() {
        return this.historicoMedico;
    }

    /**
     * Retorna a lista de consultas realizadas pelo paciente.
     *
     * @return A lista de consultas.
     */
    public ArrayList<Consulta> getConsultas() {
        return this.consultas;
    }

    /**
     * Retorna a lista de exames realizados pelo paciente.
     *
     * @return A lista de exames.
     */
    public ArrayList<Exame> getExames() {
        return this.exames;
    }

    /**
     * Define o nome do paciente.
     *
     * @param nome O nome do paciente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o CPF do paciente.
     *
     * @param CPF O CPF do paciente.
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * Define a idade do paciente.
     *
     * @param idade A idade do paciente.
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Define o sexo do paciente.
     *
     * @param sexo O sexo do paciente (true -> masculino; false -> feminino).
     */
    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    /**
     * Define a profissão do paciente.
     *
     * @param profissao A profissão do paciente.
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * Define o endereço do paciente.
     *
     * @param endereco O endereço do paciente.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Define o telefone de contato do paciente.
     *
     * @param telefone O telefone do paciente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Define o peso do paciente.
     *
     * @param peso O peso do paciente.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Define a altura do paciente.
     *
     * @param altura A altura do paciente.
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Define o tipo sanguíneo do paciente.
     *
     * @param tipoSanguineo O tipo sanguíneo do paciente.
     */
    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    /**
     * Define o histórico médico do paciente.
     *
     * @param historicoMedico O histórico médico do paciente.
     */
    public void setHistoricoMedico(HistoricoMedico historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    /**
     * Adiciona uma consulta à lista de consultas do paciente.
     *
     * @param c A consulta a ser adicionada.
     */
        
        public void addConsulta(Consulta c){
            consultas.add(c);
        }
    /**
     * Remove uma consulta da lista de consultas do paciente.
     *
     * @param c A consulta a ser removida.
     */
        public void removerConsulta(Consulta c){
            consultas.remove(c);
        }
    /**
     * Adiciona um exame à lista de exames realizados pelo paciente.
     *
     * @param e O exame a ser adicionado.
     */
        public void addExame(Exame e){
            exames.add(e);
        }
        /**
     * Remove um exame da lista de exames realizados pelo paciente.
     *
     * @param e O exame a ser removido.
     */
        public void removerExame(Exame e){
            exames.remove(e);
        }
}
