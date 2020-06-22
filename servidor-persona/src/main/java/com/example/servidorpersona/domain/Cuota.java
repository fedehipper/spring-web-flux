package com.example.servidorpersona.domain;

import java.math.BigDecimal;

public class Cuota {

    private BigDecimal monto;
    private String mes;

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

}
