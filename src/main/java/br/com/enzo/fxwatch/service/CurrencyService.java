package br.com.enzo.fxwatch.service;

import br.com.enzo.fxwatch.entity.CurrencyAlert;
import br.com.enzo.fxwatch.entity.ExchangeHistory;
import br.com.enzo.fxwatch.integration.currency.CurrencyProvider;
import br.com.enzo.fxwatch.repository.CurrencyAlertRepository;
import br.com.enzo.fxwatch.repository.ExchangeHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyProvider currencyProvider;
    private final CurrencyAlertRepository currencyAlertRepository;
    private final ExchangeHistoryRepository exchangeHistoryRepository;

    public void checkAlert(CurrencyAlert alert) {

        BigDecimal currentPrice = currencyProvider.getCurrentPrice(
                alert.getCurrencyCode().name(),
                "BRL"
        );

        alert.setLastPrice(currentPrice);
        alert.setLastCheck(LocalDateTime.now());

        if (currentPrice.compareTo(alert.getLowestPrice()) < 0) {
            alert.setLowestPrice(currentPrice);
        }

        if (currentPrice.compareTo(alert.getHighestPrice()) > 0) {
            alert.setHighestPrice(currentPrice);
        }

        currencyAlertRepository.save(alert);

        ExchangeHistory history = ExchangeHistory.builder()
                .currencyAlert(alert)
                .currencyCode(alert.getCurrencyCode())
                .price(currentPrice)
                .collectedAt(LocalDateTime.now())
                .build();

        exchangeHistoryRepository.save(history);
    }
}