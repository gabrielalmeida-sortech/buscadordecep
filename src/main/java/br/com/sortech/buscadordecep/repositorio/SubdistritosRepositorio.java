package br.com.sortech.buscadordecep.repositorio;

import br.com.sortech.buscadordecep.dominio.Subdistrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubdistritosRepositorio extends JpaRepository<Subdistrito, Long>, JpaSpecificationExecutor<Subdistrito> {
}
