package com.ll.yahooFiance.alphavantage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/alphaStocks")
public class AlphaAdvantageController {

    private final AlphaAdvantageService alphaAdvantageService;

    @Autowired
    public AlphaAdvantageController(AlphaAdvantageService alphaAdvantageService) {
        this.alphaAdvantageService = alphaAdvantageService;
    }

    @GetMapping("/company/{symbol}")
    public ResponseEntity<String> getCompanyInfo(@PathVariable String symbol) {
        try {
            String companyInfo = alphaAdvantageService.getCompanyInfo(symbol);
            return ResponseEntity.ok("alpha: " + companyInfo);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/income/{symbol}")
    public ResponseEntity<String> getIncomeStatement(@PathVariable String symbol) {
        try {
            String incomeStatement = alphaAdvantageService.getIncomeStatement(symbol);
            return ResponseEntity.ok("alpha: " + incomeStatement);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/balance/{symbol}")
    public ResponseEntity<String> getBalanceSheet(@PathVariable String symbol) {
        try {
            String balanceSheet = alphaAdvantageService.getBalanceSheet(symbol);
            return ResponseEntity.ok("alpha: " + balanceSheet);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/cashflow/{symbol}")
    public ResponseEntity<String> getCashFlow(@PathVariable String symbol) {
        try {
            String cashFlow = alphaAdvantageService.getCashFlow(symbol);
            return ResponseEntity.ok("alpha: " + cashFlow);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}