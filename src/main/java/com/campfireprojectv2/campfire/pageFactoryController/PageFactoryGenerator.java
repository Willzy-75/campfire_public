package com.campfireprojectv2.campfire.pageFactoryController;

import java.util.List;

public class PageFactoryGenerator {

    public static String generatePageFactory(List<String> ids, String packageName, String filename) {
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(packageName).append(";\n\n");
        sb.append("import org.openqa.selenium.WebElement;\n");
        sb.append("import org.openqa.selenium.support.FindBy;\n\n");
        sb.append("public class ").append(filename).append(" {\n\n");

        // Generate the instance variables and FindBy annotations
        for (String id : ids) {
            sb.append("    @FindBy(id = \"").append(id).append("\")\n");
            sb.append("    private WebElement ").append(id).append(";\n\n");
        }

        sb.append("    public ").append(filename).append("() {\n");
        sb.append("    }\n\n");

       
        for (String id : ids) {
            String idCamelCase = toCamelCase(id);
            sb.append("    public WebElement get").append(idCamelCase).append("() {\n");
            sb.append("        return ").append(id).append(";\n");
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
                + "import org.testng.annotations.BeforeClass;\n"
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
    
    public static String generatePageController(String packageName, String name, List<String> ids) {
        String className = name + "Controller";
        String nameCamelCase = toCamelCase(name);
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
            String idCamelCase = toCamelCase(id);

            sb.append("    public void click").append(idCamelCase).append("() {\n");
            sb.append("        clickElement(").append(nameCamelCaseFirstLower).append(".get").append(idCamelCase).append("());\n");
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
}



