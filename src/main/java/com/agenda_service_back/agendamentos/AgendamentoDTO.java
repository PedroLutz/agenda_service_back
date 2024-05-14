package com.agenda_service_back.agendamentos;

import com.agenda_service_back.servico.ServicoEntity;
import com.agenda_service_back.usuarios.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long agendamento_id;

    @NotNull(message = "O campo DATA é requerido.")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate agendamento_data;

    @NotNull(message = "O campo HORA é requerido.")
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
    private LocalTime agendamento_hora;

    @NotNull(message = "O campo OBSERVACAO é requerido.")
    private String agendamento_observacao;

    @NotNull(message = "O campo STATUS é requerido.")
    @Enumerated(EnumType.STRING)
    private AgendamentoStatusEnum agendamento_status;

    @NotNull(message = "O campo USUARIO é requerido.")
    private UsuarioEntity agendamento_usuario_id;

    @NotNull(message = "O campo SERVICO é requerido.")
    private ServicoEntity agendamento_servico_id;

}