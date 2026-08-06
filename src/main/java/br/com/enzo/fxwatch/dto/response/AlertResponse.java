package br.com.enzo.fxwatch.dto.response;

import br.com.enzo.fxwatch.enums.CurrencyCode;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class AlertResponse {

    private Long id;

    private CurrencyCode currencyCode;

    private Boolean enabled;

    private BigDecimal lowestPrice;

    private BigDecimal highestPrice;

    private BigDecimal lastPrice;

    private LocalDateTime createdAt;

    private LocalDateTime lastCheck;

}