package com.aluracursos.conversor.modelos;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Moneda {
    private String codigoBase;
    private String codigoObjetivo;
    private Double tasaDeCoversion;
    private Double resultadoDeCoversion;

    public Moneda(ExchangeRate miConvercion) {
        this.codigoBase = miConvercion.base_code();
        this.codigoObjetivo = miConvercion.target_code();
        this.tasaDeCoversion = miConvercion.conversion_rate();
        this.resultadoDeCoversion = miConvercion.conversion_result();
    }


    @Override
    public String toString() {
        return "Moneda" +
                "codigoBase='" + codigoBase +
                ", codigoObjetivo='" + codigoObjetivo +
                ", tasaDeCoversion=" + tasaDeCoversion +
                ", resultadoDeCoversion=" + resultadoDeCoversion ;
    }
}
