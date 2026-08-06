package br.com.enzo.fxwatch.scheduler;

import br.com.enzo.fxwatch.entity.CurrencyAlert;
import br.com.enzo.fxwatch.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrencyScheduler {

    private final CurrencyService currencyService;

    @Scheduled(fixedRate = 10000)
    public void checkCurrencies() {

        log.info("Iniciando monitoramento das moedas...");

        currencyService.checkAllAlerts();

    }

}