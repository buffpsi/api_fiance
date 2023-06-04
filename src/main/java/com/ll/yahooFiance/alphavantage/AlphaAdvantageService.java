package com.ll.yahooFiance.alphavantage;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Service
public class AlphaAdvantageService {

    private final String apiKey = "..";
    private final WebClient webClient = WebClient.create();

    public String getCompanyInfo(String symbol) throws IOException {
        String url = "https://www.alphavantage.co/query?function=OVERVIEW&symbol=" + symbol + "&apikey=" + apiKey;
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getIncomeStatement(String symbol) throws IOException {
        String url = "https://www.alphavantage.co/query?function=INCOME_STATEMENT&symbol=" + symbol + "&apikey=" + apiKey;
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getBalanceSheet(String symbol) throws IOException {
        String url = "https://www.alphavantage.co/query?function=BALANCE_SHEET&symbol=" + symbol + "&apikey=" + apiKey;
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getCashFlow(String symbol) throws IOException {
        String url = "https://www.alphavantage.co/query?function=CASH_FLOW&symbol=" + symbol + "&apikey=" + apiKey;
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}