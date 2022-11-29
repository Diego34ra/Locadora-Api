package com.projeto.locadoraApi.dtos.request;

import com.projeto.locadoraApi.model.Cliente;
import com.projeto.locadoraApi.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AluguelDTO {

    private Long id;

    private Long cliente_id;

    private List<Long> veiculos_id;
    //private LocalDate dataAluguel;
    //private LocalDate dataDevolucao;
    private Double valorTotal;
}
