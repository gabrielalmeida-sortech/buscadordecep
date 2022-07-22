package br.com.sortech.buscadordecep.repositorio;

import br.com.sortech.buscadordecep.dominio.Cep;
import br.com.sortech.buscadordecep.dominio.Faixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FaixaRepositorio extends JpaRepository<Faixa, Long>, JpaSpecificationExecutor<Faixa> {

//    boolean existsByFaixa(Long faixa);
}
