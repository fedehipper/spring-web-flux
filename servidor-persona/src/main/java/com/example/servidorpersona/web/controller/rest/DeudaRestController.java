package com.example.servidorpersona.web.controller.rest;

import com.example.servidorpersona.domain.Cuota;
import java.math.BigDecimal;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeudaRestController {

    @GetMapping("api/deuda/{linea}")
    public List<Cuota> buscarDeuda(@PathParam(value = "linea") String numeroLinea) throws InterruptedException {

        Thread.sleep(1000L);

        return armarDeuda();

    }

    private List<Cuota> armarDeuda() {
        Cuota cuotaFebrero = new Cuota();
        cuotaFebrero.setMes("Febrero");
        cuotaFebrero.setMonto(new BigDecimal("1334.32"));
        Cuota cuotaMarzo = new Cuota();
        cuotaMarzo.setMes("Marzo");
        cuotaMarzo.setMonto(new BigDecimal("3234.32"));
        Cuota cuotaAbril = new Cuota();
        cuotaAbril.setMes("Abril");
        cuotaAbril.setMonto(new BigDecimal("4234.32"));
        return List.of(cuotaFebrero, cuotaMarzo, cuotaAbril);
    }

}
