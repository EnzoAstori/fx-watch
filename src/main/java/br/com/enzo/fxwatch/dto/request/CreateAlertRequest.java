package br.com.enzo.fxwatch.dto.request;

import br.com.enzo.fxwatch.enums.CurrencyCode;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAlertRequest {

    @NotNull
    private CurrencyCode currencyCode;

}