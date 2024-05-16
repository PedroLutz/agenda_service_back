package com.agenda_service_back.prestadores;

import com.agenda_service_back.endereco.EnderecoEntity;
import com.agenda_service_back.servico.ServicoEntity;
import com.agenda_service_back.telefone.TelefoneEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="prestadores")
public class PrestadorEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prestador_id")
    private Long prestador_id;

    @Column(name="prestador_nome")
    private String prestador_nome;

    @Column(name="prestador_cnpj", unique = true)
    private String prestador_cnpj;

    @Column(name="prestador_email", unique = true)
    private String prestador_email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prestador_endereco_id", nullable = false)
    private EnderecoEntity prestador_endereco_id;

    @Column(name="prestador_razao_social")
    private String prestador_razao_social;

    @Column(name="prestador_senha")
    private String prestador_senha;

    @CPF
    @Column(name="prestador_cpf")
    private String prestador_cpf;

    @JsonIgnore
    @OneToMany(mappedBy ="telefone_prestador_id", fetch = FetchType.EAGER)
    private List<TelefoneEntity> telefones;

    @JsonIgnore
    @OneToMany(mappedBy = "servico_prestador_id", fetch = FetchType.EAGER)
    private List<ServicoEntity> servicos;

    @Override
    public String toString() {
        return "PrestadorEntity{" +
                "prestador_id=" + prestador_id +
                ", prestador_nome='" + prestador_nome + '\'' +
                ", prestador_cnpj='" + prestador_cnpj + '\'' +
                ", prestador_email='" + prestador_email + '\'' +
                ", prestador_endereco_id=" + prestador_endereco_id +
                ", prestador_razao_social='" + prestador_razao_social + '\'' +
                ", prestador_senha='" + prestador_senha + '\'' +
                ", prestador_cpf='" + prestador_cpf + '\'' +
                '}';
    }
}
