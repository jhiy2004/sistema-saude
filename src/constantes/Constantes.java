package constantes;
/**
 * A classe Constantes contém constantes utilizadas em diversos pontos do sistema, incluindo tipos sanguíneos,
 * especialidades médicas, status de exames e consultas, e o tamanho máximo para o armazenamento de dados de persistência.
 * Padronizando o modo como se encontra essas constantes no sistema.
 */
public class Constantes {
    // Tipos sanguíneos
    public static final String A_MAIS = "A+";
    public static final String A_MENOS = "A-";
    public static final String B_MAIS = "B+";
    public static final String B_MENOS = "B-";
    public static final String AB_MAIS = "AB+";
    public static final String AB_MENOS = "AB-";
    public static final String O_MAIS = "O+";
    public static final String O_MENOS = "O-";
    
    // Especialidades médicas
    
    // Tratamento de doenças do coração e sistema circulatório
    public static final String CARDIOLOGIA = "CARDIOLOGIA";
    
    // Cuidados com a pele, unhas e cabelos
    public static final String DERMATOLOGIA = "DERMATOLOGIA";
    
    // Estudo das glândulas endócrinas e distúrbios hormonais
    public static final String ENDOCRINOLOGIA = "ENDOCRINOLOGIA";
    
    // Tratamento de problemas digestivos e intestinais
    public static final String GASTROENTEROLOGIA = "GASTROENTEROLOGIA";
    
    // Cuidados de saúde para idosos
    public static final String GERIATRIA = "GERIATRIA";
    
    // Cuidados na saúde do sistema reprodutor feminino
    public static final String GINECOLOGIA = "GINECOLOGIA";
    
    // Diagnóstico e tratamento de doenças do sistema nervoso
    public static final String NEUROLOGIA = "NEUROLOGIA";
    
    // Cuidados com a visão e doenças dos olhos
    public static final String OFTALMOLOGIA = "OFTALMOLOGIA";
    
    // Tratamento de doenças e lesões dos ossos e músculos
    public static final String ORTOPEDIA = "ORTOPEDIA";
    
    // Saúde e cuidados médicos para crianças
    public static final String PEDIATRIA = "PEDIATRIA";
    
    // Diagnóstico e tratamento de doenças mentais
    public static final String PSIQUIATRIA = "PSIQUIATRIA";
    
    // Tratamento de doenças do sistema urinário e reprodutor masculino
    public static final String UROLOGIA = "UROLOGIA";
    
    // Status Exames e Consultas
    public enum Status {
        AGENDADO, REALIZADO, CANCELADO
    }
    
    // Persistência
    
    //Tamanho máximo de armazenamento do vetor persistenciaVetor
    public static final int size_persistencia = 100;
    
    // Taxas de descontos
    
    // Taxa de desconto previdência
    public static final double TAXA_PREVIDENCIA = 0.11;
    
    // Taxa de outros descontos
    public static final double TAXA_OUTROS = 0.05;
    
    // Desconto plano de saúde
    public static final double DESCONTO_PLANO_SAUDE = 300.00;
}
