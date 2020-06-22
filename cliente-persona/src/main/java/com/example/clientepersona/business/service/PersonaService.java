package com.example.clientepersona.business.service;

import com.example.clientepersona.domain.Cuota;
import com.example.clientepersona.domain.Persona;
import com.example.clientepersona.domain.Tarjeta;
import com.example.clientepersona.repository.DeudaRepository;
import com.example.clientepersona.repository.PersonaRepository;
import com.example.clientepersona.repository.TarjetaRepository;
import com.example.clientepersona.vo.DetallePersonaVo;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class PersonaService {

    private final DeudaRepository deudaRepository;
    private final TarjetaRepository tarjetaRepository;
    private final PersonaRepository personaRepository;

    public PersonaService(
            DeudaRepository deudaRepository,
            TarjetaRepository tarjetaRepository,
            PersonaRepository personaRepository) {
        this.deudaRepository = deudaRepository;
        this.tarjetaRepository = tarjetaRepository;
        this.personaRepository = personaRepository;
    }

    public Mono buscar(String numeroLinea, String numeroTarjeta, String dni) {

        Mono<Tarjeta> tarjeta = tarjetaRepository.buscarTarjeta(numeroTarjeta);
        Mono<Persona> persona = personaRepository.buscarPersona(dni);
        Mono<List<Cuota>> deuda = deudaRepository.buscarDeuda(numeroLinea).collectList();
        
        return Mono.zip(Mono.zip(tarjeta, persona, this::armerDetallePersona), deuda, this::armarDetalleConDeuda);

    }

    public DetallePersonaVo armerDetallePersona(Tarjeta tarjeta, Persona persona) {
        DetallePersonaVo detallePersonaVo = new DetallePersonaVo();
        detallePersonaVo.setPersona(persona);
        detallePersonaVo.setTarjeta(tarjeta);
        return detallePersonaVo;
    }

    public DetallePersonaVo armarDetalleConDeuda(DetallePersonaVo detallePersonaVo, List<Cuota> deuda) {
        detallePersonaVo.setDeuda(deuda);
        return detallePersonaVo;
    }

}
