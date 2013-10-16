package ro.lmn.presos.di.emailsender.impl;

import ro.lmn.presos.di.emailsender.api.RecipientFinder;
import ro.lmn.presos.di.emailsender.api.SmtpService;
import ro.lmn.presos.di.emailsender.api.TextFormatter;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class EmailModule extends AbstractModule {
    
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new EmailModule());
        
        injector.getInstance(EmailSender.class).sendMail("Hello there", "Care for some quality $product?");
    }

    @Override
    protected void configure() {
        bind(SmtpService.class).to(DebuggingSmtpService.class);
        bind(TextFormatter.class).to(DoNothingTextFormatter.class);
        bind(RecipientFinder.class).to(InMemoryRecipientFinder.class);
        bind(EmailSender.class);
    }
}
