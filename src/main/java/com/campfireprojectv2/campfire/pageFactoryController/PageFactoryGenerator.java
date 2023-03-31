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
                + "public class BasePage {\n"
                + "    private WebDriver driver;\n\n"
                + "    public BasePage(WebDriver driver) {\n"
                + "        this.driver = driver;\n"
                + "    }\n\n"
                + "    public void enterText(WebElement element, String text) {\n"
                + "        element.clear();\n"
                + "        element.sendKeys(text);\n"
                + "    }\n\n"
                + "    public void clickButton(WebElement button) {\n"
                + "        button.click();\n"
                + "    }\n\n"
                + "    @BeforeClass\n"
                + "    public void setupApplication()\n"
                + "    {\n\n"
                + "        Reporter.log(\"=====Browser Session Started=====\", true);\n\n"
                + "        driver=new ChromeDriver();\n\n"
                + "        driver.manage().window().maximize();\n\n"
                + "        driver.get(\"http://enterprise.demo.orangehrmlive.com/symfony/web/index.php/auth/login\");\n\n"
                + "        Reporter.log(\"=====Application Started=====\", true);\n"
                + "    }\n\n"
                + "    @AfterClass\n"
                + "    public void closeApplication()\n"
                + "    {\n"
                + "        driver.quit();\n"
                + "        Reporter.log(\"=====Browser Session End=====\", true);\n\n"
                + "    }\n"
                + "}\n";
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
}



