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
