package com.acc.amar.mais.models.enuns;

public enum  CategoriaEnum {
    Medicação(1), Mobiliário(2), Equipamento(3);

    private int id;
    CategoriaEnum(int id) {
        this.id = id;
    }

    public int getValue(){
        return this.id;
    }
}