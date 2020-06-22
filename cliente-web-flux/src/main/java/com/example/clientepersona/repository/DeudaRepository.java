package com.example.clientepersona.repository;

import com.example.clientepersona.domain.Cuota;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Repository
public class DeudaRepository {

    @Value("${deuda.url}")
    private String deudaUrl;

    public Flux<Cuota> buscarDeuda(String numeroLinea) {
        return WebClient
                .create()
                .get()
                .uri(deudaUrl + "/api/deuda/" + numeroLinea)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Cuota.class);
    }

}
