package br.com.sortech.buscadordecep.repositorio;

import br.com.sortech.buscadordecep.dominio.Microrregiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MicrorregiaoRepositorio extends JpaRepository<Microrregiao, Long>, JpaSpecificationExecutor<Microrregiao> {

}
