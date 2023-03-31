package com.campfireprojectv2.campfire.pageFactoryController;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class ScrapingService {

    public Set<String> scrapeIdsFromUrl(String url) throws IOException {
        Set<String> ids = new LinkedHashSet<>();

        try {
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url;
            }
            Document doc = Jsoup.connect(url).get();
            doc.getAllElements().forEach(element -> {
                String id = element.id();
                if (!id.isEmpty()) {
                    ids.add(id);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ids;
    }
    

}


