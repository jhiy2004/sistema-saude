/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author joseyamaoki
 * 
 * A classe Logger é responsável por gerenciar o registro de logs no sistema,
 * permitindo a escrita de mensagens de log em um arquivo de texto. 
 * O Logger segue o padrão Singleton, garantindo que haja apenas uma instância 
 * de registro de logs durante a execução do programa.
 */
public class Logger {
    enum Level {
        INFO,
	ERROR,
    }

    private Logger() {}

    private static Logger instance;
    private static final String filename = "log.txt";
    /**
     * Retorna a instância única do Logger. Caso ainda não tenha sido criada, 
     * ela será inicializada no momento da primeira chamada.
     *
     * @return A instância única de Logger.
     */

	public static Logger getInstance() {
            if(instance == null)
                instance = new Logger();
            return instance;
        }
     /**
     * Registra uma mensagem no arquivo de log, juntamente com o tipo de log 
     * (INFO ou ERROR) e a data/hora da escrita.
     *
     * @param msg A mensagem a ser registrada no log.
     * @param tipo O tipo do log (INFO ou ERROR).
     */
	public void gravaArquivo(String msg, Level tipo) {
            LocalDateTime atual = LocalDateTime.now();
            try(FileWriter fileWriter = new FileWriter("./log.txt", true)) {
                String dataHoraFormatada = atual.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));

                switch(tipo){
                    case INFO:
                        fileWriter.write("INFO");
                        break;
                    case ERROR:
                        fileWriter.write("ERROR");
                        break;
		}

                fileWriter.write(" ["+dataHoraFormatada+"] ");

                fileWriter.write(msg+"\n");

		fileWriter.close();
	} catch (Exception e) {
            e.printStackTrace();
	}
    }
}
