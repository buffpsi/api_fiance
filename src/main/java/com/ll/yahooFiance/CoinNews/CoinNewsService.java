package com.ll.yahooFiance.CoinNews;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CoinNewsService {
    public CoinNewsData getCoinNewsData() {
        CoinNewsData coinNewsData = new CoinNewsData();

        try {
            String url = "https://www.coindeskkorea.com/news/articleList.html?sc_area=I&sc_word=&view_type=sm";
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
