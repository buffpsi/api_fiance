package com.ll.yahooFiance.CoinNews;

import java.util.ArrayList;
import java.util.List;

public class CoinNewsData {
    private List<CoinNewsItem> items;

    public CoinNewsData() {
        items = new ArrayList<>();
    }

    public void addItem(CoinNewsItem item) {
        items.add(item);
    }

    public List<CoinNewsItem> getItems() {
        return items;
    }
}
