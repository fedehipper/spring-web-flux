package com.example.clientepersona.repository;

import com.example.clientepersona.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class PersonaRepository {

    @Value("${persona.url}")
    private String personaUrl;

    public Mono<Persona> buscarPersona(String dni) {
        return WebClient
                .create()
                .get()
                .uri(personaUrl + "/api/persona?dni=" + dni)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Persona.class);
    }

}
