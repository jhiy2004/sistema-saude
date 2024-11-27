package modelo;

import java.time.LocalDateTime;

/**
 * Representa o histórico médico de um paciente, incluindo informações familiares,
 * medicamentos, cirurgias, doenças e hábitos de vida.
 */

public class HistoricoMedico{
	private LocalDateTime dataModificacao;
	private String historicoFamiliar;
	private String historicoMedicamentos;
	private String historicoCirurgias;
	private String doencasPrevias;
	private String doencasCronicas;
        
        private boolean usoMedicamentos;
	private boolean usoCigarroAlcool;
	private boolean praticaExercicios;

/**
     * Construtor para criar um histórico médico com todas as informações relevantes.
     *
     * @param historicoFamiliar      Histórico de saúde familiar.
     * @param historicoMedicamentos  Histórico de uso de medicamentos.
     * @param historicoCirurgias     Histórico de cirurgias realizadas.
     * @param doencasPrevias         Doenças prévias do paciente.
     * @param doencasCronicas        Doenças crônicas do paciente.
     * @param usoMedicamentos        Indicador de uso regular de medicamentos.
     * @param usoCigarroAlcool       Indicador de uso de cigarro ou álcool.
     * @param praticaExercicios      Indicador de prática regular de exercícios físicos.
     */
	public HistoricoMedico(String historicoFamiliar, String historicoMedicamentos, String historicoCirurgias,
                                String doencasPrevias, String doencasCronicas, boolean usoMedicamentos, boolean usoCigarroAlcool,
				boolean praticaExercicios){
            
		this.dataModificacao = LocalDateTime.now();
		this.historicoFamiliar = historicoFamiliar;
		this.historicoMedicamentos = historicoMedicamentos;
		this.historicoCirurgias = historicoCirurgias;
		this.doencasPrevias = doencasPrevias;
		this.doencasCronicas = doencasCronicas;
                this.usoMedicamentos = usoMedicamentos;
		this.usoCigarroAlcool = usoCigarroAlcool;
		this.praticaExercicios = praticaExercicios;
	}

	/**
     * Retorna a data da última modificação no histórico médico.
     *
     * @return A data da última modificação.
     */

	public LocalDateTime getData(){
		return this.dataModificacao;
	}
/**
     * Retorna se o paciente utiliza medicamentos regularmente.
     *
     * @return {@code true} se utiliza, {@code false} caso contrário.
     */
        public boolean getUsoMedicamentos(){
		return this.usoMedicamentos;
	}
/**
     * Retorna se o paciente faz uso de cigarro ou álcool.
     *
     * @return {@code true} se faz uso, {@code false} caso contrário.
     */
	public boolean getUsoCigarroAlcool(){
		return this.usoCigarroAlcool;
	}

    /**
     * Retorna se o paciente pratica exercícios físicos regularmente.
     *
     * @return {@code true} se pratica, {@code false} caso contrário.
     */
	public boolean getPraticaExercicios(){
		return this.praticaExercicios;
	}
	 /**
     * Retorna o histórico de saúde familiar.
     *
     * @return O histórico familiar.
     */
	public String getHistoricoFamiliar(){
		return this.historicoFamiliar;
	}
/**
     * Retorna o histórico de uso de medicamentos.
     *
     * @return O histórico de medicamentos.
     */
	public String getHistoricoMedicamentos(){
		return this.historicoMedicamentos;
	}
/**
     * Retorna o histórico de cirurgias realizadas.
     *
     * @return O histórico de cirurgias.
     */
	public String getHistoricoCirurgias(){
		return this.historicoCirurgias;
	}
	/**
     * Retorna as doenças prévias do paciente.
     *
     * @return As doenças prévias.
     */

	public String getDoencasPrevias(){
		return this.doencasPrevias;
	}

    /**
     * Retorna as doenças crônicas do paciente.
     *
     * @return As doenças crônicas.
     */
	public String getDoencasCronicas(){
		return this.doencasCronicas;
	}
	/**
     * Retorna o histórico de uso de medicamentos.
     *
     * @return O histórico de medicamentos.
     */
        public void setHistoricoMedicamentos(String historicoMedicamentos){
		this.historicoMedicamentos = historicoMedicamentos;
		this.atualizarDataParaAtual();
	}
    /**
     * Define um novo histórico de saúde familiar e atualiza a data de modificação.
     *
     * @param historicoFamiliar O novo histórico familiar.
     */

	public void setHistoricoFamiliar(String historicoFamiliar){
		this.historicoFamiliar = historicoFamiliar;
		this.atualizarDataParaAtual();
	}
/**
     * Define um novo histórico de cirurgias e atualiza a data de modificação.
     *
     * @param historicoCirurgias O novo histórico de cirurgias.
     */
	public void setHistoricoCirurgias(String historicoCirurgias){
		this.historicoCirurgias = historicoCirurgias;
		this.atualizarDataParaAtual();
	}

	/**
     * Define novas doenças prévias e atualiza a data de modificação.
     *
     * @param doencasPrevias As novas doenças prévias.
     */
	public void setDoencasPrevias(String doencasPrevias){
		this.doencasPrevias = doencasPrevias;
		this.atualizarDataParaAtual();
	}
	/**
     * Define novas doenças crônicas e atualiza a data de modificação.
     *
     * @param doencasCronicas As novas doenças crônicas.
     */
	public void setDoencasCronicas(String doencasCronicas){
		this.doencasCronicas = doencasCronicas;
		this.atualizarDataParaAtual();
	}
        /**
     * Define o boleano para uso medicamentos.
     *
     * @param boleano para uso ou não uso.
     */
        public void setUsoMedicamentos(boolean usoMedicamentos){
		this.usoMedicamentos = usoMedicamentos;
	}
  /**
     * Define o boleano para uso cigarro ou/e alcool.
     *
     * @param boleano para uso ou não uso.
     */
	public void setUsoCigarroAlcool(boolean usoCigarroAlcool){
		this.usoCigarroAlcool = usoCigarroAlcool;
	}
  /**
     * Define o boleano para pratico exercicios.
     *
     * @param boleano para pratico ou não.
     */
	public void setPraticaExercicios(boolean praticaExercicios){
		this.praticaExercicios = praticaExercicios;
	}
        
 /**
     * Atualiza a data de modificação para o momento atual.
     */
	public void atualizarDataParaAtual(){
		this.dataModificacao = LocalDateTime.now();
	}
}
