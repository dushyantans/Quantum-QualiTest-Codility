
![CircleCI status](https://circleci.com/gh/Perfecto-Quantum/Quantum-Starter-Kit.svg?style=shield "CircleCI status")

# Quantum Starter Kit
This Quantum starter kit is designed to get you up and running using the Quantum framework (sponsored by [Perfecto](https://www.perfecto.io) and powered by [QAF](https://github.com/qmetry/qaf)) within few simple steps, and enable you to start writing your tests using simple [Cucumber] (https://cucumber.io/).

Begin with installing the dependencies below, and continue with the Getting Started procedure below.

### Dependencies
There are several prerequisite dependencies you should install on your machine prior to starting to work with Quantum:

* [Java 8](https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html)

* An IDE to write your tests on - [Eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/marsr) or [IntelliJ](https://www.jetbrains.com/idea/download/#)

* [Maven](https://maven.apache.org/) (Optional - Needed only for command line executions as IDEs have Maven in-built.)

* Download the necessary app files from [here](https://github.com/PerfectoMobileSA/PerfectoJavaSample/tree/master/libs), upload it to your Perfecto Media Repository and configure that locator path to driver.capabilities.app capability in your testng xml file.

Eclipse users should also install:

1. Eclipse has in-built Maven plugin 
    - Optional - [Maven Plugin](http://marketplace.eclipse.org/content/m2e-connector-maven-dependency-plugin)

2. [TestNG Plugin](http://testng.org/doc/download.html)

3. QAF BDD Plugin - Or go to install new software option in eclipse, and download from this url https://qmetry.github.io/qaf/editor/bdd/eclipse/
    In case, of network constraints, one can follow the instruction mentioned in [QAF BDD Offline](https://developers.perfectomobile.com/display/PD/Quantum+framework+introduction#expand-InstallanofflineversionoftheQAFBDDplugininEclipse)

IntelliJ IDEA users should also install:

1. [Cucumber Plugin (Community version only)](https://plugins.jetbrains.com/plugin/7212)
    - In case after installing the above plugin you are still not able to navigate to the step definition code then install this plugin -               [Cucumber for Groovy Plugin](https://plugins.jetbrains.com/plugin/7213-cucumber-for-groovy)

TestNG Plugin is built-in in the IntelliJ IDEA, from version 7 onwards.
 
#### Optional Installations
* For source control management, you can install [git](https://git-scm.com/downloads).

## Downloading the Quantum Project

Download this repository.

After downloading and unzipping the project to your computer, open it from your IDE by choosing the folder containing the pom.xml file.

Project directory structure is documented in the end of this page.

**********************
# Getting Started

This procedure leads you through the various Quantum framework's aspects:


## Running sample as is
Run a single Quantum sample from the samples provided in the Starter Kit.

The samples are located under the _src/main/resources/scenarios_ folder.

From Eclipse: 
1. Run your test via the right-click menu while hovering on the testng_desktop_web.xml file in the src/main/resources/config folder

From Terminal/Command Prompt:
2. Open Terminal(Mac) or Command Prompt(Windows), run 'mvn clean install' 



**********************

# Project Directory Structure
```
.
│   pom.xml                                                 # Maven pom file for build and dependencies  
│   README.md                                               # The current readme file  
│  
├───resources                                               # Default resources dir  
│       application.properties                              # set credentials and other project properties  
│  
└───src												   		
    └───main  
        ├───java                                            # All code for project inside java directory  
        │   └───com  
        │       └───quantum                                 # com.quantum namespace  
        │           ├───java                                # Package namespace for pure java tests  
        │           │   └───pages                           # Package for Java test Page Object Models  
        │           │           MainscreenTestPage.java     # Example POM  
        │           │  
        │           └───steps                               # Package namespace for Gherkin/Cucumber step definitions  
        │                   ExpenseTrackerSteps.java        # Step definitions for appium feature file  
        │                   GoogleStepDefs.java             # Step definitions for webSearch feature file  
        │  
        └───resources                                       # All project specific files here  
            │   assertMessages.properties                   # Property definitions used in qaf library AssertionService class  
            │   log4j.properties                            # Controls all logging to console and log files  
            │  
            ├───android                                     # Additional Android properties. Specified in testng_appium file.  
            │       env.properties                          # Android specific additional environment variables  
            │       expensetracker.loc                      # Android specific object locators for appium test objects  
            │  
            ├───common                                      # Common resources dir. Set with env.resources in application.properties  
            │       search.loc                              # Common object locators used in webSearch feature file  
            │       testdata.xml                            # Data used in xml scenario in webSearch feature  
            │  
            ├───config                                      # TestNG xml test file directory  
            │       testng_appium.xml                       # TestNG file that runs appium feature file with @appium tag  
            │       testng_web.xml                          # TestNG file that runs webSearch feature file with @Web tag  
            │  
            ├───data                                        # Data used in data driven tests stored here  
            │       testData.csv                            # csv data file used in csv webSearch scenario  
            │       testData.json                           # example of json data file  
            │       testData.xls                            # example of Excel data file  
            │  
            ├───ios                                         # Addition iOS properties. Specified in testng_appium file.  
            │       env.properties                          # iOS specific additional environment properties  
            │       expensetracker.loc                      # Android specific object locators for appium test objects  
            │  
            └───scenarios                                   # Cucumber/Gherkin feature files directory  
                    appium.feature                     	   # Appium test feature file called by testng_appium xml file  
                    webSearch.feature                       # Web Google Search feature file driven by testng_web xml file  
``` 
