package com.campfireprojectv2.campfire.testSuiteBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("testSuite") 
public class TestSuiteControllerJpa {

	@Autowired
	private ScrapingService scrapingService;

	@RequestMapping(value = "/generateTestSuite", method = RequestMethod.POST)
	public ResponseEntity<Resource> generateTestSuite(@RequestParam String url, @RequestParam String packageName,
			@RequestParam String name, @RequestParam String outputDirectory,
			@RequestParam(value = "baseControllerNeeded", required = false) boolean baseControllerNeeded) {
		try { 	
				
			if (url == null || url.isEmpty() || packageName == null || packageName.isEmpty() || name == null
					|| name.isEmpty() || outputDirectory == null || outputDirectory.isEmpty()) {
				throw new IllegalArgumentException("Input parameters must not be null or empty.");
			}

			Set<String> ids = scrapingService.scrapeIdsFromUrl(url);

			String pageFactoryCode = TestSuiteGenerator.generatePageFactory(ids, packageName, name);
			File pageFactoryFile = new File(outputDirectory, name + ".java");
			FileUtils.writeStringToFile(pageFactoryFile, pageFactoryCode, StandardCharsets.UTF_8);

			if (baseControllerNeeded) {
				String baseControllerCode = TestSuiteGenerator.generateBaseController(packageName);
				File baseControllerFile = new File(outputDirectory, "BaseController.java");
				FileUtils.writeStringToFile(baseControllerFile, baseControllerCode, StandardCharsets.UTF_8);
			}
			

			String pageControllerCode = TestSuiteGenerator.generatePageController(packageName, name, ids);
			File pageControllerFile = new File(outputDirectory, name + "Controller.java");
			FileUtils.writeStringToFile(pageControllerFile, pageControllerCode, StandardCharsets.UTF_8);

			String testClassName = name + "Test";
			String testClassContent = TestSuiteGenerator.generateTestClass(packageName, name, outputDirectory, url);

			File testClassFile = new File(outputDirectory, testClassName + ".java");
			FileUtils.writeStringToFile(testClassFile, testClassContent, StandardCharsets.UTF_8);

			ByteArrayResource resource = new ByteArrayResource(FileUtils.readFileToByteArray(pageFactoryFile));
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + name + ".java");
			headers.add(HttpHeaders.CONTENT_TYPE, "text/plain");
			return ResponseEntity.ok().headers(headers).contentLength(resource.contentLength()).body(resource);
		
		} catch (IOException | IllegalArgumentException e) {
			
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/generate-test-suite")
	public String showTestSuiteForm(ModelMap model) {
		TestSuite testSuite = new TestSuite();
		model.addAttribute("testSuite", testSuite);
		return "generate_test_suite";
	}

}
