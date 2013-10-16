package ro.lmn.presos.di.emailsender.impl.guice;

import ro.lmn.presos.di.emailsender.api.SmtpService;

public class DebuggingSmtpService implements SmtpService {

    public void send(String recipient, String subject, String body) {

        System.out.println("EMAIL to " + recipient + " : " + subject + "\n\n" + body);
    }

}
