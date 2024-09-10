package modelo;

import java.time.LocalDateTime;

public class HistoricoMedico{
	private LocalDateTime dataModificacao;
	private String historicoFamiliar;
	private String historicoMedicamentos;
	private String historicoCirurgias;
	private String doencasPrevias;
	private String doencasCronicas;

	public HistoricoMedico(String historicoFamiliar, String historicoMedicamentos, String historicoCirurgias,
							String doencasPrevias, String doencasCronicas){
		this.dataModificacao = LocalDateTime.now();
		this.historicoFamiliar = historicoFamiliar;
		this.historicoMedicamentos = historicoMedicamentos;
		this.historicoCirurgias = historicoCirurgias;
		this.doencasPrevias = doencasPrevias;
		this.doencasCronicas = doencasPrevias;
	}

	public LocalDateTime getData(){
		return this.dataModificacao;
	}

	public String getHistoricoFamiliar(){
		return this.historicoFamiliar;
	}

	public String getHistoricoMedicamentos(){
		return this.historicoMedicamentos;
	}

	public String getHistoricoCirurgias(){
		return this.historicoCirurgias;
	}

	public String getDoencasPrevias(){
		return this.doencasPrevias;
	}

	public String getDoencasCronicas(){
		return this.doencasCronicas;
	}

	public void setHistoricoMedicamentos(String historicoMedicamentos){
		this.historicoMedicamentos = historicoMedicamentos;
		this.atualizarDataParaAtual();
	}

	public void setHistoricoCirurgias(String historicoCirurgias){
		this.historicoCirurgias = historicoCirurgias;
		this.atualizarDataParaAtual();
	}

	public void setDoencasPrevias(String doencasPrevias){
		this.doencasPrevias = doencasPrevias;
		this.atualizarDataParaAtual();
	}
	
	public void setDoencasCronicas(String doencasCronicas){
		this.doencasCronicas = doencasCronicas;
		this.atualizarDataParaAtual();
	}

	public void atualizarDataParaAtual(){
		this.dataModificacao = LocalDateTime.now();
	}
}
