package modelo;

import controlador.GerenciaHospitalar;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Paciente{
	private String nome;
	private int idade;
	private boolean sexo;
	private String profissao;
	private String endereco;
	private String telefone;
	private double peso;
	private double altura;
	private String tipoSanguineo;
	private boolean usoMedicamentos;
	private boolean usoCigarroAlcool;
	private boolean praticaExercicios;

	private ArrayList<Consulta> consultas;
	private ArrayList<Exame> exames;

	private GerenciaHospitalar gh;
	private HistoricoMedico historicoMedico;

	public Paciente(String nome, int idade, boolean sexo, String profissao, String endereco, String telefone,
					double peso, double altura, String tipoSanguineo, boolean usoMedicamentos, boolean usoCigarroAlcool,
					boolean praticaExercicios){
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

		this.consultas = new ArrayList<>();
		this.exames = new ArrayList<>();

		this.gh = new GerenciaHospitalar();
	}

	public void agendarConsulta(int numeroHospitalSelec, String especialidade, Medico m, LocalDate data, LocalTime horario){
		Consulta c = gh.addConsulta(this, numeroHospitalSelec, especialidade, m, data, horario);
		this.consultas.add(c);
	}

	public void agendarExame(int numeroHospitalSelec, String especialidade, Medico m, LocalDate data, LocalTime horario){
		Exame e = gh.addExame(this, numeroHospitalSelec, especialidade, m, data, horario);
		this.exames.add(e);
	}
	
	public void cancelarConsulta(Consulta c){
            boolean resultado = gh.cancelarConsulta(c);
            if(resultado){
                this.consultas.remove(c);
            }
	}
	
	public void cancelarExame(Exame e){
	    boolean resultado = gh.cancelarExame(e);
            if(resultado){
                this.exames.remove(e);
            }
	}

	public String getNome(){
		return this.nome;
	}

	public int getIdade(){
		return this.idade;
	}

	public boolean getSexo(){
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

	public boolean getUsoMedicamentos(){
		return this.usoMedicamentos;
	}

	public boolean getUsoCigarroAlcool(){
		return this.usoCigarroAlcool;
	}

	public boolean getPraticaExercicios(){
		return this.praticaExercicios;
	}

	public ArrayList<Consulta> getConsultas(){
		return this.consultas;
	}

	public ArrayList<Exame> getExames(){
		return this.exames;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setIdade(int idade){
		this.idade = idade;
	}

	public void setSexo(boolean sexo){
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

	public void setUsoMedicamentos(boolean usoMedicamentos){
		this.usoMedicamentos = usoMedicamentos;
	}

	public void setUsoCigarroAlcool(boolean usoCigarroAlcool){
		this.usoCigarroAlcool = usoCigarroAlcool;
	}

	public void setPraticaExercicios(boolean praticaExercicios){
		this.praticaExercicios = praticaExercicios;
	}

}
