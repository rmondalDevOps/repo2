SET projectLocation=C:\Automation\Workspace\WorkflowManager
CD %projectLocation%
SET classpath=%projectLocation%\bin;C:\Automation\Workspace\WorkflowManager\Alljars\AllJar\*
java -Ddashboard="true" org.testng.TestNG %projectLocation%\Edge_TestNG.xml
PAUSE
