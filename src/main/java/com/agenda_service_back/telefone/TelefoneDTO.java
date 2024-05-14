package com.agenda_service_back.telefone;

import com.agenda_service_back.prestadores.PrestadorEntity;
import com.agenda_service_back.usuarios.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long telefone_id;
    @NotNull(message = "O campo NUMERO é requerido")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(XX) XXXX-XXXX")
    private String telefone_numero;
    @NotNull(message = "O campo USUARIO é requerido")
    private UsuarioEntity telefone_usuario_id;
    @NotNull(message = "O campo PRESTADOR é requerido")
    private PrestadorEntity telefone_prestador_id;
}
