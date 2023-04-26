# campfire_public
# Campfire Stories is an easy to use web application which allows the user to scrape websites for id tags and builds a 
# robust Selenium test suite which is complete with a page factory, controller, base controller, and bare-bones test case.
# Designed to use minimal resources, the main requirements are an internet connection and a small amount of hard drive space 
# to store the program and the tests cases it generates. 
# CLI Deployment
# Git Bash or some other local implementation of git should be installed.
# A recent version of Apache-Maven is necessary, I am using Maven 3.9.1.
# Create a directory on your computer where you would like the application to be stored.
# Type in the CLI (or clone using whatever implementation of git you use):
#
#	clone https://github.com/Willzy-75/campfire_public.git
#	
# Next, change directories into the campfire_public directory:
#
# cd /campfire_public
#
# Use the following command to build the application:
#	
# mvn install	
#
# Then use Maven to start the program:
#	
# mvn spring-boot:run	
#
# At this point the application will be running and a web browser can be opened, using the url:
#
#	http://localhost:8080/
#
# Now the user is presented with a security screen
# Success!
# 
# Using the Application
# Logging in and Basic navigation
# There are several usernames and passwords built into the application: 
# Username    Password
# Will	      Test
# Client	    Test
# Tester	    Test
# Developer	  Test
# Engineer	  Test
#
# At a later date, these users may be granted specific privileges. However, at this time, all users have the same access.
# To begin using Camfire Stories enter one of the usernames and related passwords into the prompt, then click the Sign in button.
# The landing / home page is menu-driven and contains several elements for ease of use
#
# The navigation bar at the top of the screen has quick links to each tool. The navigation bar is always visible. Note that 
# the Home button returns the user to this landing page.
# On the far right side of the navigation bar, there is a button which allows the user to Logout. 
# Below the welcome banner, the tools are listed again with links allowing the user to jump to each tool.
# 
# The Tools
# To Do Application
# The first tool is a basic To-Do application. This allows the user to create a list of items they would like to accomplish. 
#
# The To Do tool has several fields: 
# •	Name: the name is prefilled with the username who is currently signed in.
# •	Description: allows a brief description of the task.
# •	Target Date: is the due date.
# •	Done: allows the user to mark a task as complete.
# There are several buttons as well:
# •	Add Todo: allows the user to create a new reminder. 
# •	Delete: is used to delete any unneeded or completed tasks.
# •	Update: provides an interface to update an existing reminder.
# As always, the navigational bar is available at the top of the screen allowing a user to move to a different tool, 
# logout, or return to the home page.
# 
# Users View
# This is a screen which has not been fully implemented yet, but will eventually allow users with admin credentials to 
# provide access to other users. At this time, the list is empty and is there solely as a placeholder.
# 
# User Stories Tool
# This tool provides the user with a tool to record and store user stories. There are several fields and buttons as with 
# the To Do tool, which allow the user to Add, Delete, and Update user stories. Fields are provided to ensure the user captures 
# the three important questions of: who (Persona), what (What to do?), and why (Why to do it?). The tool also tracks the user 
# who enters the user story (Name), whether the user story is able to be updated (Editable?), a user defined Complexity, and the 
# URL if one is associated with the request.
#
# URL ID Scraper Tool
# The ID Scraping Tool allows a user to enter a URL and provides a convenient way to Add, Delete, and Update the URLs. 
# However, there is an additonal button to Run ID Scraper next to each URL listed. When this button is pressed it will 
# check the URL and uses a method to scrape all of the HTML ID tags and lists them below.
#
# This tool is especially useful when used in conjunction with the Test Suite Creator tool. It can provide insight on what 
# ID tags are listed and how large the test suite files will be. 
# 
# Test Suite Creator Tool
# This tool is used to create a full Selenium suite for use when developing tests for websites. 
# There are several fields including:
# •	Name: the name of the test suite, naming conventions vary, but the websites name or page is appropriate
# •	Package name: this is the name of the Java package to be used when generating the test suite
# •	URL: provides a field to enter the URL of the web page the user wishes to test
# •	Output Directory: the location where the files should be saved after they are generated
# •	Base Controller Needed checkbox: only one base controller is needed per test suite, since the other controllers for each 
# webpage, inherit from the base controller class; this checkbox allows the user to opt out of generating one if they have 
# already created it before. If the box is checked, then the Base Controller is created.
# •	Submit Button: once the Submit button is pressed, the test files will be generated and saved to the location specified 
# in the Output Directory field.
# 
# The following test files are created as part of the testing suite:
# •	Page Factory: this file contains private web elements for each ID, public getters for each web element, 
#   and a no argument construtor.
# •	Base Controller: this file contains methods which are used by all of the controllers in the test suite, including click 
#   and enter text. Other methods are being developed and will be added as they are completed.
# •	Page Controller: this file inherits the methods from the Base Controller, and implements both click and enter text on each
#   web element scraped from the ID tags, as well as a private implementation of the Page Factory object, and a constructor.
# •	Test File: this is a generic test file, which provides a simple private instance of the Chromedriver web driver using and 
#   a private instance of the related Page Controller, an @BeforeClass method, an @Test method (which has a place for the user
#   to add various methods as created in the Page Controller), and an @AfterMethod to tear down the test upon completion. 
#
# Notes on large websites: after border testing the application with large websites with 50+ ID tags on one page, the developer 
# recommends using the URL ID Scraper tool to check how many ID tags are present and would caution to only use the Test Suite 
# Generator on webpages with less than 40 ID tags. 
# 
# Legal Disclaimer
# THIS PROGRAM, CAMPFIRE STORIES, IS FREE SOFTWARE. THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
# OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, TITLE AND 
# NON-INFRINGEMENT. IN NO EVENT SHALL THE DEVELOPERS OR ANYONE DISTRIBUTING THE SOFTWARE BE LIABLE FOR ANY DAMAGES OR OTHER
# LIABILITY, WHETHER IN CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
# OTHER DEALINGS IN THE SOFTWARE.

