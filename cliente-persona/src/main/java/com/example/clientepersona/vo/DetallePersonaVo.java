package com.example.clientepersona.vo;

import com.example.clientepersona.domain.Cuota;
import com.example.clientepersona.domain.Persona;
import com.example.clientepersona.domain.Tarjeta;
import java.util.List;

public class DetallePersonaVo {

    private List<Cuota> deuda;
    private Tarjeta tarjeta;
    private Persona persona;
    
    public List<Cuota> getDeuda() {
        return deuda;
    }

    public void setDeuda(List<Cuota> deuda) {
        this.deuda = deuda;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
