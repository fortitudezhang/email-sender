package ro.lmn.presos.di.emailsender.impl.guice;

import java.util.Arrays;
import java.util.List;

import ro.lmn.presos.di.emailsender.api.RecipientFinder;

public class InMemoryRecipientFinder implements RecipientFinder {

    public List<String> findRecipients() {
        return Arrays.asList("john@example.com", "joe@example.org");
    }

}
