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
@Table(name = "municipio")
public class Municipio {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "microrregiao_id")
    private Microrregiao microrregiao;

    @ManyToOne
    @JoinColumn(name = "regiao_intermediaria_id")
    private RegiaoImediata regiaoImediata;



}
