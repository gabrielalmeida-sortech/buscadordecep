package br.com.sortech.buscadordecep.repositorio;

import br.com.sortech.buscadordecep.dominio.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MunicipioRepositorio extends JpaRepository<Municipio, Long>, JpaSpecificationExecutor<Municipio> {
}
