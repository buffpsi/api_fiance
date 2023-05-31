package com.ll.yahooFiance.sub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/alphaStocks")

public class alpahAdvantageController {

    private final String apiKey = "..";

    @GetMapping("/company/{symbol}")
    public String getCompanyInfo(@PathVariable String symbol) {
        String url = "https://www.alphavantage.co/query?function=OVERVIEW&symbol=" + symbol + "&apikey=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/income/{symbol}")
    public String getIncomeStatement(@PathVariable String symbol) {
        String url = "https://www.alphavantage.co/query?function=INCOME_STATEMENT&symbol=" + symbol + "&apikey=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/balance/{symbol}")
    public String getBalanceSheet(@PathVariable String symbol) {
        String url = "https://www.alphavantage.co/query?function=BALANCE_SHEET&symbol=" + symbol + "&apikey=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/cashflow/{symbol}")
    public String getCashFlow(@PathVariable String symbol) {
        String url = "https://www.alphavantage.co/query?function=CASH_FLOW&symbol=" + symbol + "&apikey=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

}