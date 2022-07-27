package br.com.sortech.buscadordecep.repositorio;

import br.com.sortech.buscadordecep.dominio.RegiaoIntermediaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RegiaoIntermediariaRepositorio extends JpaRepository<RegiaoIntermediaria, Long>, JpaSpecificationExecutor<RegiaoIntermediaria> {
}
