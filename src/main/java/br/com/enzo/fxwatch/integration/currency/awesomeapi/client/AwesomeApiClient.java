package br.com.enzo.fxwatch.integration.currency.awesomeapi.client;

import br.com.enzo.fxwatch.integration.currency.awesomeapi.dto.AwesomeApiResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class AwesomeApiClient {

    private final RestClient restClient;

    public AwesomeApiClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://economia.awesomeapi.com.br")
                .build();
    }

    public AwesomeApiResponse getExchange(String base, String target) {

        return restClient.get()
                .uri("/json/last/{base}-{target}", base, target)
                .retrieve()
                .body(AwesomeApiResponse.class);

    }


}