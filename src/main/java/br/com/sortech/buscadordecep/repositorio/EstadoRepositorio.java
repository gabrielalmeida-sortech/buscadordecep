package br.com.sortech.buscadordecep.repositorio;


import br.com.sortech.buscadordecep.dominio.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface EstadoRepositorio extends JpaRepository<UF, Long>, JpaSpecificationExecutor<UF> {

}
