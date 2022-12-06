package com.projeto.locadoraApi.model;

import com.projeto.locadoraApi.enums.VeiculoTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 40)
    private String codigo;
    @Enumerated(EnumType.STRING)
    private VeiculoTipo veiculoTipo;
    private String modelo;
    private Long ano;
    private String cor;
    @Column(unique = true)
    private String placa;
    private double valorDiaria;

}
