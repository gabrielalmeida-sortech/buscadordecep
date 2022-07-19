package br.com.sortech.buscadordecep.servico.DTO;

import br.com.sortech.buscadordecep.dominio.Regiao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaixaDTO implements Serializable {

    private Long id;
    private Regiao regiao;
    private long faixaInicial;
    private long faixaFinal;

}
