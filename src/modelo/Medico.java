package modelo;

public class Medico {
    
    private String crm;
    private String especialidadeMedica;
    private String nome;
    private float salario;
    private Agenda agenda;

    //metodo construtor
    public Medico(String crm, String especialidadeMedica, String nome, float salario)
    {
        this.crm = crm;
        this.especialidadeMedica = especialidadeMedica;
        this.nome = nome;
        this.salario = salario;
        this.agenda = new Agenda();
    }

    //getters e setters
    public String getCrm()
    {
        return crm;
    }

    public void setCrm(String crm)
    {
        this.crm = crm;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public float getSalario()
    {
        return salario;
    }

    public void setSalario (float salario)
    {
        this.salario = salario;
    }
    
    public String getEspecialidadeMedica ()
    {
        return especialidadeMedica;
    }
    
    public void setEspecialidadeMedica(String especialidadeMedica)
    {
        this.especialidadeMedica = especialidadeMedica;
    }
    
    // métodos
    public Consulta adicionarConsulta(Consulta c)
    {
        Consulta retorno = agenda.adicionarHorarioConsulta(c);
        return retorno;
    }
    
    public boolean cancelarConsulta(Consulta c)
    {
        boolean retorno = agenda.cancelarHorarioConsulta(c);
        return retorno;
    }
    
    public Exame adicionarExame(Exame e)
    {
        Exame retorno = agenda.adicionarHorarioExame(e);
        return retorno;
    }
    
    public boolean cancelarExame(Exame e)
    {
        boolean retorno = agenda.cancelarHorarioExame(e);
        return retorno;
    }
}
