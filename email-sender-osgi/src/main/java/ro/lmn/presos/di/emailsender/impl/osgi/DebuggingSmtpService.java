package ro.lmn.presos.di.emailsender.impl.osgi;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import ro.lmn.presos.di.emailsender.api.SmtpService;

@Component
@Service
public class DebuggingSmtpService implements SmtpService {

    public void send(String recipient, String subject, String body) {

        System.out.println("EMAIL to " + recipient + " : " + subject + "\n\n" + body);
    }

}
