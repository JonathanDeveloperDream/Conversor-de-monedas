package com.aluracursos.conversor.principal;

import com.aluracursos.conversor.modelos.ConsultaMoneda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String salir = "";
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Scanner promp = new Scanner(System.in);
        while (true){
            consultaMoneda.consultaMoneda();
            consultaMoneda.consultaHttp();
            System.out.println("******************************************************************");
            System.out.println("                  Desea salir del programa? si/no");
            salir = promp.nextLine();
            if (salir.equals("si")) {
                break;
            }else {
                System.out.println("Continuando...");
            }
        }
        System.out.println("Gracias por usar el conversor de monedas");
    }
}