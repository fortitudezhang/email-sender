Dependency Injection showcase - Email Sender App
===

Spring
--

Execute `ro.lmn.presos.di.emailsender.impl.spring.EmailSenderApp` in the email-sender-spring module.

Guice
--

Execute `ro.lmn.presos.di.emailsender.impl.guice.EmailModule` in the email-sender-guice module.

OSGi
--

Using [pax-runner](http://google.com) , execute `pax-run scan-file:file:pax.bundles`.

Use `email:send` to send emails. To add a new RecipientFinder in the fly, find out which bundle is stopped

	g! lb
	START LEVEL 6
	   ID|State      |Level|Name
	    0|Active     |    0|System Bundle (4.0.3)
	    1|Active     |    5|email-sender-api (0.0.1.SNAPSHOT)
	    2|Active     |    5|email-sender-osgi (0.0.1.SNAPSHOT)
	    3|Active     |    2|Apache Felix Declarative Services (1.6.2)
	    4|Installed  |    5|email-sender-osgi-extra (0.0.1.SNAPSHOT)
	    5|Active     |    1|Apache Felix Gogo Command (0.12.0)
	    6|Active     |    1|Apache Felix Gogo Runtime (0.10.0)
	    7|Active     |    1|Apache Felix Gogo Shell (0.10.0)

and start it using `g! start 4`. Use `email:send` to send emails again, and see the different output.