package modelo;

/**
 * Representa um médico com informações como CRM, especialidade médica, nome, salário e agenda,
 * aplicando descontos específicos no cálculo do salário líquido.
 */
public class Medico extends FuncionarioTemplate {

    private String crm;
    private String especialidadeMedica;
    private Agenda agenda;

    /**
     * Construtor para criar um objeto médico com CRM, especialidade médica, nome e salário.
     *
     * @param crm O número de registro do médico.
     * @param especialidadeMedica A especialidade médica do médico.
     * @param nome O nome do médico.
     * @param salario O salário do médico.
     */
    public Medico(String crm, String especialidadeMedica, String nome, double salario) {
        super(salario, nome);
        this.crm = crm;
        this.especialidadeMedica = especialidadeMedica;
        this.agenda = new Agenda();
    }

    /**
     * Retorna o CRM do médico.
     *
     * @return O CRM do médico.
     */
    public String getCrm() {
        return crm;
    }

    /**
     * Define o CRM do médico.
     *
     * @param crm O número de registro do médico.
     */
    public void setCrm(String crm) {
        this.crm = crm;
    }

    /**
     * Retorna a especialidade médica do médico.
     *
     * @return A especialidade médica do médico.
     */
    public String getEspecialidadeMedica() {
        return especialidadeMedica;
    }

    /**
     * Define a especialidade médica do médico.
     *
     * @param especialidadeMedica A especialidade médica do médico.
     */
    public void setEspecialidadeMedica(String especialidadeMedica) {
        this.especialidadeMedica = especialidadeMedica;
    }

    /**
     * Retorna a agenda do médico, que contém os horários de consultas e exames.
     *
     * @return A agenda do médico.
     */
    public Agenda getAgenda() {
        return agenda;
    }

    /**
     * Adiciona uma consulta à agenda do médico.
     *
     * @param c A consulta a ser adicionada.
     * @return A consulta adicionada ou null caso não seja possível adicionar.
     */
    public Consulta adicionarConsulta(Consulta c) {
        return agenda.adicionarHorarioConsulta(c);
    }

    /**
     * Cancela uma consulta da agenda do médico.
     *
     * @param c A consulta a ser cancelada.
     * @return {@code true} se a consulta foi cancelada com sucesso, {@code false} caso contrário.
     */
    public boolean cancelarConsulta(Consulta c) {
        return agenda.cancelarHorarioConsulta(c);
    }

    /**
     * Adiciona um exame à agenda do médico.
     *
     * @param e O exame a ser adicionado.
     * @return O exame adicionado ou null caso não seja possível adicionar.
     */
    public Exame adicionarExame(Exame e) {
        return agenda.adicionarHorarioExame(e);
    }

    /**
     * Cancela um exame da agenda do médico.
     *
     * @param e O exame a ser cancelado.
     * @return {@code true} se o exame foi cancelado com sucesso, {@code false} caso contrário.
     */
    public boolean cancelarExame(Exame e) {
        return agenda.cancelarHorarioExame(e);
    }

    /**
     * Calcula os descontos previdenciários para o médico.
     * Neste caso, consideramos uma taxa de 11% sobre o salário base.
     *
     * @return O valor do desconto previdenciário.
     */
    @Override
    double calcDescontosPrevidencia() {
        return salario * 0.11;
    }

    /**
     * Calcula os descontos referentes ao plano de saúde para o médico.
     * Neste caso, consideramos um valor fixo de R$300,00.
     *
     * @return O valor do desconto do plano de saúde.
     */
    @Override
    double calcDescontosPlanoSaude() {
        return 300.00;
    }

    /**
     * Calcula outros descontos aplicáveis ao médico.
     * Neste caso, consideramos um desconto adicional de 5% para fundo de pesquisa.
     *
     * @return O valor de outros descontos.
     */
    @Override
    double calcOutrosDescontos() {
        return salario * 0.05;
    }
}
