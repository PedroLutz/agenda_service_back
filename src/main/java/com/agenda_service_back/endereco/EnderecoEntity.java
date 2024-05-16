package com.agenda_service_back.endereco;

import com.agenda_service_back.prestadores.PrestadorEntity;
import com.agenda_service_back.usuarios.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "endereco")
public class EnderecoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Long endereco_id;

    @Column(name = "endereco_rua")
    private String endereco_rua;

    @Column(name = "endereco_cep")
    private String endereco_cep;

    @Column(name = "endereco_numero")
    private int endereco_numero;

    @Column(name = "endereco_complemento")
    private String endereco_complemento;

    @Column(name = "endereco_cidade")
    private String endereco_cidade;

    @Column(name = "endereco_estado")
    private String endereco_estado;

    @Column(name = "endereco_bairro")
    private String endereco_bairro;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario_endereco_id", fetch = FetchType.EAGER)
    private List<UsuarioEntity> usuarios;
    @JsonIgnore
    @OneToMany(mappedBy = "prestador_endereco_id", fetch = FetchType.EAGER)
    private List<PrestadorEntity> prestadores;

    @Override
    public String toString() {
        return "EnderecoEntity{" +
                "endereco_id=" + endereco_id +
                ", endereco_rua='" + endereco_rua + '\'' +
                ", endereco_cep='" + endereco_cep + '\'' +
                ", endereco_numero=" + endereco_numero +
                ", endereco_complemento='" + endereco_complemento + '\'' +
                ", endereco_cidade='" + endereco_cidade + '\'' +
                ", endereco_estado='" + endereco_estado + '\'' +
                ", endereco_bairro='" + endereco_bairro + '\'' +
                '}';
    }
}
