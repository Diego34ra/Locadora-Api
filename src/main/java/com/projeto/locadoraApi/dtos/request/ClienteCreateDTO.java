package com.projeto.locadoraApi.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ClienteCreateDTO {

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
