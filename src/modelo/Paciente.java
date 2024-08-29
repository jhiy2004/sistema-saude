public class Paciente{
	private String nome;
	private int idade;
	private bool sexo;
	private String profissao;
	private String endereco;
	private String telefone;
	private double peso;
	private double altura;
	private String tipoSanguineo;
	private bool usoMedicamentos;
	private bool usoCigarroAlcool;
	private bool praticaExercicios;

	private HistoricoMedico historicoMedico;

	public Paciente(String nome, int idade, bool sexo, String profissao, String endereco, String telefone,
					double peso, double altura, String tipoSanguineo, bool usoMedicamentos, bool usoCigarroAlcool,
					bool praticaExercicios){
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.profissao = profissao;
		this.endereco = endereco;
		this.telefone = telefone;
		this.peso = peso;
		this.altura = altura;
		this.tipoSanguineo = tipoSanguineo;
		this.usoMedicamentos = usoMedicamentos;
		this.usoCigarroAlcool = usoCigarroAlcool;
		this.praticaExercicios = praticaExercicios;
	}

	public String getNome(){
		return this.nome;
	}

	public int getIdade(){
		return this.idade;
	}

	public bool getSexo(){
		return this.sexo;
	}

	public String getProfissao(){
		return this.profissao;
	}

	public String getEndereco(){
		return this.endereco;
	}

	public String getTelefone(){
		return this.telefone;
	}

	public double getPeso(){
		return this.peso;
	}

	public double getAltura(){
		return this.altura;
	}

	public String getTipoSanguineo(){
		return this.tipoSanguineo;
	}

	public bool getUsoMedicamentos(){
		return this.usoMedicamentos;
	}

	public bool getUsoCigarroAlcool(){
		return this.usoCigarroAlcool;
	}

	public bool getPraticaExercicios(){
		return this.praticaExercicios;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setIdade(int idade){
		this.idade = idade;
	}

	public void setSexo(bool sexo){
		this.sexo = sexo;
	}

	public void setProfissao(String profissao){
		this.profissao = profissao;
	}

	public void setEndereco(String endereco){
		this.endereco = endereco;
	}

	public void setTelefone(String telefone){
		this.telefone = telefone;
	}

	public void setPeso(double peso){
		this.peso = peso;
	}

	public void setAltura(double altura){
		this.altura = altura;
	}

	public void setTipoSanguineo(String tipoSanguineo){
		this.tipoSanguineo = tipoSanguineo;
	}

	public void setUsoMedicamentos(bool usoMedicamentos){
		this.usoMedicamentos = usoMedicamentos;
	}

	public void setUsoCigarroAlcool(bool usoCigarroAlcool){
		this.usoCigarroAlcool = usoCigarroAlcool;
	}

	public void setPraticaExercicios(bool praticaExercicios){
		this.praticaExercicios = praticaExercicios;
	}

}
