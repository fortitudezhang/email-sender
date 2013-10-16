package ro.lmn.presos.di.emailsender;

public interface IEmailSender {

    public abstract void sendMail(String subject, String template);

}