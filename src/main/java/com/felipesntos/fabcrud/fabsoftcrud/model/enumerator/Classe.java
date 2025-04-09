package com.felipesntos.fabcrud.fabsoftcrud.model.enumerator;

public enum Classe {
    GUERREIRO("guerreiro"), MAGO("mago"), ARQUEIRO("arqueiro"), LADINO("ladino"), BARDO("bardo");

    private final String nomeClasse;

    Classe(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public static Classe fromValue(String value){
        for (Classe classe : values()){
            String nomeClasse = classe.getNomeClasse();
            if(nomeClasse.equals(value)){
                return classe;
            }
        }
        throw new IllegalArgumentException("Invalid value for Classe");
    }
}
