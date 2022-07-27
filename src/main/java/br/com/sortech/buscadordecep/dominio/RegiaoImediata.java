package br.com.sortech.buscadordecep.dominio;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "regiao_Imediata")
public class RegiaoImediata {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "regiao_intermediaria_id")
    private RegiaoIntermediaria regiaoIntermediaria;

}
