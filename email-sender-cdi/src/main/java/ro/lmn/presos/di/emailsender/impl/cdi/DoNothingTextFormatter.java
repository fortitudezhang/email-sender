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
package ro.lmn.presos.di.emailsender.impl.cdi;

import java.util.Map;

import javax.inject.Singleton;

import ro.lmn.presos.di.emailsender.api.TextFormatter;

@Singleton
public class DoNothingTextFormatter implements TextFormatter {

    public String formatText(String template, Map<String, String> vars) {
        for ( Map.Entry<String, String> entry : vars.entrySet() )
            template = template.replace("$"+entry.getKey(), entry.getValue());
        return template;
    }

}
