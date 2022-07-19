package br.com.sortech.buscadordecep.servico.mapper;

import br.com.sortech.buscadordecep.dominio.Faixa;
import br.com.sortech.buscadordecep.servico.DTO.FaixaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface FaixaMapper extends EntityMepper<FaixaDTO, Faixa> {
}