package ro.lmn.presos.di.emailsender.impl.osgi;

import java.util.Collections;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;

import ro.lmn.presos.di.emailsender.api.RecipientFinder;
import ro.lmn.presos.di.emailsender.api.SmtpService;
import ro.lmn.presos.di.emailsender.api.TextFormatter;

@Component(immediate = true)
public class EmailSender {

    @Reference
    private SmtpService smtpService;
    @Reference
    private TextFormatter textFormatter;
    @Reference
    private RecipientFinder recipientFinder;
    
    
    protected void bindSmtpService(SmtpService smtpService) {
        this.smtpService = smtpService;
    }
    
    protected void bindRecipientFinder(RecipientFinder recipientFinder) {
        this.recipientFinder = recipientFinder;
    }
    
    protected void bindTextFormatter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    @Activate
    protected void activate() {
        sendMail("Hello, there", "We have modular $product ;-)");
    }
    
    public void sendMail(String subject, String template) {
        
        for ( String recipient : recipientFinder.findRecipients() ) {
            String finalText = textFormatter.formatText(template, Collections.singletonMap("product", "v1agRa"));
            smtpService.send(recipient, subject, finalText);
        }
    }
}
