//package com.ll.yahooFiance.Home;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
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

package com.ll.yahooFiance.Home;

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

    public String getApiResponse(String endpoint, String symbol, String modules) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = API_BASE_URL + endpoint + "/" + symbol + "?modules=" + modules;
        HttpGet request = new HttpGet(url);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(httpClient.execute(request).getEntity().getContent()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
            httpClient.close();
        }
    }
}
