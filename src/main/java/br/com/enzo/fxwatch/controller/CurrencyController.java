package br.com.enzo.fxwatch.controller;

import br.com.enzo.fxwatch.dto.request.CreateAlertRequest;
import br.com.enzo.fxwatch.dto.response.AlertResponse;
import br.com.enzo.fxwatch.entity.CurrencyAlert;
import br.com.enzo.fxwatch.service.CurrencyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @PostMapping
    public AlertResponse create(@RequestBody @Valid CreateAlertRequest request) {

        CurrencyAlert alert = currencyService.createAlert(request.getCurrencyCode());

        return toResponse(alert);
    }

    @GetMapping
    public List<AlertResponse> findAll() {

        return currencyService.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public AlertResponse findById(@PathVariable Long id) {

        return toResponse(currencyService.findById(id));
    }

    @PostMapping("/{id}/check")
    public String check(@PathVariable Long id) {

        CurrencyAlert alert = currencyService.findById(id);

        currencyService.checkAlert(alert);

        return "Cotação atualizada com sucesso!";
    }

    private AlertResponse toResponse(CurrencyAlert alert) {

        return AlertResponse.builder()
                .id(alert.getId())
                .currencyCode(alert.getCurrencyCode())
                .enabled(alert.getEnabled())
                .lowestPrice(alert.getLowestPrice())
                .highestPrice(alert.getHighestPrice())
                .lastPrice(alert.getLastPrice())
                .createdAt(alert.getCreatedAt())
                .lastCheck(alert.getLastCheck())
                .build();
    }
}