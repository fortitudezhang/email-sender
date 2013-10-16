package ro.lmn.presos.di.emailsender.impl.osgi;

import java.util.Map;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import ro.lmn.presos.di.emailsender.api.TextFormatter;

@Component
@Service
public class DoNothingTextFormatter implements TextFormatter {

    public String formatText(String template, Map<String, String> vars) {
        for ( Map.Entry<String, String> entry : vars.entrySet() )
            template = template.replace("$"+entry.getKey(), entry.getValue());
        return template;
    }

}
