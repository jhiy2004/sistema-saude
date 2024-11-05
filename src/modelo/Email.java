package modelo;

/*
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
*/

public class Email {
    /*
    private String remetente;
    private String senha;
    private String destinatario;
    private String assunto;
    private String conteudo;

    // Construtor
    public Email(String remetente, String senha, String destinatario, String assunto, String conteudo) {
        this.remetente = remetente;
        this.senha = senha;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.conteudo = conteudo;
    }

    // Método para enviar o e-mail
    public void enviar() {
        // Configurações do servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Sessão com autenticação
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        });

        try {
            // Criação da mensagem de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(assunto);
            message.setText(conteudo);

            // Envio do e-mail
            Transport.send(message);
            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Erro ao enviar o e-mail.");
        }
    }
    */
}
