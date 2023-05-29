package com.ll.yahooFiance.AlphaAdvantage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class AlphaAdvantageController {

    private final AlphaAdvantageService alphaAdvantageService;

    @Autowired
    public AlphaAdvantageController(AlphaAdvantageService alphaAdvantageService) {
        this.alphaAdvantageService = alphaAdvantageService;
    }

    @GetMapping("/{symbol}/historical-prices")
    public List<HistoricalPrice> getHistoricalPrices(@PathVariable String symbol) {
        return alphaAdvantageService.getHistoricalPrices(symbol);
    }
}
