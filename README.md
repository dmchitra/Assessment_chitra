# Assessment_chitra
 Assessment 

Web Automation Exercise

Develop a Web test solution that automates a scenario, composed as BDD scenarios. The target for the test is the dummy web site: https://testscriptdemo.com/ 

•Scenario 1: Add four items into the wishlist and add the low priced item into the cart

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Install the following
•JAVA SE 8 - Set Java_home and Path varibles
•Maven - version 3.3.1 or higher -Set Maven_home and Path varibles
•Eclise IDE -Eclipse Cucumber for Java plugin Steps to install
•Chrome - make sure to download the chrome driver based on the installed in the machine where the scripts are running

Running the tests

There are 2 way to run the tests:
1.Open the project in Eclipse navigate to src > test > resources > features to find the feature files, right click feature file, select Run As Cucumber feature to run all tests. To Run individuval scenario open feature file and right click on scenario line and select Run as Cucumber feature
2.Right click on the TestRunner class in the src/test/java under testrunner package and  Run As - > Junit Test

Improvements
 - Data can be parameterised using examples
 - Can implement dependency injection using spring boot reduces the every page object creation
 - Properties file can be used to externalise the hard coded parameters like url
 - Cross browser/plaform support can be enabled
 - Reporting part needs to be improved with screenshots
 - Multiple utilities can be created to reuse like parallel execution, Email Functionality, Jira connectivity, external testData reader etc.
 - Tests can be integrated with devops tools like jenkins to run in pipeline and in scheudled environment
