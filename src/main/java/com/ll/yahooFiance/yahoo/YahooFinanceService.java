//package com.ll.yahooFiance.yahoo;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.io.IOException;
//
//@Service
//public class YahooFinanceService {
//
//    private static final String API_BASE_URL = "https://query1.finance.yahoo.com";
//    private final WebClient webClient;
//
//    public YahooFinanceService() {
//        this.webClient = WebClient.create();
//    }
//
//    public String getCompanyInfo(String symbol) throws IOException {
//        String endpoint = "/v10/finance/quoteSummary";
//        String modules = "summaryDetail";
//        String url = API_BASE_URL + endpoint + "/" + symbol + "?modules=" + modules;
//
//        return webClient.get()
//                .uri(url)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//    }
//}
