package br.com.sortech.buscadordecep.servico.mapper;

import br.com.sortech.buscadordecep.dominio.Cep;
import br.com.sortech.buscadordecep.dominio.Regiao;
import br.com.sortech.buscadordecep.servico.DTO.CepDTO;
import br.com.sortech.buscadordecep.servico.DTO.RegiaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RegiaoMapper extends EntityMepper<RegiaoDTO, Regiao> {
}

