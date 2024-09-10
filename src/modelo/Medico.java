package modelo;

public class Medico {
    
    private String crm;
    private EspecialidadeMedica especialidadeMedica;
    private String nome;
    private float salario;

    //metodo construtor
    public Medico(String crm, EspecialidadeMedica especialidadeMedica, String nome, float salario)
    {
        this.crm = crm;
        this.especialidadeMedica = especialidadeMedica;
        this.nome = nome;
        this.salario = salario;
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

    public String getnome()
    {
        return nome;
    }

    public void setnome (String nome)
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
}
