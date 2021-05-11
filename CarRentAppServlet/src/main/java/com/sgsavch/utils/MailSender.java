package com.sgsavch.utils;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.ResourceBundle;


// Causes Lombok to generate a logger field.
//@Slf4j
public class MailSender {
    private String to;
    private String text;
    private String subject;
    private String username;
    private String password;
    private Properties props;
    private ResourceBundle rb;

    public  MailSender(String to, String subject, String message) throws AddressException, MessagingException {
        this.to=to;
        this.subject=subject;
        this.text=message;
        this.props = new Properties();
        this.rb = ResourceBundle.getBundle("application");
        this.username = rb.getString("mail.user.name");
        this.password = rb.getString("mail.user.password");
        this.props.put("mail.smtp.host", rb.getString("mail.smtp.host"));
        this.props.put("mail.smtp.socketFactory.port", rb.getString("mail.smtp.socketFactory.port"));
        this.props.put("mail.smtp.socketFactory.class", rb.getString("mail.smtp.socketFactory.class"));
        this.props.put("mail.smtp.auth", rb.getString("mail.smtp.auth"));
        this.props.put("mail.smtp.port", rb.getString("mail.smtp.port"));
        }

        public void sendMail(){
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username,password);
                }
            });

            try {
                Message message = new MimeMessage(session);
                //от кого
                message.setFrom(new InternetAddress(username));
                //кому
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                //тема сообщения
                message.setSubject(subject);
                //текст
                message.setText(text);

                //отправляем сообщение
                Transport.send(message);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }

    public static void main(String[] args) throws MessagingException {
            MailSender sender = new MailSender("nadyasavchenko12@gmail.com", "Проба", "Проба");
            sender.sendMail();

    }

}
