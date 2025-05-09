package com.felipesntos.fabcrud.fabsoftcrud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.felipesntos.fabcrud.fabsoftcrud.model.ItemMagico;
import com.felipesntos.fabcrud.fabsoftcrud.model.enumerator.Classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDTO implements Serializable {

    private Long id;
    private String nome;
    private String nomeAventureiro;
    private Classe classe;
    private Integer level;
    private Integer forca;
    private Integer defesa;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ItemMagicoDTO> itensMagicos = new ArrayList<>();

    public PersonagemDTO() {
    }

    public PersonagemDTO(Long id, String nome, String nomeAventureiro, Classe classe, Integer level, Integer forca, Integer defesa, List<ItemMagicoDTO> itensMagicos) {
        this.id = id;
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = level;
        this.forca = forca;
        this.defesa = defesa;
        this.itensMagicos = itensMagicos;
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

    public String getNomeAventureiro() {
        return nomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public List<ItemMagicoDTO> getItensMagicos() {
        return itensMagicos;
    }

    public void setItensMagicos(List<ItemMagicoDTO> itensMagicos) {
        this.itensMagicos = itensMagicos;
    }

    public void updateAttributes(){
        itensMagicos.forEach((itemMagico -> {
            this.forca+=itemMagico.getForca();
            this.defesa+=itemMagico.getDefesa();
        }));
    }
}
