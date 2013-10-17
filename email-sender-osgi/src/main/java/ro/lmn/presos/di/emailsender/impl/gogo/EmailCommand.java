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
package ro.lmn.presos.di.emailsender.impl.gogo;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.service.command.Descriptor;

import ro.lmn.presos.di.emailsender.IEmailSender;

@Component
@Service(EmailCommand.class)
@Properties({
    @Property(name="osgi.command.scope", value="email"),
    @Property(name="osgi.command.function", value= {"send"})
})
public class EmailCommand {
    
    @Reference
    private IEmailSender sender;

    @Descriptor("sends emails")
    public void send() {
        
        sender.sendMail("Hello, bub", "Want some cheap $product?");
    }
}
