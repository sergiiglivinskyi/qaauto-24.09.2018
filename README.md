# Automation Framework setup guide (for Mac)

## Download the following components:


1. Go to [Jetbrains official site](https://www.jetbrains.com/idea/download/#section=mac){:target="_blank"} and download IntelliJ IDEA app -
Community version.

2. Go to [Oracle official site](http://www.oracle.com/technetwork/java/javase/downloads/index.html){:target="_blank"} and download JDK package:

    * Click on JDK Download button (latest version can be used)

    * Click on Accept License Agreement and download JDK package for Mac

3. Download FireFox Browser and make sure it has the latest version

4. Go to [Geckodriver](https://github.com/mozilla/geckodriver/releases){:target="_blank"} and download the latest version geckodriver

## Tools Setup:

### Project and Selenium Web Driver Setup:

1. Install JDK package

2. Install IntelliJ IDEA application

3. Install FireFox Browser

4. Launch IntelliJ IDEA, create New Project, select Maven, select JDK installed version 

5. Go to [Maven Repository](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.11.0){:target="_blank"}, then click on 
Maven tab and copy internal text (it is needed for Selenium setup)

6. Paste copied text to pom.xml file (using this file you can configure/install any tools and libraries for your project according to your needs)

7. Go to IntelliJ IDEA --> View --> Check On the following: Tool Buttons

8. Click on Maven Project tool bar in the right side and double click on Install item (Selenium Components have been installed)

### Gekodriver Setup:

1. Unpack Gekodriver archive

2. Use the following instructions in the Terminal:

        echo $PATH
        /usr/local/bin/
        mv /Users/Sergii/Downloads/geckodriver /usr/local/bin/geckodriver

### .gitignore file usage:

.gitignore file can be used for determining the files which should not be pushed to the repository. 
For that purposes it is needed to enter just their names into .gitignore file


## How to Run the test:

1. Go to /src/main/java/BadCodeExample

2. Right click on **MAIN** method and select **Run BadCodeExample.main()** 