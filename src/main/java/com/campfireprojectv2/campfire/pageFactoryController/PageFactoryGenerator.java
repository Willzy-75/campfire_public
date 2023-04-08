package com.campfireprojectv2.campfire.pageFactoryController;

import java.util.Set;
import java.io.File;

public class PageFactoryGenerator {

    public static String generatePageFactory(Set<String> ids, String packageName, String filename) {
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(packageName).append(";\n\n");
        sb.append("import org.openqa.selenium.WebElement;\n");
        sb.append("import org.openqa.selenium.support.FindBy;\n\n");
        sb.append("public class ").append(filename).append(" {\n\n");

        // Generate the instance variables and FindBy annotations
        for (String id : ids) {
            sb.append("    @FindBy(id = \"").append(id).append("\")\n");
            sb.append("    private WebElement ").append(drainDreck(id)).append(";\n\n");
        }

        sb.append("    public ").append(filename).append("() {\n");
        sb.append("    }\n\n");

       
        for (String id : ids) {
        	String idCamelCase = toCamelCase(id);
            sb.append("    public WebElement get").append(idCamelCase).append("() {\n");
            sb.append("        return ").append(drainDreck(id)).append(";\n");
            sb.append("    }\n\n");
        }

        sb.append("}");
        return sb.toString();
    }

    public static String generateBaseController(String packageName) {
        return "package " + packageName + ";\n\n"
                + "import org.openqa.selenium.By;\n"
                + "import org.openqa.selenium.WebDriver;\n"
                + "import org.openqa.selenium.WebElement;\n"
                + "import org.testng.annotations.AfterClass;\n"
                + "import org.testng.Reporter;\n"
                + "import org.openqa.selenium.chrome.ChromeDriver;\n\n"
                + "public class BaseController {\n"
                + "    private WebDriver driver;\n\n"
                + "    public BaseController(WebDriver driver) {\n"
                + "        this.driver = driver;\n"
                + "    }\n\n"
                + "    public void enterText(WebElement element, String text) {\n"
                + "        element.clear();\n"
                + "        element.sendKeys(text);\n"
                + "    }\n\n"
                + "    public void clickButton(WebElement button) {\n"
                + "        button.click();\n"
                + "    }\n\n"
                + "    @AfterClass\n"
                + "    public void closeApplication()\n"
                + "    {\n"
                + "        driver.quit();\n"
                + "        Reporter.log(\"=====Browser Session End=====\", true);\n\n"
                + "    }\n"
                + "}\n";
    }
    
    public static String generateTestClass(String packageName, String pageClassName, String outputDirectory, String testUrl) {
        StringBuilder sb = new StringBuilder();
        String pageClassInstanceName = toCamelCaseFirstLower(pageClassName);
        
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
        sb.append("        System.setProperty(\"webdriver.chrome.driver\", \"").append(outputDirectory.replace("\\", "/")).append("/chromedriver.exe\");\n");
        sb.append("        driver = new ChromeDriver();\n");
        sb.append("        driver.manage().window().maximize();\n");
        sb.append("        driver.get(\"").append(testUrl).append("\");\n");
        sb.append("        ").append(pageClassInstanceName).append(" = new ").append(pageClassName).append("(driver);\n");
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

    
    public static String generatePageController(String packageName, String name, Set<String> ids) {
        String className = name + "Controller";
        String nameCamelCaseFirstLower = toCamelCaseFirstLower(name);
        
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(packageName).append(";\n\n");
        sb.append("import org.openqa.selenium.WebElement;\n\n");
        sb.append("public class ").append(className).append(" extends BaseController {\n\n");
        sb.append("    private ").append(name).append(" ").append(nameCamelCaseFirstLower).append(";\n\n");
        
        sb.append("    public ").append(className).append("(WebDriver driver) {\n");
        sb.append("        super(driver);\n");
        sb.append("        this.").append(nameCamelCaseFirstLower).append(" = new ").append(name).append("(driver);\n");
        sb.append("    }\n\n");
        
        for (String id : ids) {
            String idCamelCase = toCamelCase(drainDreck(id));

            sb.append("    public void click").append(idCamelCase).append("() {\n");
            sb.append("        clickButton(").append(nameCamelCaseFirstLower).append(".get").append(idCamelCase).append("());\n");
            sb.append("    }\n\n");

            sb.append("    public void enter").append(idCamelCase).append("(String value) {\n");
            sb.append("        enterText(").append(nameCamelCaseFirstLower).append(".get").append(idCamelCase).append("(), value);\n");
            sb.append("    }\n\n");
        }

        sb.append("}");
        return sb.toString();
    }
  
    private static String toCamelCase(String input) {
        StringBuilder sb = new StringBuilder();
        boolean capitalize = true;
        for (char c : input.toCharArray()) {
            if (c == '_' || c == '-') {
                capitalize = true;
            } else {
                sb.append(capitalize ? Character.toUpperCase(c) : c);
                capitalize = false;
            }
        }
        return sb.toString();
    }
    
    private static String toCamelCaseFirstLower(String input) {
        String camelCase = toCamelCase(input);
        return camelCase.substring(0, 1).toLowerCase() + camelCase.substring(1);
    }
    
    // issue with hyphens/colons in the ids... this method removes them
    private static String drainDreck(String input) {
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = false;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '-' || currentChar == ':') {
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    sb.append(Character.toUpperCase(currentChar));
                    capitalizeNext = false;
                } else {
                    sb.append(currentChar);
                }
            }
        }

        return sb.toString();
    }
}



