package br.com.sortech.buscadordecep.repositorio;

import br.com.sortech.buscadordecep.dominio.RegiaoImediata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RegiaoImediataRepositorio extends JpaRepository<RegiaoImediata, Long>, JpaSpecificationExecutor<RegiaoImediata> {
}
