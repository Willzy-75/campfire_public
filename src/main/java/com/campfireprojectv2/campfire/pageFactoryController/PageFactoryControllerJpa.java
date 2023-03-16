package com.campfireprojectv2.campfire.pageFactoryController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class PageFactoryControllerJpa {
    
    @Autowired
    private ScrapingService scrapingService;
    
    private PageFactoryRepository pageFactoryRepository;
    
    public PageFactoryControllerJpa(PageFactoryRepository pageFactoryRepository) {
    	super();
    	this.pageFactoryRepository = pageFactoryRepository;
    }
    
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
    
	@RequestMapping(value = "/generatePageFactory", method = RequestMethod.POST)
	public ResponseEntity<Resource> generatePageFactory(
	        @RequestParam String url,
	        @RequestParam String packageName,
	        @RequestParam String name,
	        @RequestParam String outputDirectory) throws IOException {
	    List<String> ids = scrapingService.scrapeIdsFromUrl(url);
	    String pageFactoryCode = PageFactoryGenerator.generatePageFactory(ids, packageName, name);

	    File file = new File(outputDirectory, name + ".java"); // Add ".java" to the name of the output file
	    FileUtils.writeStringToFile(file, pageFactoryCode, StandardCharsets.UTF_8);
	    ByteArrayResource resource = new ByteArrayResource(FileUtils.readFileToByteArray(file));
	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + name + ".java"); // Add ".java" to the name of the output file
	    headers.add(HttpHeaders.CONTENT_TYPE, "text/plain");
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(resource.contentLength())
	            .body(resource);
	}

    
	@GetMapping("/generate-page-factory")
	public String showGeneratePageFactoryForm(ModelMap model) {
	    model.addAttribute("pageFactory", new PageFactory());
	    return "generate_page_factory";
	}
	
}


