package com.felipesntos.fabcrud.fabsoftcrud.model.enumerator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoItem {
    ARMA("arma"), ARMADURA("armadura"), AMULETO("amuleto");

    private final String nomeTipo;

    TipoItem(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    @JsonValue
    public String getNomeTipo() {
        return nomeTipo;
    }

    @JsonCreator
    public static TipoItem fromValue(String value){
        for (TipoItem tipoItem : values()){
            String nomeTipo = tipoItem.getNomeTipo();
            if(nomeTipo.equals(value)){
                return tipoItem;
            }
        }
        throw new IllegalArgumentException("Invalid value for TipoItem!");
    }
}
