package com.projeto.locadoraApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluguel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Cliente cliente;
    @OneToMany
    private List<Veiculo> veiculos;
    //private LocalDate dataAluguel;
    //private LocalDate dataDevolucao;
    private Double valorTotal;
}
