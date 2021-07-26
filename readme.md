PatientPop Assignment
---------------------
This test automation framework built using Serenity BDD framework following Page Object Model and Behavior Driven Development strategy in which tests are, specified in terms of the desired behavior of the unit. This framework is using Serenity Screenplay, Cucumber, Junit, AssertJ libraries which helps to write better structured, more maintainable automated acceptance criteria, and also produces rich meaningful test reports that not only reports test results, but also what features have been tested.

Section A.1 and Section A.2 of assignment covered in first scenario outline of "PracticeGrowthResults.feature" file. 
Section A.3 fail test covered in "PracticeGrowthResults.feature" file. 
Section A.4 is covered using runtime param "env", details to use it, is, described in Run/Execute section below. 
Extra tests needed as part of Section B are covered in both "PracticeGrowthResults.feature" and "ScheduleConsultation.feature" files and tagged as such.

Getting Started
---------------
Framework can be accessed from git using: https://github.com/pavitrajain/PatientPop

Prerequisites
-------------
Below are the tools that needs to be installed:
1. JAVA: Install JDK 8 and set up JAVA_HOME environment variable
2. MAVEN: Install MAVEN and set up MAVEN_HOME environment variable
3. IDE: Install any IDE, intellJ is preferred. Cucumber plugin also needs to be installed to work with feature files.


Automation framework consists of 2 parts:
1.  Base Framework:
    ---------------
        Base Framework handles following tasks:
            a. Project/Environment Configuration
            b. Logging


2.  Test / Test Cases / Test Scripts:
    ---------------------------------
            1. Test cases defined in feature files which are present under test/resources/features
            2. stepDefinitions package under test/java has corresponding feature steps implementation
            3. actor package under test/java has class which has all the application navigation/performing step methods
            4. pages package under test/java has all Page Classes for the application
            5. runner package under test/java has runner class. This is a JUNIT runner class use to trigger the test written in feature file following BDD (serenity-cucumber). 
            6. resources/config directory has project properties for different environment like dev/qa/stg. Default is set to stg.
            7. resources/drivers directory has browser driver file.
            8. resources/features directory has feature files. As of now 2 feature files are created:
                a. PracticeGrowthResults.feature: This file has Section A.1 and Section A.2 of assignment tagged as @SectionA1 @SectionA2. Section A.3 is also covered here as tagged as @SectionA3 this test intentionally failed, incorrect expected error message is used in verification. Also, this feature file has 2 more test marked as @SectionB which are extra test added but not yet automated and will be reported in pending status in test result.
                b. ScheduleConsultation.feature: This file has test for Section B, which are added but not yet automated. Also, these will be reported as pending in test result.
            9. serenity.properties file under project root directory has all the necessary serenity required properties. There no explicit code needed to manage browser, as this web test related boiler plate code is covered already by serenity-core library.
                
            

Run/Execute:
------------
Download and import the codebase as a maven project. Make sure to set workspace Java compiler to JDK 1.8.
After import, Right-Click on pom.xml and select Build Module 'PatientPop'. This will download all the dependencies and build the project.

Command to execute test:-
mvn clean verify [Optional: env]

Optional Parameter: env -
This is optional parameter will help is providing test environment that can be used for testing, as required for Section A.4 of assignment.
Possible Values are:
dev
qa
stg [Default]

There are 3 properties files under test/resources/config directory which are created to provide environment specific variables like application url.

e.g for usage:
1. mvn clean verify -Dpin=stg
2. mvn clean verify -Dpin=qa
3. mvn clean verify

Report:
-------
    Report is generated in target/site/report directory, with filename index.html. This may be accessed using any available browser e.g. Chrome.

Logs:
-----
    Logs are generated in target/log directory which are overwritten just like report every time after execution.

Resources:
----------
1. Cucumber: https://cucumber.io/school
2. Tools QA: http://toolsqa.com/cucumber/cucumber-tutorial/
3. Testing Excellence: https://www.testingexcellence.com/bdd-guidelines-best-practices/
4. Serenity: https://serenity-bdd.github.io/theserenitybook/latest/index.html
5. Engine Yard: https://www.engineyard.com/blog/15-expert-tips-for-using-cucumber
