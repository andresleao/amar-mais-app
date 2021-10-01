package com.acc.amar.mais.models.enuns;

public enum ClassificacaoEnum {
    MEDICACAO(1, "Medicação"),
    MOBILIARIO(2, "Moboliario"),
    EQUIPAMENTO(3, "Equipamento");

    private int id;
    private String descricao;

    ClassificacaoEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId(){
        return this.id;
    }
    public String getString(){
        return this.descricao;
    }

    public static ClassificacaoEnum toEnum(int id){
        if(id == 0){
            return null;
        }
        for(ClassificacaoEnum classificacaoEnum : ClassificacaoEnum.values()){
            if(id == classificacaoEnum.getId()){
                return classificacaoEnum;
            }
        }
        throw new IllegalArgumentException("Id inválido: "+ id);
    }

    public static ClassificacaoEnum toEnum(String descricao){
        if(descricao == null){
            return null;
        }
        for(ClassificacaoEnum classificacaoEnum : ClassificacaoEnum.values()){
            if(descricao.equals(classificacaoEnum.getString())){
                return classificacaoEnum;
            }
        }
        throw new IllegalArgumentException("Descrição inválido: "+ descricao);
    }

}