package com.felipesntos.fabcrud.fabsoftcrud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "itemmagico_tb")
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String tipo;

    private Integer forca;

    private Integer defesa;

    @ManyToOne
    @JoinColumn(name = "personagem_id")
    private Personagem personagem;

    public ItemMagico() {
    }

    public ItemMagico(Long id, String nome, String tipo, Integer forca, Integer defesa, Personagem personagem) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.defesa = defesa;
        this.personagem = personagem;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}
