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
package ro.lmn.presos.di.emailsender.impl.osgi;

import static org.apache.felix.scr.annotations.ReferenceCardinality.MANDATORY_MULTIPLE;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.ReferencePolicyOption;
import org.apache.felix.scr.annotations.Service;

import ro.lmn.presos.di.emailsender.IEmailSender;
import ro.lmn.presos.di.emailsender.api.RecipientFinder;
import ro.lmn.presos.di.emailsender.api.SmtpService;
import ro.lmn.presos.di.emailsender.api.TextFormatter;

@Service(IEmailSender.class)
@Component
public class EmailSender implements IEmailSender {

    @Reference
    private SmtpService smtpService;

    @Reference
    private TextFormatter textFormatter;

    @Reference(policyOption = ReferencePolicyOption.GREEDY, cardinality = MANDATORY_MULTIPLE, policy = ReferencePolicy.DYNAMIC, referenceInterface = RecipientFinder.class)
    private List<RecipientFinder> recipientFinder = new CopyOnWriteArrayList<RecipientFinder>();
    
    protected void bindSmtpService(SmtpService smtpService) {
        this.smtpService = smtpService;
    }
    
    protected void bindRecipientFinder(RecipientFinder recipientFinder) {
        this.recipientFinder.add(recipientFinder);
    }

    protected void unbindRecipientFinder(RecipientFinder recipientFinder) {
        this.recipientFinder.remove(recipientFinder);
    }
    
    protected void bindTextFormatter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    public void sendMail(String subject, String template) {
        
        for ( RecipientFinder finder : recipientFinder ) {
            for ( String recipient : finder.findRecipients() ) {
                String finalText = textFormatter.formatText(template, Collections.singletonMap("product", "v1agRa"));
                smtpService.send(recipient, subject, finalText);
            }
        }
    }
}
