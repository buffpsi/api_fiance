package com.ll.yahooFiance.CoinNews;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CoinNewsService {
    private final Map<String, String> sectionUrls;


    public CoinNewsService() {
        sectionUrls = new HashMap<>();
        //시장
        sectionUrls.put("S1N1", "https://www.coindeskkorea.com/news/articleList.html?sc_section_code=S1N1&view_type=sm");
        //비즈니스
        sectionUrls.put("S1N2", "https://www.coindeskkorea.com/news/articleList.html?sc_section_code=S1N2&view_type=sm");
        //정책
        sectionUrls.put("S1N3", "https://www.coindeskkorea.com/news/articleList.html?sc_section_code=S1N3&view_type=sm");
        //기술
        sectionUrls.put("S1N4", "https://www.coindeskkorea.com/news/articleList.html?sc_section_code=S1N4&view_type=sm");
        //오피니언
        sectionUrls.put("S1N5", "https://www.coindeskkorea.com/news/articleList.html?sc_section_code=S1N5&view_type=sm");
    }

    public CoinNewsData getCoinNewsData(String sectionCode) {
        CoinNewsData coinNewsData = new CoinNewsData();

        try {
            String url = sectionUrls.get(sectionCode);
            Document doc = Jsoup.connect(url).get();

            Elements listItems = doc.select("#section-list .type2 li");
            for (Element listItem : listItems) {
                Element titleElement = listItem.selectFirst(".titles a");
                String articleTitle = titleElement.text();
                String articleUrl = "https://www.coindeskkorea.com" + titleElement.attr("href");

                Element leadElement = listItem.selectFirst(".lead.line-6x1 a");
                String articleLead = leadElement != null ? leadElement.text() : "";

                CoinNewsItem item = new CoinNewsItem(articleTitle, articleLead, articleUrl);
                coinNewsData.addItem(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return coinNewsData;
    }
}
