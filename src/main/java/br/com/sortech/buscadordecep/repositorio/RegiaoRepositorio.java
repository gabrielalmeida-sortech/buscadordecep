package br.com.sortech.buscadordecep.repositorio;

import br.com.sortech.buscadordecep.dominio.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RegiaoRepositorio extends JpaRepository<Regiao, Long>, JpaSpecificationExecutor<Regiao> {

}
