package ro.lmn.presos.di.emailsender.impl;

import java.util.Map;

import ro.lmn.presos.di.emailsender.api.TextFormatter;

public class DoNothingTextFormatter implements TextFormatter {

    public String formatText(String template, Map<String, String> vars) {
        for ( Map.Entry<String, String> entry : vars.entrySet() )
            template = template.replace("$"+entry.getKey(), entry.getValue());
        return template;
    }

}
