/**
 * Copyright (C) 2013 Robert Munteanu (robert@lmn.ro)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ro.lmn.presos.di.emailsender.impl.spring;

import java.util.Collections;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import ro.lmn.presos.di.emailsender.api.RecipientFinder;
import ro.lmn.presos.di.emailsender.api.SmtpService;
import ro.lmn.presos.di.emailsender.api.TextFormatter;

@Component
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
