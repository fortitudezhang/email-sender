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
package ro.lmn.presos.di.emailsender.impl.guice;

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
