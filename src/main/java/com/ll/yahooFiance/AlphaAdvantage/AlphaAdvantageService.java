package com.ll.yahooFiance.AlphaAdvantage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AlphaAdvantageService {

    @Value("${alpha.advantage.api.key}")
    private String apiKey;

    public List<HistoricalPrice> getHistoricalPrices(String symbol) {
        String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=" + symbol + "&apikey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AlphaAdvantageResponse> response = restTemplate.getForEntity(apiUrl, AlphaAdvantageResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            AlphaAdvantageResponse data = response.getBody();
            if (data != null) {
                return data.getHistoricalPrices();
            }
        }

        throw new RuntimeException("Failed to fetch historical prices for symbol: " + symbol);
    }
}
