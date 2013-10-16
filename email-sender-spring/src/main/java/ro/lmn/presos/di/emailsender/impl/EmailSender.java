package ro.lmn.presos.di.emailsender.impl;

import java.util.Collections;

import javax.inject.Inject;

import ro.lmn.presos.di.emailsender.api.RecipientFinder;
import ro.lmn.presos.di.emailsender.api.SmtpService;
import ro.lmn.presos.di.emailsender.api.TextFormatter;

public class EmailSender {

    private SmtpService smtpService;
    private TextFormatter textFormatter;
    private RecipientFinder recipientFinder;
    
    @Inject
    public void setSmtpService(SmtpService smtpService) {
        this.smtpService = smtpService;
    }
    
    @Inject
    public void setRecipientFinder(RecipientFinder recipientFinder) {
        this.recipientFinder = recipientFinder;
    }
    
    @Inject
    public void setTextFormatter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    public void sendMail(String subject, String template) {
        
        for ( String recipient : recipientFinder.findRecipients() ) {
            String finalText = textFormatter.formatText(template, Collections.singletonMap("product", "v1agRa"));
            smtpService.send(recipient, subject, finalText);
        }
    }
}
