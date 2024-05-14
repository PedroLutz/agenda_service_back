package com.agenda_service_back.prestadores;

import com.agenda_service_back.endereco.EnderecoEntity;
import com.agenda_service_back.servico.ServicoEntity;
import com.agenda_service_back.telefone.TelefoneEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long prestador_id;
    @NotNull(message = "O campo NOME é requerido")
    private String prestador_nome;
    @NotNull(message = "O campo CNPJ é requerido")
    private String prestador_cnpj;
    @NotNull(message = "O campo EMAIL é requerido")
    private String prestador_email;
    @NotNull(message = "O campo ENDERECO é requerido")
    private EnderecoEntity prestador_endereco_id;
    @NotNull(message = "O campo RAZAO SOCIAL é requerido")
    private String prestador_razao_social;
    @NotNull(message = "O campo SENHA é requerido")
    private String prestador_senha;
    @CPF
    @NotNull(message = "O campo CPF é requerido")
    private String prestador_cpf;
}
