package com.agenda_service_back.servico;

import com.agenda_service_back.categoria.CategoriaEntity;
import com.agenda_service_back.prestadores.PrestadorEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long servico_id;
    @NotNull(message = "O campo NOME é requerido.")
    private String servico_nome;
    @NotNull(message = "O campo INFORMACOES EXTRA é requerido.")
    private String servico_informacoes_extra;
    @NotNull(message = "O campo DESCRICAO é requerido.")
    private String servico_descricao;
    @NotNull(message = "O campo PRECO é requerido.")
    private double servico_preco;
    @NotNull(message = "O campo CATEGORIA é requerido.")
    private CategoriaEntity servico_categoria_id;
    @NotNull(message = "O campo PRESTADOR é requerido.")
    private PrestadorEntity servico_prestador_id;
}
