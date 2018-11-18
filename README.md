# UIAutomation

Technical Stack details :

1. Build Tool : Maven
2. Design Pattern : Page Object Model
3. Language Binding : Java8
4. VCS : GIT
5. Reporting plugin : Extent 3.0
6. Selenium WebDriver 3.x
7. Test Framework : TestNG 6.14.3

Framework  Structure & details : 

1. src/main/test contains test package and listeners package(for Reporting and Retry mechanism)
2. src/main/java contains basesetup(Base), utility(screenshot utility and Property files manager and pages package(java class for every web page)
3. src/main/resources contains testdata.properties and executuables or drivers for browsers
4. testng.xml for triggering test suite with retry mechanism and listeners
5. TestReport folder for storing Extent html reports ( please see sample report inside the folder)
6. FailedTestsScreenshots folder for storing captured screenshots
7. pom.xml for dependency management and surefire plugin to execute tests

Technical constraints:

1. Multiple Browser support . The code supports Chrome, Firefox and IE Browsers
2. Run in windows and Linux(only for chrome) environments
3. Test suite is runnable from CLI.
4. Nice customised Html Report support with Extent plugin
5. Screenshot of web page on test failure
6. Retry mechanism by implementing Retry Listener ( whenever there is failure in tests, it runs again to confirm the failure)

How to run : 

1. Checkout the project to local 
2. open command prompt
3. Navigate to root directory

Important Note : There are 2 tests (one of them is purposely failed to illustrate the behaviour of failed test)

4. mvn clean
5. mvn test -Dbrowser=chrome to run it on chrome 64 bit(latest version)
6. mvn test -Dbrowser=firefox to run it on Firefox 63.0 -64 bit 

Note : As I didnot have enough hands-on knowledge on Docker setup and due to time and resource constraints ,I have not done docker integration.
