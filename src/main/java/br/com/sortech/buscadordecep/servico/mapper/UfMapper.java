package br.com.sortech.buscadordecep.servico.mapper;

import br.com.sortech.buscadordecep.dominio.Cep;
import br.com.sortech.buscadordecep.dominio.Uf;
import br.com.sortech.buscadordecep.servico.DTO.CepDTO;
import br.com.sortech.buscadordecep.servico.DTO.UfDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface UfMapper extends EntityMepper<UfDTO, Uf> {
}

