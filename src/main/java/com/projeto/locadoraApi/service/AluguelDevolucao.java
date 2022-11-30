package com.projeto.locadoraApi.service;

import com.projeto.locadoraApi.model.Aluguel;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AluguelDevolucao {

    public static Double getConta(Aluguel aluguel, Double valorDiaria) {
        return getConta(aluguel.getDataAluguel(), aluguel.getDataDevolucao(), valorDiaria);
    }

//    private static Double getConta(LocalDateTime aluguel, LocalDateTime devolucao) {
//        long dias = aluguel.until(devolucao, ChronoUnit.DAYS);
//        return 1500.00 * (dias + 1);
//    }

    private static Double getConta(LocalDateTime aluguel, LocalDateTime devolucao, Double valorDiaria) {
        long dias = aluguel.until(devolucao, ChronoUnit.DAYS);
        return valorDiaria * (dias + 1);
    }
}
