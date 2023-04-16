package com.campfireprojectv2.campfire.testSuiteBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSuiteGenerator {

	// ITEC-445: OBJ51-J. Minimize the accessibility of classes and their members, changed 
	// no arg constructor to private, since there is never a reason to instantiate it publicly
	/**
	 * 
	 */
	private TestSuiteGenerator() {
		// Prevent instantiation
	}
	
	
	/**
	 * @param ids
	 * @param packageName
	 * @param filename
	 * @return
	 */
	public static String generatePageFactory(Set<String> ids, String packageName, String filename) {
		StringBuilder sb = new StringBuilder();
		filename = toCamelCase(filename);
		packageName = firstLetterLower(toCamelCase(packageName));
		// map using key value pairs of dirty:clean ids
		Map<String, String> sanitized = drainDreck(ids);
		sb.append("package ").append(packageName).append(";\n\n");
		sb.append("import org.openqa.selenium.WebElement;\n");
		sb.append("import org.openqa.selenium.support.FindBy;\n\n");
		sb.append("public class ").append(filename).append(" {\n\n");

		for (Map.Entry<String,String> entry : sanitized.entrySet()) {
			sb.append("    @FindBy(id = \"").append(entry.getKey()).append("\")\n");
			sb.append("    private WebElement ").append(firstLetterLower(entry.getValue())).append(";\n\n");
		}

		sb.append("    public ").append(filename).append("() {\n");
		sb.append("        super();\n");
		sb.append("    }\n\n");

		for (Map.Entry<String,String> entry : sanitized.entrySet()) {
			sb.append("    public WebElement get").append(entry.getValue()).append("() {\n");
			sb.append("        return ").append(firstLetterLower(entry.getValue())).append(";\n");
			sb.append("    }\n\n");
		}

		sb.append("}");
		return sb.toString();
	}

	/**
	 * @param packageName
	 * @return
	 */
	public static String generateBaseController(String packageName) {
		packageName = firstLetterLower(toCamelCase(packageName));
		return "package " + packageName + ";\n\n" + "import org.openqa.selenium.By;\n"
				+ "import org.openqa.selenium.WebDriver;\n" + "import org.openqa.selenium.WebElement;\n"
				+ "import org.testng.annotations.AfterClass;\n" + "import org.testng.Reporter;\n"
				+ "import org.openqa.selenium.chrome.ChromeDriver;\n\n" + "public class BaseController {\n"
				+ "    private WebDriver driver;\n\n" + "    public BaseController(WebDriver driver) {\n"
				+ "        this.driver = driver;\n" + "    }\n\n"
				+ "    public void enterText(WebElement element, String text) {\n" + "        element.clear();\n"
				+ "        element.sendKeys(text);\n" + "    }\n\n"
				+ "    public void clickButton(WebElement button) {\n" + "        button.click();\n" + "    }\n\n"
				+ "    @AfterClass\n" + "    public void closeApplication()\n" + "    {\n" + "        driver.quit();\n"
				+ "        Reporter.log(\"=====Browser Session End=====\", true);\n\n" + "    }\n" + "}\n";
	}

	/**
	 * Method to generate the generic Test Class, note that the Chromedriver.exe
	 * file must be added to the folder where the files are located for the test to
	 * work
	 * 
	 * @param packageName
	 * @param pageClassName
	 * @param outputDirectory
	 * @param testUrl
	 * @return
	 */
	public static String generateTestClass(String packageName, String pageClassName, String outputDirectory,
			String testUrl) {
		pageClassName = toCamelCase(pageClassName);
		packageName = firstLetterLower(toCamelCase(packageName));
		
		StringBuilder sb = new StringBuilder();
		String pageClassInstanceName = firstLetterLower(pageClassName);

		sb.append("package ").append(packageName).append(";\n\n");
		sb.append("import org.openqa.selenium.WebDriver;\n");
		sb.append("import org.openqa.selenium.chrome.ChromeDriver;\n");
		sb.append("import org.testng.annotations.AfterMethod;\n");
		sb.append("import org.testng.annotations.BeforeMethod;\n");
		sb.append("import org.testng.annotations.Test;\n\n");
		sb.append("public class ").append(pageClassName).append("Test {\n\n");
		sb.append("    private WebDriver driver;\n");
		sb.append("    private ").append(pageClassName).append("Controller controller;\n\n");
		sb.append("    @BeforeClass\n");
		sb.append("    public void setUp() {\n");
		sb.append("        System.setProperty(\"webdriver.chrome.driver\", \"")
				.append(outputDirectory.replace("\\", "/")).append("/chromedriver.exe\");\n");
		sb.append("        driver = new ChromeDriver();\n");
		sb.append("        driver.manage().window().maximize();\n");
		sb.append("        driver.get(\"").append(testUrl).append("\");\n");
		sb.append("        ").append(pageClassInstanceName).append(" = new ").append(pageClassName)
				.append("(driver);\n");
		sb.append("    }\n\n");
		sb.append("    @Test\n");
		sb.append("    public void test() {\n");
		sb.append("        // Put methods here.\n");
		sb.append("    }\n\n");
		sb.append("    @AfterMethod\n");
		sb.append("    public void tearDown() {\n");
		sb.append("        driver.quit();\n");
		sb.append("    }\n");
		sb.append("}\n");

		return sb.toString();
	}

	/**
	 * Method to generate the PageController
	 * 
	 * @param packageName
	 * @param name
	 * @param ids
	 * @return
	 */
	public static String generatePageController(String packageName, String name, Set<String> ids) {
		name = toCamelCase(name);
		packageName = firstLetterLower(toCamelCase(packageName));
		
		String className = name + "Controller";
		
		String firstLetter = firstLetterLower(name);
		Map<String, String> sanitized = drainDreck(ids);

		StringBuilder sb = new StringBuilder();
		
		sb.append("package ").append(packageName).append(";\n\n");
		sb.append("import org.openqa.selenium.WebElement;\n\n");
		sb.append("public class ").append(className).append(" extends BaseController {\n\n");
		sb.append("    private ").append(name).append(" ").append(firstLetter).append(";\n\n");

		sb.append("    public ").append(className).append("(WebDriver driver) {\n");
		sb.append("        super(driver);\n");
		sb.append("        this.").append(firstLetter).append(" = new ").append(name).append("(driver);\n");
		sb.append("    }\n\n");

		for (Map.Entry<String,String> entry : sanitized.entrySet()) {
		
			sb.append("    public void click").append(entry.getValue()).append("() {\n");
			sb.append("        clickButton(").append(firstLetter).append(".get").append(entry.getValue())
					.append("());\n");
			sb.append("    }\n\n");

			sb.append("    public void enter").append(entry.getValue()).append("(String value) {\n");
			sb.append("        enterText(").append(firstLetter).append(".get").append(entry.getValue())
					.append("(), value);\n");
			sb.append("    }\n\n");
		}

		sb.append("}");
		return sb.toString();
	}


	private static String firstLetterLower(String input) {
	    if (input == null || input.isEmpty()) {
	        return input;
	    }

	    return input.substring(0, 1).toLowerCase() + input.substring(1);
	}
	
	private static String toCamelCase(String input) {
	    StringBuilder sb = new StringBuilder();
	    boolean capitalize = false;
	    for (char c : input.toCharArray()) {
	        if (Character.isLetterOrDigit(c)) {
	            sb.append(capitalize ? Character.toUpperCase(c) : c);
	            capitalize = false;
	        } else {
	            capitalize = true;
	        }
	    }
	    return sb.toString();
	}

	
//	 ITEC-445:  SEC01-J Do not allow tainted variables in privileged blocks.
//	 Since this data is passed into a Selenium test as a Java variable, the data should
//	 be sanitized to remove any special characters.
	/**
	 * issue with special characters in the id... this method removes them,
	 * capitalizing the next letter; also runs a check to ensure the first character
	 * is not a number
	 * 
	 * @param input
	 * @return Map<String, String> sanitized
	 */	
	private static Map<String, String> drainDreck(Set<String> input) {
	    Map<String, String> sanitized = new HashMap<>();
	    
	    // ITEC-445 MSC06-J Do not modify the underlying collection while iteration is in progress
	    // I changed this from an iterator to a for loop to avoid modifying the collection during 
	    // iteration
	    // creates a map of dirty/clean key/value pairs
	    for (String dirty : input) {
	    	// ITEC-445 IDS08-J Sanitize untrusted data included in a regular expression
	    	// Originally this method used a REGEX and Pattern + Matcher to 'clean' the data,
	    	// after review of this standard, I changed it to not used regular expressions,
	    	// since the data is coming straight from the user
	        String clean = toCamelCase(dirty);
	        
	        if (clean.length() > 0 && Character.isDigit(clean.charAt(0))) {
	            clean = digitToWord(clean.charAt(0)) + clean.substring(1);
	        }
	        
	        sanitized.put(dirty, clean);
	    }

	    return sanitized;
	}

	// ITEC-445 STR03-J Do not encode non-character data as string
    // The following is used to ensure that numbers are spelled out,
	// instead of encoded as a string - Note: in this case I have 
	// only used it to ensure the first letter is not a number, 
	// since the method that calls this is creating a Java variable
	private static String digitToWord(char digit) {
		switch (digit) {
		case '0':
			return "zero";
		case '1':
			return "one";
		case '2':
			return "two";
		case '3':
			return "three";
		case '4':
			return "four";
		case '5':
			return "five";
		case '6':
			return "six";
		case '7':
			return "seven";
		case '8':
			return "eight";
		case '9':
			return "nine";
		default:
			return "";
		}
	}
}
