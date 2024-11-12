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
 */
public class Logger {
    enum Level {
        INFO,
	ERROR,
    }

    private Logger() {}

    private static Logger instance;
    private static final String filename = "log.txt";

	public static Logger getInstance() {
            if(instance == null)
                instance = new Logger();
            return instance;
        }

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
