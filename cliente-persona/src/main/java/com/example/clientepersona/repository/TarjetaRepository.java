package com.example.clientepersona.repository;

import com.example.clientepersona.domain.Tarjeta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class TarjetaRepository {

    @Value("${tarjeta.url}")
    private String tarjetaUrl;

    public Mono<Tarjeta> buscarTarjeta(String numeroTarjeta) {
        return WebClient
                .create()
                .get()
                .uri(tarjetaUrl + "/api/tarjeta/" + numeroTarjeta)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Tarjeta.class);
    }

}
