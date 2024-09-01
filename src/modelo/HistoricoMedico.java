package modelo;

import java.util.Date;

public class HistoricoMedico{
	private Date dataCriacao;
	private String historicoFamiliar;
	private String historicoMedicamentos;
	private String historicoCirurgias;
	private String doencasPrevias;
	private String doencasCronicas;

	public HistoricoMedico(String historicoFamiliar, String historicoMedicamentos, String historicoCirurgias,
							String doencasPrevias, String doencasCronicas){
		dataCriacao = new Date();
		this.historicoFamiliar = historicoFamiliar;
		this.historicoMedicamentos = historicoMedicamentos;
		this.historicoCirurgias = historicoCirurgias;
		this.doencasPrevias = doencasPrevias;
		this.doencasCronicas = doencasPrevias;
	}
}
