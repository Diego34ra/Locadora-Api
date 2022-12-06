package com.projeto.locadoraApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 40)
    private String id;

    @Column(unique = true)
    private String cpf;

    private String nome;

    private String endereco;

    private String cidade;
}
