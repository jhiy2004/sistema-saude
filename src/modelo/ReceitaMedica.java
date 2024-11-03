/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 *
 * @author renna
 */
public class ReceitaMedica {
    private String receitaId;
    private Consulta consulta;
    private String prescricao;          // Futuramente separar em medicamentos e dosagens;
    private String observacoes;
    
    public ReceitaMedica(String receitaId, Consulta consulta, String prescricao, String observacoes) {
        this.receitaId = receitaId;
        this.consulta = consulta;                
        this.prescricao = prescricao;
        this.observacoes = observacoes;
    }

    public String toString(){      // Função que Emula impressão da receita
        return "Receita Médica "+getReceitaId()+"Informações do Emitente:\n"+
                "\nNome: "+getConsulta().getMedico().getNome()+"\nCRM: "+getConsulta().getMedico().getCrm()+
                "\nIdentificação do Paciente: "+"\nNome: "+getConsulta().getPaciente().getNome()+
                "\nIdade: "+getConsulta().getPaciente().getIdade()+"\nTelefone: "+getConsulta().getPaciente().getTelefone()+
                "\nPrescrição: "+getPrescricao()+"Observações: "+getObservacoes()+"\nData de Emissão: "+getConsulta().getData();        
    }
            
    public String getReceitaId() {
        return receitaId;
    }

    public void setReceitaId(String receitaId) {
        this.receitaId = receitaId;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    /*FUNÇÃO FUTURA
     public Remedio buscaRemedio(String medicamento){       //aqui deve analisar a string e buscar o remedio em um banco de dados
         while(!=null && != medicamento) then create new Remedio ;
     };
     */
    
}
    