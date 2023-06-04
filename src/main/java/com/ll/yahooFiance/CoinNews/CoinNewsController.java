package com.ll.yahooFiance.CoinNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CoinNewsController {
    private final CoinNewsService coinNewsService;

    @Autowired
    public CoinNewsController(CoinNewsService coinNewsService) {
        this.coinNewsService = coinNewsService;
    }

    @GetMapping("/coinNews/{sectionCode}")
    public String getCoinNews(@PathVariable String sectionCode, Model model) {
        CoinNewsData coinNewsData = coinNewsService.getCoinNewsData(sectionCode);
        model.addAttribute("coinNewsData", coinNewsData);
        return "coinNews";
    }
}
