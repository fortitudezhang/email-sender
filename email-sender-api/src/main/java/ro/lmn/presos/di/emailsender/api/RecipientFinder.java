package ro.lmn.presos.di.emailsender.api;

import java.util.List;

public interface RecipientFinder {

    List<String> findRecipients();
}
