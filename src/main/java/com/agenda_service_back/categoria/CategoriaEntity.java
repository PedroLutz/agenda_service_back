package com.agenda_service_back.categoria;

import com.agenda_service_back.servico.ServicoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="categoria")
public class CategoriaEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Long categoria_id;
    @Column(name = "categoria_nome")
    private String categoria_nome;
    @Column(name = "categoria_descricao")
    private String categoria_descricao;
    @OneToMany(mappedBy = "servico_categoria_id", fetch = FetchType.EAGER)
    private List<ServicoEntity> servicos;

    @Override
    public String toString() {
        return "CategoriaEntity{" +
                "categoria_id=" + categoria_id +
                ", categoria_nome='" + categoria_nome + '\'' +
                ", categoria_descricao='" + categoria_descricao + '\'' +
                '}';
    }
}
