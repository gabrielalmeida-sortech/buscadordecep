package br.com.sortech.buscadordecep.servico.DTO;

import br.com.sortech.buscadordecep.dominio.Uf;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegiaoDTO implements Serializable {

    private Long id;
    private String regiao;
    private Uf uf;


}
