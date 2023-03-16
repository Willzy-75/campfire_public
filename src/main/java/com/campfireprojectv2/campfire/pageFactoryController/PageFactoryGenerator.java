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



