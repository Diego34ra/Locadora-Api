package com.projeto.locadoraApi.dtos.request;

import com.projeto.locadoraApi.enums.VeiculoTipo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class VeiculoCreateDTO {

    @Enumerated(EnumType.STRING)
    private VeiculoTipo veiculoTipo;
    @NotEmpty
    private String modelo;
    private Long ano;
    @NotEmpty
    private String cor;
    @NotEmpty
    @Column(unique = true)
    private String placa;
    private double valorDiaria;
}
