package com.projeto.locadoraApi.dtos.request;

import com.projeto.locadoraApi.enums.VeiculoTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {

    private String codigo;
    @Enumerated(EnumType.STRING)
    private VeiculoTipo veiculoTipo;
    private String marca;
    private Long ano;
    private String cor;
    @Column(unique = true)
    private String placa;
    private double valorDiaria;
}
