# UI-test And API Test

Both assessments were completed the BDD (Behavior-Driven Development) approach framework project using Cucumber and Java to perform selenium automation and rest assured tests.


# Prerequisites 

- IntelliJ (Or any IDE with Java capabilities)
- Java JDK {preferrably the latest update}
- Download a Selenium Webdriver (geckodriver or chromedriver etc)
- Maven (Basic Knowledge of working with POM.xml files)
- Java knowledge
- TestNG Plugin (Installed using the Eclipse Market)
- A working computer. :)

# Steps
- Clone project to your machine
- Change the **webdriver location** to your workspace's webdriver. Go to the following java file: 

/src/test/java/Utilities/SeleniumUtilities.java

**webdriver options: **

# Chrome driver (Google Chrome)
public void setup() {
		System.setProperty("webdriver.chrome.driver", "**/usr/local/bin/chromedriver**");
    
or 

# Geckodriver (firefox)
public void setup() {
		System.setProperty("webdriver.geckodriver", "**/usr/local/bin/geckodriver**");
  
  # For the API test
  
* Once loaded, go to the Pom file in the project.
* Complete the Maven lifecycle (Clean, Build, Install).
* Update the maven project

    
# To Run project
Navigate to the TestRunner.java file

 CucumberSelenium/src/test/java/StepDefinitions/TestRunner.java
