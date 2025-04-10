package com.felipesntos.fabcrud.fabsoftcrud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.felipesntos.fabcrud.fabsoftcrud.model.enumerator.TipoItem;

import java.io.Serializable;

public class ItemMagicoDTO implements Serializable {
    private Long id;

    private String nome;

    private TipoItem tipo;

    private Integer forca;

    private Integer defesa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PersonagemDTO personagem;

    public ItemMagicoDTO() {
    }

    public ItemMagicoDTO(Long id, String nome, TipoItem tipo, Integer forca, Integer defesa) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.defesa = defesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public PersonagemDTO getPersonagem() {
        return personagem;
    }

    public void setPersonagem(PersonagemDTO personagem) {
        this.personagem = personagem;
    }
}
