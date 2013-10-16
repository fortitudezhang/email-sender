package ro.lmn.presos.di.emailsender.impl.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ro.lmn.presos.di.emailsender.api.RecipientFinder;
import ro.lmn.presos.di.emailsender.api.SmtpService;
import ro.lmn.presos.di.emailsender.api.TextFormatter;

@Configuration
public class EmailSenderApp {
    
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(EmailSenderApp.class);
        context.getBean(EmailSender.class).sendMail("Hello there", "Buy cheap $product");
    }

    @Bean
    public SmtpService smtpService() {
        return new DebuggingSmtpService();
    }
    
    @Bean
    public RecipientFinder recipientFinder() {
        return new InMemoryRecipientFinder();
    }
    
    @Bean
    public TextFormatter textFormatter() {
        return new DoNothingTextFormatter();
    }
    
    @Bean
    public EmailSender emailSender() {
        
        return new EmailSender();
    }
}
