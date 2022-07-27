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
@Table(name = "microrregiao")
public class Microrregiao {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "mesorregiao_id")
    private Mesorregiao mesorregiao;


}
