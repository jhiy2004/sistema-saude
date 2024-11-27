package modelo;

/**
 * Classe abstrata FuncionarioTemplate que representa um funcionário de um hospital
 * com atributos básicos como salário e nome.
 * A classe utiliza o padrão de projeto Template Method para calcular o salário líquido,
 * permitindo que subclasses definam diferentes tipos de descontos específicos para
 * funcionários do hospital, como médicos, enfermeiros ou administrativos.
 *
 * O padrão Template Method é implementado através do método calcSalarioLiquido(),
 * que fornece um esqueleto para o cálculo do salário líquido. Esse método chama métodos
 * abstratos que devem ser implementados por subclasses para fornecer os valores
 * específicos dos descontos de acordo com o tipo de funcionário do hospital.
 *
 * O uso do Template Method garante flexibilidade para adaptar o cálculo do salário líquido
 * a diferentes categorias de funcionários do hospital, sem alterar o fluxo principal de cálculo.
 * 
 * @author rennan
 */
public abstract class FuncionarioTemplate {
    // Atributos protegidos para salário e nome do funcionário
    protected double salario;
    protected String nome;

    /**
     * Construtor da classe FuncionarioTemplate
     * 
     * @param salario O salário base do funcionário
     * @param nome O nome do funcionário
     */
    public FuncionarioTemplate(double salario, String nome) {
        this.salario = salario;
        this.nome = nome;
    }

    // Métodos get e set para os atributos

    /**
     * Retorna o salário do funcionário
     * 
     * @return Salário do funcionário
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Retorna o nome do funcionário
     * 
     * @return Nome do funcionário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o salário do funcionário
     * 
     * @param salario Novo salário do funcionário
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Define o nome do funcionário
     * 
     * @param nome Novo nome do funcionário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método abstrato que calcula os descontos previdenciários.
     * Este método deve ser implementado por subclasses para definir a lógica
     * específica do desconto previdenciário, como INSS ou equivalente.
     * 
     * @return Valor do desconto previdenciário
     */
    abstract double calcDescontosPrevidencia();

    /**
     * Método abstrato que calcula os descontos referentes ao plano de saúde.
     * Este método deve ser implementado por subclasses para definir a lógica
     * específica do desconto de plano de saúde aplicado a funcionários do hospital.
     * 
     * @return Valor do desconto do plano de saúde
     */
    abstract double calcDescontosPlanoSaude();

    /**
     * Método abstrato que calcula outros descontos aplicáveis ao funcionário.
     * Este método deve ser implementado por subclasses para definir outros descontos,
     * como alimentação, transporte ou benefícios específicos.
     * 
     * @return Valor de outros descontos
     */
    abstract double calcOutrosDescontos();

    /**
     * Método que calcula o salário líquido do funcionário aplicando o Template Method.
     * O cálculo do salário líquido segue o seguinte fluxo:
     * 1. Calcula o desconto previdenciário.
     * 2. Calcula o desconto do plano de saúde.
     * 3. Calcula outros descontos.
     * 4. Subtrai todos os descontos do salário base.
     * 
     * @return Salário líquido após aplicação de todos os descontos
     */
    public double calcSalarioLiquido() {
        double prev = calcDescontosPrevidencia();
        double saude = calcDescontosPlanoSaude();
        double outros = calcOutrosDescontos();
        return salario - prev - saude - outros;
    }
}
