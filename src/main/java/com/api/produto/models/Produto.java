package com.api.produto.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name="TB_PRODUTO") // Escalável se usar framework Flyway migration - projeto simples.
@Getter
@Setter
public class Produto implements Serializable {

    private static final long serialVersionUID =1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Pode ser AUTO sem o flyway migration
    private Long id;

    private String nome;

    private BigDecimal quantidade;

    private BigDecimal valor;

}
