package com.ll.yahooFiance.yahoo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class YahooFinanceService {

    private static final String API_BASE_URL = "https://query1.finance.yahoo.com";

    private final CloseableHttpClient httpClient;

    public YahooFinanceService() {
        this.httpClient = HttpClients.createDefault();
    }

    public String getCompanyInfo(String symbol) throws IOException {
        String endpoint = "/v10/finance/quoteSummary";
        String modules = "summaryDetail";
        String url = API_BASE_URL + endpoint + "/" + symbol + "?modules=" + modules;
        HttpGet request = new HttpGet(url);
        BufferedReader reader = null;

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBody.append(line);
            }
            return responseBody.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
