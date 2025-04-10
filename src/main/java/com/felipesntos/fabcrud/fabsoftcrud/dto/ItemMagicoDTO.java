package com.felipesntos.fabcrud.fabsoftcrud.dto;

import com.felipesntos.fabcrud.fabsoftcrud.model.enumerator.TipoItem;

import java.io.Serializable;

public class ItemMagicoDTO implements Serializable {
    private Long id;

    private String nome;

    private TipoItem tipo;

    private Integer forca;

    private Integer defesa;
}
