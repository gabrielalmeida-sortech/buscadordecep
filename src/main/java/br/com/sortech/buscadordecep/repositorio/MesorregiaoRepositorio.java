package br.com.sortech.buscadordecep.repositorio;

import br.com.sortech.buscadordecep.dominio.Mesorregiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MesorregiaoRepositorio extends JpaRepository<Mesorregiao, Long>, JpaSpecificationExecutor<Mesorregiao> {
}
