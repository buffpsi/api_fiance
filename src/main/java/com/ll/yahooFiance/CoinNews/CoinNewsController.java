package com.ll.yahooFiance.CoinNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoinNewsController {
    private final CoinNewsService coinNewsService;

    @Autowired
    public CoinNewsController(CoinNewsService coinNewsService) {
        this.coinNewsService = coinNewsService;
    }

    @GetMapping("/coinNews")
    public String getCoinNews(Model model) {
        CoinNewsData coinNewsData = coinNewsService.getCoinNewsData();
        model.addAttribute("coinNewsData", coinNewsData);
        return "coinNews";
    }
}
