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

    public Mono<DetallePersonaVo> buscar(String numeroLinea, String numeroTarjeta, String dni) {

        Mono<Tarjeta> tarjeta = tarjetaRepository
                .buscarTarjeta(numeroTarjeta)
                .log("Tarjeta request");
        Mono<Persona> persona = personaRepository
                .buscarPersona(dni)
                .log("Persona request");
        Mono<List<Cuota>> deuda = deudaRepository
                .buscarDeuda(numeroLinea)
                .log("Deuda request")
                .collectList()
                .log("Armado lista");
        
        return Mono.zip(Mono.zip(tarjeta, persona, (unaTarjeta, unaPersona) -> {
            DetallePersonaVo detallePersonaVo = new DetallePersonaVo();
            detallePersonaVo.setPersona(unaPersona);
            detallePersonaVo.setTarjeta(unaTarjeta);
            return detallePersonaVo;
        }), deuda, (detalle, unaDeuda) -> {
            detalle.setDeuda(unaDeuda);
            return detalle;
        });
    }

}
