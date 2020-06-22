package com.example.servidorpersona.web.controller.rest;

import com.example.servidorpersona.domain.Tarjeta;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarjetaRestCotroller {

    @GetMapping("/api/tarjeta/{numeroTarjeta}")
    public Tarjeta buscarTarjeta(@PathParam(value = "numeroTarjeta") String numeroTarjeta) throws InterruptedException {

        Thread.sleep(5000L);

        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setConDeuda(false);
        tarjeta.setNombre("VISA");

        return tarjeta;
    }

}
