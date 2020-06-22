package com.example.clientetradicional.repository;

import com.example.clientetradicional.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PersonaRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${persona.url}")
    private String personaUrl;

    public Persona buscar(String dni) {

        String uri = personaUrl + "/api/persona?dni=" + dni;

        return restTemplate.getForObject(uri, Persona.class);
    }

}
