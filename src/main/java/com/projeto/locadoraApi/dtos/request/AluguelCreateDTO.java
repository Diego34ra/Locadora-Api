package com.projeto.locadoraApi.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AluguelCreateDTO {

    private String cliente_id;

    private List<String> veiculos_id;

}
