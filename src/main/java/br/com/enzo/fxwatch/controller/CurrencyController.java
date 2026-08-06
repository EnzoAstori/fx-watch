package br.com.enzo.fxwatch.controller;

import br.com.enzo.fxwatch.entity.CurrencyAlert;
import br.com.enzo.fxwatch.repository.CurrencyAlertRepository;
import br.com.enzo.fxwatch.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;
    private final CurrencyAlertRepository currencyAlertRepository;

    @PostMapping("/{id}/check")
    public String check(@PathVariable Long id) {

        CurrencyAlert alert = currencyAlertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado."));

        currencyService.checkAlert(alert);

        return "Cotação atualizada com sucesso!";
    }

}