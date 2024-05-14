package com.agenda_service_back.telefone;

import com.agenda_service_back.prestadores.PrestadorEntity;
import com.agenda_service_back.usuarios.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="telefones")
public class TelefoneEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="telefone_id")
    private Long telefone_id;

    @Column(name="telefone_numero", nullable = false, length = 45)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(XX) XXXX-XXXX")
    private String telefone_numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_usuario_id")
    private UsuarioEntity telefone_usuario_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_prestador_id")
    private PrestadorEntity telefone_prestador_id;

    @Override
    public String toString() {
        return "TelefoneEntity{" +
                "telefone_id=" + telefone_id +
                ", telefone_numero='" + telefone_numero + '\'' +
                ", telefone_usuario_id=" + telefone_usuario_id +
                ", telefone_prestador_id=" + telefone_prestador_id +
                '}';
    }
}
