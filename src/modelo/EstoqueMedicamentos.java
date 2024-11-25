package modelo;

import java.util.ArrayList;

public class EstoqueMedicamentos {
    private ArrayList<Medicamento> medicamentos;
    
    public EstoqueMedicamentos(){
        medicamentos = new ArrayList<>();
    }
    
    public void adicionarMedicamento(Medicamento m){
        if(buscarMedicamentoNome(m.getCodigo()) == null){
            medicamentos.add(m);
        }
    }
    
    public void removerMedicamento(String codigo){
        medicamentos.removeIf(medicamento -> medicamento.getCodigo().equals(codigo));
    }
    
    public int quantidadeMedicamentos(){
        return medicamentos.size();
    }
    
    public Medicamento buscarMedicamentoNome(String nome) {
        for (Medicamento m : medicamentos) {
            if (m.getNome().equals(nome)) {
                return m;
            }
        }
        return null;
    }
    
    public ArrayList<Medicamento> getMedicamentos(){
        return medicamentos;
    }
}