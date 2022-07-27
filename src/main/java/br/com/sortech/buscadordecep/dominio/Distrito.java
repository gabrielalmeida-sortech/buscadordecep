package br.com.sortech.buscadordecep.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "distrito")
public class Distrito {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;


}
