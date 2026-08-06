package br.com.enzo.fxwatch.integration.currency;

import java.math.BigDecimal;

public interface CurrencyProvider {

    BigDecimal getCurrentPrice(String baseCurrency,
                               String targetCurrency);

}