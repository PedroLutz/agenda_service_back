package com.agenda_service_back.usuarios;

import com.agenda_service_back.endereco.EnderecoEntity;
import com.agenda_service_back.telefone.TelefoneEntity;
import com.agenda_service_back.agendamentos.AgendamentoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long usuario_id;

    @NotNull(message = "O campo NOME é requerido.")
    private String usuario_nome;

    @CPF
    @NotNull(message = "O campo CPF é requerido.")
    private String usuario_cpf;

    @NotNull(message = "O campo EMAIL é requerido.")
    private String usuario_email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "O campo DATA DE NASCIMENTO é requerido.")
    private LocalDate usuario_data_nascimento;

    @NotNull(message = "O campo SENHA é requerido.")
    private String usuario_senha;

    @NotNull(message = "O campo ENDERECO é requerido.")
    private EnderecoEntity usuario_endereco_id;
}
