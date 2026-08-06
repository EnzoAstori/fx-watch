package br.com.enzo.fxwatch.integration.currency.awesomeapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyData {

    private String code;

    private String codein;

    private String name;

    private BigDecimal bid;

    private BigDecimal ask;

    private BigDecimal high;

    private BigDecimal low;

    @JsonProperty("create_date")
    private String createDate;

}