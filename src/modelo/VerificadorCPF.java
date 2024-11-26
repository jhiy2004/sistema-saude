
import java.util.InputMismatchException;

/**
 * Classe para verificação de validade de números de CPF.
 *
 * O CPF (Cadastro de Pessoas Físicas) é validado com base nos seus dois dígitos verificadores,
 * que são calculados a partir dos primeiros nove dígitos do CPF.
 * Seguindo os passos:
 *   1. Calcular o primeiro dígito verificador usando os 9 primeiros dígitos do CPF
 *    2. Calcular o segundo dígito verificador usando os 9 primeiros dígitos e o primeiro verificador
 *    3. Verificar se os 2 dígitos encontrados são iguais aos 2 últimos dígitos do CPF
 *    4. Se os dígitos calculados forem iguais aos dígitos fornecidos, então o CPF é válido

 * 
 */

public class VerificadorCPF {

/**
     * Verifica se um número de CPF é válido.
     *
     * @param CPF Uma string contendo os 11 dígitos numéricos do CPF.
     * @return {@code true} se o CPF é válido; {@code false} caso contrário.
     */
   
    public static boolean isCPF(String CPF) {

        // eliminamos CPF's formados por uma sequência de números iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") ||
            CPF.equals("33333333333") ||
            CPF.equals("44444444444") ||
            CPF.equals("55555555555") ||
            CPF.equals("66666666666") ||
            CPF.equals("77777777777") ||
            CPF.equals("88888888888") ||
            CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig1, dig2;
        int soma, i, resto, num, peso;

        // "try" - protege o código de possíveis erros de conversão de tipo
        try {
            soma = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int)(CPF.charAt(i) - 48);
                soma += (num * peso);
                peso --; 
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11))
                dig1 = '0';
            else dig1 = (char)(resto + 48);
        
            // calcular o segundo dígito verificador
            soma = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                soma += (num * peso);
                peso --;
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11))
                dig2 = '0';
            else dig2 = (char)(resto + 48);

            // verifica se os dígitos calculados conferem
            if ((dig1 == CPF.charAt(9)) && (dig2 == CPF.charAt(10)))
                return(true);
            else return(false);

        } catch (InputMismatchException erro) {
            return(false);
        }
    }
    
 /**
     * Formata um número de CPF para o formato padrão: XXX.XXX.XXX-XX.
     *
     * @param CPF Uma string contendo os 11 dígitos numéricos do CPF.
     * @return Uma string formatada no estilo XXX.XXX.XXX-XX.
     */


    public static String imprimeCPF (String CPF) {
        return (CPF.substring(0,3) + "." + CPF.substring(3,6))
        + "." + CPF.substring(6,9) + "-" + CPF.substring(9,11);
    }

    
}
