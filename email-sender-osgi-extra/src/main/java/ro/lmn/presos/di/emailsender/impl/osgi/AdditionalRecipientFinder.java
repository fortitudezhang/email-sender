package ro.lmn.presos.di.emailsender.impl.osgi;

import java.util.Arrays;
import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import ro.lmn.presos.di.emailsender.api.RecipientFinder;

@Component
@Service
public class AdditionalRecipientFinder implements RecipientFinder {

    public List<String> findRecipients() {
        return Arrays.asList("robert@muntea.nu", "rmuntean@adobe.com");
    }

}
