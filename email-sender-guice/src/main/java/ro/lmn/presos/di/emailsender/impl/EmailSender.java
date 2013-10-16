package ro.lmn.presos.di.emailsender.impl;

import java.util.Collections;

import javax.inject.Inject;

import ro.lmn.presos.di.emailsender.api.RecipientFinder;
import ro.lmn.presos.di.emailsender.api.SmtpService;
import ro.lmn.presos.di.emailsender.api.TextFormatter;

public class EmailSender {

    private final SmtpService smtpService;
    private final TextFormatter textFormatter;
    private final RecipientFinder recipientFinder;

    @Inject
    public EmailSender(SmtpService smtpService, TextFormatter textFormatter,
            RecipientFinder recipientFinder) {
        this.smtpService = smtpService;
        this.textFormatter = textFormatter;
        this.recipientFinder = recipientFinder;
    }

    public void sendMail(String subject, String template) {

        for (String recipient : recipientFinder.findRecipients()) {
            String finalText = textFormatter.formatText(template,
                    Collections.singletonMap("product", "v1agRa"));
            smtpService.send(recipient, subject, finalText);
        }
    }
}
