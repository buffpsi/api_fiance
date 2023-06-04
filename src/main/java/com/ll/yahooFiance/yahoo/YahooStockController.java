//package com.ll.yahooFiance.yahoo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.io.IOException;
//
//@Controller
//@RequestMapping("/yahooStocks")
//public class YahooStockController {
//    private final YahooFinanceService yahooFinanceService;
//
//    @Autowired
//    public YahooStockController(YahooFinanceService yahooFinanceService) {
//        this.yahooFinanceService = yahooFinanceService;
//    }
//
//    @GetMapping("/{symbol}/companyInfo")
//    public ResponseEntity<String> getCompanyInfo(@PathVariable String symbol) {
//        try {
//            String companyInfo = yahooFinanceService.getCompanyInfo(symbol);
//            return ResponseEntity.ok(companyInfo);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//
//}
