//package com.ll.yahooFiance.Home;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/stocks")
//public class StockController {
//
//    private final YahooFinanceService yahooFinanceService;
//
//    @Autowired
//    public StockController(YahooFinanceService yahooFinanceService) {
//        this.yahooFinanceService = yahooFinanceService;
//    }
//
//    @GetMapping("/{symbol}/company-info")
//    public ResponseEntity<String> getCompanyInfo(@PathVariable String symbol) {
//        try {
//            String companyInfo = yahooFinanceService.getApiResponse("/v10/finance/quoteSummary", symbol, "summaryDetail");
//            return ResponseEntity.ok(companyInfo);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @GetMapping("/{symbol}/stock-chart")
//    public ResponseEntity<String> getStockChart(@PathVariable String symbol) {
//        try {
//            String stockChart = yahooFinanceService.getApiResponse("/v8/finance/chart", symbol, "chartdata");
//            return ResponseEntity.ok(stockChart);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//}

package com.ll.yahooFiance.Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final YahooFinanceService yahooFinanceService;

    @Autowired
    public StockController(YahooFinanceService yahooFinanceService) {
        this.yahooFinanceService = yahooFinanceService;
    }

    @GetMapping("/{symbol}/company-info")
    public ResponseEntity<String> getCompanyInfo(@PathVariable String symbol) {
        try {
            String companyInfo = yahooFinanceService.getApiResponse("/v10/finance/quoteSummary", symbol, "summaryDetail");
            return ResponseEntity.ok(companyInfo);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{symbol}/stock-chart")
    public ResponseEntity<String> getStockChart(@PathVariable String symbol) {
        try {
            String stockChart = yahooFinanceService.getApiResponse("/v8/finance/chart", symbol, "chartdata");
            return ResponseEntity.ok(stockChart);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //    @GetMapping("/{symbol}/news")
//    public ResponseEntity<String> getStockNews(@PathVariable String symbol) {
//        try {
//            String stockNews = yahooFinanceService.getApiResponse("/v10/finance/quoteSummary", symbol, "news");
//            return ResponseEntity.ok(stockNews);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
    @GetMapping("/{symbol}/news")
    public ResponseEntity<String> getStockNews(@PathVariable String symbol) {
        try {
            String stockNews = yahooFinanceService.getApiResponse("/v10/finance/news", symbol, "category,summary");
            return ResponseEntity.ok(stockNews);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


//    @GetMapping("/marketcap")
//    public ResponseEntity<String> getMarketCapRankings() {
//        try {
//            String marketCapRankings = yahooFinanceService.getApiResponse("/v1/finance/screener/predefined/saved", "", "industry_basic_tech_computer_services");
//            return ResponseEntity.ok(marketCapRankings);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

//    @GetMapping("/marketcap")
//    public ResponseEntity<String> getMarketCapRankings() {
//        try {
//            String marketCapRankings = yahooFinanceService.getApiResponse("/v1/finance/screener/predefined/saved", "1", "count=10&offset=0");
//            return ResponseEntity.ok(marketCapRankings);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

    @GetMapping("/marketcap")
    public ResponseEntity<String> getMarketCapRankings() {
        try {
            String marketCapRankings = yahooFinanceService.getApiResponse("/v1/finance/screener/predefined/saved", "", "industry_basic_tech_computer_services");
            return ResponseEntity.ok(marketCapRankings);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
