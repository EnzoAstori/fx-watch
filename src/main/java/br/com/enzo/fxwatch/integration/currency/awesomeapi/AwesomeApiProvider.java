package br.com.enzo.fxwatch.integration.currency.awesomeapi;

import br.com.enzo.fxwatch.integration.currency.CurrencyProvider;
import br.com.enzo.fxwatch.integration.currency.awesomeapi.client.AwesomeApiClient;
import br.com.enzo.fxwatch.integration.currency.awesomeapi.dto.AwesomeApiResponse;
import br.com.enzo.fxwatch.integration.currency.awesomeapi.dto.CurrencyData;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AwesomeApiProvider implements CurrencyProvider {

    private final AwesomeApiClient client;

    public AwesomeApiProvider(AwesomeApiClient client) {
        this.client = client;
    }

    @Override
    public BigDecimal getCurrentPrice(String baseCurrency, String targetCurrency) {

        AwesomeApiResponse response =
                client.getExchange(baseCurrency, targetCurrency);

        CurrencyData currency =
                response.getData().values().stream()
                        .findFirst()
                        .orElseThrow(() ->
                                new RuntimeException("Cotação não encontrada"));

        return currency.getBid();
    }
}