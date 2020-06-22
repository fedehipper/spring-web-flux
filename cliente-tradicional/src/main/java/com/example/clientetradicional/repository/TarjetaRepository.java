package com.example.clientetradicional.repository;

import com.example.clientetradicional.domain.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class TarjetaRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${tarjeta.url}")
    private String tarjetaUrl;

    public Tarjeta buscar(String numeroTarjeta) {

        String uri = tarjetaUrl + "/api/tarjeta/" + numeroTarjeta;

        return restTemplate.getForObject(uri, Tarjeta.class);
    }

}
