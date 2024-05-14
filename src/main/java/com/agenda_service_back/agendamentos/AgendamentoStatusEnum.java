package com.agenda_service_back.agendamentos;

public enum AgendamentoStatusEnum {
    PENDENTE("Pendente"),
    CONCLUIDO("Concluido"),
    CANCELADO("Cancelado"),
    EM_ANDAMENTO("Em Andamento");
    private final String descricao;
    AgendamentoStatusEnum(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return descricao;
    }
}