package br.com.sortech.buscadordecep.servico.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UfDTO implements Serializable {

    private Long id;

    private String uf;


}
