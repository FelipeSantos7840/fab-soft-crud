package com.felipesntos.fabcrud.fabsoftcrud.model;

import com.felipesntos.fabcrud.fabsoftcrud.model.enumerator.Classe;
import com.felipesntos.fabcrud.fabsoftcrud.model.enumerator.TipoItem;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "personagem_tb")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "nome_aventureiro")
    private String nomeAventureiro;

    private Classe classe;

    private Integer level;

    private Integer forca;

    private Integer defesa;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "personagem_id")
    private List<ItemMagico> itemMagicos;

    public Personagem() {
    }

    public Personagem(Long id, String nome, String nomeAventureiro, Classe classe, Integer level, Integer forca, Integer defesa, List<ItemMagico> itemMagicos) {
        this.id = id;
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = level;
        this.forca = forca;
        this.defesa = defesa;
        this.itemMagicos = itemMagicos;
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

    public List<ItemMagico> getItemMagicos() {
        return itemMagicos;
    }

    public void setItemMagicos(List<ItemMagico> itemMagicos) {
        this.itemMagicos = itemMagicos;
    }

    public void addItemMagico(ItemMagico itemMagico){
        this.itemMagicos.add(itemMagico);
    }

    public void removeItemMagico(ItemMagico itemMagico){
        this.itemMagicos.remove(itemMagico);
    }

    public boolean hasItemMagicoItem(TipoItem tipoItem){
        return getItemMagicos().stream().anyMatch((item -> {
            return item.getTipo().equals(tipoItem);
        }));
    }

}
