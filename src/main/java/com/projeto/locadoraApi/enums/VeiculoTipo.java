package com.projeto.locadoraApi.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VeiculoTipo {
    CARRO("Carro"),
    CAMINHAO("Caminhao"),
    MOTO("Moto");

    private final String description;
}
