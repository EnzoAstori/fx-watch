package br.com.enzo.fxwatch.integration.currency.awesomeapi.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class AwesomeApiResponse {

    private final Map<String, CurrencyData> data = new HashMap<>();

    @JsonAnySetter
    public void addCurrency(String key, CurrencyData value) {
        data.put(key, value);
    }

}