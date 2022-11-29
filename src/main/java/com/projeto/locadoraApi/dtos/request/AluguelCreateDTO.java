package com.projeto.locadoraApi.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AluguelCreateDTO {

    private Long cliente_id;

    private List<Long> veiculos_id;
    //private LocalDate dataAluguel;
    //private LocalDate dataDevolucao;
    private Double valorTotal;
}
