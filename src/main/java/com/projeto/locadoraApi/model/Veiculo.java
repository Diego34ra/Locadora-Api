package com.projeto.locadoraApi.model;

import com.projeto.locadoraApi.enums.VeiculoTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Enumerated(EnumType.STRING)
    private VeiculoTipo veiculoTipo;
    private String modelo;
    private Integer ano;
    private String cor;
    private String placa;
    private Double valorDiaria;
    @ManyToOne
    private Aluguel aluguel;
}
