package com.aluracursos.conversor.modelos;

public record ExchangeRate(String base_code, String target_code, Double conversion_rate, Double conversion_result) {
}
