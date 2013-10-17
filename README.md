Dependency Injection showcase - Email Sender App
===

Prime the jars in the local repository by running `mvn install`, then inspect/execute each of the projects.

Spring
--

Execute `mvn -q exec:java` in the email-sender-spring module.

Guice
--

Execute `mvn -q exec:java` in the email-sender-guice module.

OSGi
--

Using [pax-runner](https://ops4j1.jira.com/wiki/display/paxrunner/Pax+Runner) , execute `pax-run` in the root directory.

Use `email:send` to send emails. To add a new RecipientFinder in the fly, find out which bundle is not started,
i.e. in the Installed state. 

	g! lb
	START LEVEL 6
	   ID|State      |Level|Name
	    0|Active     |    0|System Bundle (4.0.3)
	    1|Active     |    5|Email Sender - API (0.0.1.SNAPSHOT)
	    2|Active     |    5|Email Sender - OSGi implementation (0.0.1.SNAPSHOT)
	    3|Active     |    2|Apache Felix Declarative Services (1.6.2)
	    4|Installed  |    5|Email Sender - OSGi Extras (0.0.1.SNAPSHOT)
	    5|Active     |    1|Apache Felix Gogo Command (0.12.0)
	    6|Active     |    1|Apache Felix Gogo Runtime (0.10.0)
	    7|Active     |    1|Apache Felix Gogo Shell (0.10.0)

and start it using `g! start 4`. Use `email:send` to send emails again, and see the different output.