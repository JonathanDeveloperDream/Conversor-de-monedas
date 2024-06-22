package com.aluracursos.conversor.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaMoneda {

    private int opcionSelec;
    private String monedabase = "";
    private String monedaCovert = "";
    private double cantidad = 0;
    private List <Moneda> monedas = new ArrayList<>();
    private Scanner promp = new Scanner(System.in);
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();


    public void consultaMoneda () {
            System.out.println("******************************************************************");
            System.out.println("            Sea bienvenid@ al Conversor de Monedas                ");
            System.out.println("                                                                  ");
            System.out.println("                1) Dolar =>> Peso argentino                       ");
            System.out.println("                2) Peso argentino =>> Dolar                       ");
            System.out.println("                3) Dolar =>> Real brasileño                       ");
            System.out.println("                4) Real brasileño =>> Dolar                       ");
            System.out.println("                5) Dolar =>> Peso colombiano                      ");
            System.out.println("                6) Peso colombiano =>> Dolar                      ");
            System.out.println("                7) Salir                                          ");
            System.out.println("                                                                  ");
            System.out.println("******************************************************************");
            System.out.println("                   Elija una opcion valida                        ");
            opcionSelec = Integer.valueOf(promp.nextLine());
            switch (opcionSelec) {
                case 1:
                    this.monedabase = "USD";
                    this.monedaCovert = "ARS";
                    break;
                case 2:
                    this.monedabase = "ARS";
                    this.monedaCovert = "USD";
                    break;
                case 3:
                    monedabase = "USD";
                    monedaCovert = "BRL";
                    break;
                case 4:
                    this.monedabase = "BRL";
                    this.monedaCovert = "USD";
                    break;
                case 5:
                    this.monedabase = "USD";
                    this.monedaCovert = "COP";
                    break;
                case 6:
                    this.monedabase = "COP";
                    this.monedaCovert = "USD";
                    break;
            }
            System.out.println("Ingrese la catidad a convertir:");
            this.cantidad = Double.valueOf(promp.nextLine());
    }

    public void consultaHttp () {
        try {
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ec968561e7aa50b690d09897/pair/"
                    + monedabase + "/" + monedaCovert + "/" + cantidad);
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            ExchangeRate miConvercion = gson.fromJson(json, ExchangeRate.class);
            //System.out.println(miConvercion);
            Moneda moneda = new Moneda(miConvercion);
            System.out.println(moneda);

            monedas.add(moneda);

            FileWriter escritura = new FileWriter("conversiones.json");
            escritura.write(gson.toJson(monedas));
            escritura.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}