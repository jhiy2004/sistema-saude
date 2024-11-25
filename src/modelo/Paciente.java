package modelo;

import java.util.ArrayList;

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

	public String getNome(){
            return this.nome;
	}
        
        public String getCPF(){
            return this.CPF;
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
        
        public HistoricoMedico getHistoricoMedico(){
            return this.historicoMedico;
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
        
        public void setCPF(String CPF){
            this.CPF = CPF;
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
        
        public void setHistoricoMedico(HistoricoMedico historicoMedico){
            this.historicoMedico = historicoMedico;
        }
        
        public void addConsulta(Consulta c){
            consultas.add(c);
        }
        
        public void addExame(Exame e){
            exames.add(e);
        }
}
