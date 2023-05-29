//package com.ll.yahooFiance.Home;
//
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.springframework.stereotype.Service;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//@Service
//public class YahooFinanceService {
//
//    private static final String API_BASE_URL = "https://query1.finance.yahoo.com";
//
//    public String getApiResponse(String endpoint, String symbol, String modules) throws IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        String url = API_BASE_URL + endpoint + "/" + symbol + "?modules=" + modules;
//        HttpGet request = new HttpGet(url);
//        BufferedReader reader = null;
//
//        try {
//            reader = new BufferedReader(new InputStreamReader(httpClient.execute(request).getEntity().getContent()));
//            StringBuilder response = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            return response.toString();
//        } finally {
//            if (reader != null) {
//                reader.close();
//            }
//            httpClient.close();
//        }
//    }
//}
//위에거 잘됨

package com.ll.yahooFiance.Home;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class YahooFinanceService {

    private static final String API_BASE_URL = "https://yahoo-finance15.p.rapidapi.com";

    public String getApiResponse(String endpoint, String symbol, String modules) throws IOException, InterruptedException, URISyntaxException {
        String url = API_BASE_URL + endpoint + "/" + symbol + "?modules=" + modules;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("X-RapidAPI-Key", "f63a966c69msh89e6b95edad9958p1b36a2jsn1644b97e2a57")
                .header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getStockNews(String symbol) throws IOException, InterruptedException, URISyntaxException {
        String endpoint = "/api/yahoo/ne/news";
        String url = API_BASE_URL + endpoint + "/" + symbol;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("X-RapidAPI-Key", "f63a966c69msh89e6b95edad9958p1b36a2jsn1644b97e2a57")
                .header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
