package com.ll.yahooFiance.CoinNews;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoinNewsItem {
    private String title;
    private String lead;
    private String url;

    public CoinNewsItem(String title, String lead, String url) {
        this.title = title;
        this.lead = lead;
        this.url = url;
    }
}
