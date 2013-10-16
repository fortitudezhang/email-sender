package ro.lmn.presos.di.emailsender.api;

public interface SmtpService {
    
    void send(String recipient, String subject, String body);

}
