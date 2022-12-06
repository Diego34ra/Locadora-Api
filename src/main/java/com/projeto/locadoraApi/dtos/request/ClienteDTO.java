package com.projeto.locadoraApi.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private String id;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String endereco;

    @NotEmpty
    private String cidade;
}
