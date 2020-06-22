package com.example.clientetradicional.vo;

import com.example.clientetradicional.domain.Cuota;
import com.example.clientetradicional.domain.Persona;
import com.example.clientetradicional.domain.Tarjeta;
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
