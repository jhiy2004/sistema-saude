package modelo;

/**
 * Representa um médico com informações como CRM, especialidade médica, nome, salário e agenda.
 */
public class Medico {
    
    private String crm;
    private String especialidadeMedica;
    private String nome;
    private float salario;
    private Agenda agenda;

    /**
     * Construtor para criar um objeto médico com CRM, especialidade médica, nome e salário.
     *
     * @param crm O número de registro do médico.
     * @param especialidadeMedica A especialidade médica do médico.
     * @param nome O nome do médico.
     * @param salario O salário do médico.
     */
    public Medico(String crm, String especialidadeMedica, String nome, float salario)
    {
        this.crm = crm;
        this.especialidadeMedica = especialidadeMedica;
        this.nome = nome;
        this.salario = salario;
        this.agenda = new Agenda();
    }

    /**
     * Retorna o CRM do médico.
     *
     * @return O CRM do médico.
     */
    public String getCrm()
    {
        return crm;
    }
    /**
     * Define o CRM do médico.
     *
     * @param crm O número de registro do médico.
     */
    public void setCrm(String crm)
    {
        this.crm = crm;
    }
     /**
     * Retorna o nome do médico.
     *
     * @return O nome do médico.
     */
    public String getNome()
    {
        return nome;
    }
     /**
     * Define o nome do médico.
     *
     * @param nome O nome do médico.
     */
    public void setNome (String nome)
    {
        this.nome = nome;
    }
    /**
     * Retorna o salário do médico.
     *
     * @return O salário do médico.
     */
    public float getSalario()
    {
        return salario;
    }
     /**
     * Define o salário do médico.
     *
     * @param salario O valor do salário do médico.
     */
    public void setSalario (float salario)
    {
        this.salario = salario;
    }
    /**
     * Retorna a especialidade médica do médico.
     *
     * @return A especialidade médica do médico.
     */
    public String getEspecialidadeMedica ()
    {
        return especialidadeMedica;
    }
     /**
     * Define a especialidade médica do médico.
     *
     * @param especialidadeMedica A especialidade médica do médico.
     */
    public void setEspecialidadeMedica(String especialidadeMedica)
    {
        this.especialidadeMedica = especialidadeMedica;
    }
    /**
     * Retorna a agenda do médico, que contém os horários de consultas e exames.
     *
     * @return A agenda do médico.
     */
    public Agenda getAgenda(){
        return agenda;
    }
    
    /**
     * Adiciona uma consulta à agenda do médico.
     *
     * @param c A consulta a ser adicionada.
     * @return A consulta adicionada ou null caso não seja possível adicionar.
     */
    public Consulta adicionarConsulta(Consulta c)
    {
        Consulta retorno = agenda.adicionarHorarioConsulta(c);
        return retorno;
    }
    /**
     * Cancela uma consulta da agenda do médico.
     *
     * @param c A consulta a ser cancelada.
     * @return {@code true} se a consulta foi cancelada com sucesso, {@code false} caso contrário.
     */
    public boolean cancelarConsulta(Consulta c)
    {
        boolean retorno = agenda.cancelarHorarioConsulta(c);
        return retorno;
    }
    /**
     * Adiciona um exame à agenda do médico.
     *
     * @param e O exame a ser adicionado.
     * @return O exame adicionado ou null caso não seja possível adicionar.
     */
    public Exame adicionarExame(Exame e)
    {
        Exame retorno = agenda.adicionarHorarioExame(e);
        return retorno;
    }
    /**
     * Cancela um exame da agenda do médico.
     *
     * @param e O exame a ser cancelado.
     * @return {@code true} se o exame foi cancelado com sucesso, {@code false} caso contrário.
     */
    public boolean cancelarExame(Exame e)
    {
        boolean retorno = agenda.cancelarHorarioExame(e);
        return retorno;
    }
}
