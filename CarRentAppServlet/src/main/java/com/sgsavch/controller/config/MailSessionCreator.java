package com.sgsavch.controller.config;

import com.sgsavch.controller.Servlet;
import org.apache.log4j.Logger;

import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
public class MailSessionCreator {
    private static final Logger log = Logger.getLogger(MailSessionCreator.class);

    private String smtpHost;
    private String smtpPort;
    private String userName;
    private String userPassword;
    private Properties sessionProperties;
    public MailSessionCreator(Properties configProperties) {
        smtpHost = configProperties.getProperty("mail.smtp.host");
        smtpPort = configProperties.getProperty("mail.smtp.port");
        userName = configProperties.getProperty("mail.user.name");
        userPassword = configProperties.getProperty("mail.user.password");

        //loading of post server parameters to post session properties
        sessionProperties = new Properties();
        sessionProperties.setProperty("mail.transport.protocol", "smtp");
        sessionProperties.setProperty("mail.host", smtpHost);
        sessionProperties.put("mail.smtp.auth", "true");
        sessionProperties.put("mail.smtp.port", smtpPort);
        sessionProperties.put("mail.smtp.socketFactory.port", smtpPort);
        sessionProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        sessionProperties.put("mail.smtp.socketFactory.fallback", "false");
        sessionProperties.setProperty("mail.smtp.quitwait", "false");

    }
    public Session createSession() {
        return Session.getDefaultInstance(sessionProperties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(userName, userPassword);
                    }
                });
    }
}
