package com.campfireprojectv2.campfire.pageFactoryController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class ScrapingService {

    public List<String> scrapeIdsFromUrl(String url) throws IOException {
        List<String> ids = new ArrayList<>();

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


