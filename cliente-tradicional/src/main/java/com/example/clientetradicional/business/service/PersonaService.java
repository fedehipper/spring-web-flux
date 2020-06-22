package com.example.clientetradicional.business.service;

import com.example.clientetradicional.domain.Cuota;
import com.example.clientetradicional.domain.Persona;
import com.example.clientetradicional.domain.Tarjeta;
import com.example.clientetradicional.repository.DeudaRepository;
import com.example.clientetradicional.repository.TarjetaRepository;
import com.example.clientetradicional.repository.PersonaRepository;
import com.example.clientetradicional.vo.DetallePersonaVo;
import java.util.List;
import org.springframework.stereotype.Service;

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

    public DetallePersonaVo buscar(String numeroLinea, String numeroTarjeta, String dni) {

        List<Cuota> deuda = deudaRepository.buscar(numeroLinea);
        Tarjeta tarjeta = tarjetaRepository.buscar(numeroTarjeta);
        Persona persona = personaRepository.buscar(dni);

        return armarDetallePersona(deuda, tarjeta, persona);
    }

    private DetallePersonaVo armarDetallePersona(List<Cuota> deuda, Tarjeta tarjeta, Persona persona) {
        DetallePersonaVo detallePersonaVo = new DetallePersonaVo();
        detallePersonaVo.setDeuda(deuda);
        detallePersonaVo.setPersona(persona);
        detallePersonaVo.setTarjeta(tarjeta);
        return detallePersonaVo;
    }

}
