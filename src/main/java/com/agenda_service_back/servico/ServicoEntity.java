package com.agenda_service_back.servico;

import com.agenda_service_back.categoria.CategoriaEntity;
import com.agenda_service_back.prestadores.PrestadorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servico")
public class ServicoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="servico_id")
    private Long servico_id;

    @Column(name="servico_nome")
    private String servico_nome;

    @Column(name = "servico_informacoes_extra")
    private String servico_informacoes_extra;

    @Column(name = "servico_descricao")
    private String servico_descricao;

    @Column(name="servico_preco")
    private double servico_preco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servico_categoria_id", nullable = false)
    private CategoriaEntity servico_categoria_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servico_prestador_id", nullable = false)
    private PrestadorEntity servico_prestador_id;

    @Override
    public String toString() {
        return "ServicoEntity{" +
                "servico_id=" + servico_id +
                ", servico_nome='" + servico_nome + '\'' +
                ", servico_informacoes_extra='" + servico_informacoes_extra + '\'' +
                ", servico_descricao='" + servico_descricao + '\'' +
                ", servico_preco=" + servico_preco +
                ", servico_categoria_id=" + servico_categoria_id +
                ", servico_prestador_id=" + servico_prestador_id +
                '}';
    }
}
