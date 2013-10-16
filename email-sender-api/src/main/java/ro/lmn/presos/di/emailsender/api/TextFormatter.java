package ro.lmn.presos.di.emailsender.api;

import java.util.Map;

public interface TextFormatter {

    String formatText(String template, Map<String, String> vars);
}
