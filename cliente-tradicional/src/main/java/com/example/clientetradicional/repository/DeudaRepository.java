package com.example.clientetradicional.repository;

import com.example.clientetradicional.domain.Cuota;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class DeudaRepository {

    private final RestTemplate restTemplate;

    public DeudaRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${deuda.url}")
    private String deudaUrl;

    public List<Cuota> buscar(String numeroLinea) {

        String uri = deudaUrl + "/api/deuda/" + numeroLinea;

        return restTemplate.getForObject(uri, List.class);

    }

}
