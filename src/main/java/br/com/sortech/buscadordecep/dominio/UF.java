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
@Table(name = "UF")
public class UF {

    @Id
    private Long id;

    private String nome;

    private String sigla;

    @ManyToOne
    @JoinColumn(name = "regiao_id")
    private Regiao regiao;

}