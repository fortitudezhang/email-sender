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
