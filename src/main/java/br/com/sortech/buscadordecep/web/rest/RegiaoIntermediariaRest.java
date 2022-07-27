package br.com.sortech.buscadordecep.web.rest;


import br.com.sortech.buscadordecep.dominio.Microrregiao;
import br.com.sortech.buscadordecep.dominio.Municipio;
import br.com.sortech.buscadordecep.dominio.RegiaoIntermediaria;
import br.com.sortech.buscadordecep.dominio.UF;
import br.com.sortech.buscadordecep.repositorio.EstadoRepositorio;
import br.com.sortech.buscadordecep.repositorio.MunicipioRepositorio;
import br.com.sortech.buscadordecep.repositorio.RegiaoIntermediariaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin()
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/regiaoIntermediaria")
public class RegiaoIntermediariaRest {


    private final RegiaoIntermediariaRepositorio repositorio;
    private final EstadoRepositorio estadoRepositorio;


    @GetMapping("/popular")
    public ResponseEntity<RegiaoIntermediaria> popularTabelas() {

        List<RegiaoIntermediaria> lista =  new ArrayList<>();

        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/regioes-intermediarias";
        RestTemplate restTemplate = new RestTemplate();

        RegiaoIntermediaria[] regioesInt = restTemplate.getForObject(url, RegiaoIntermediaria[].class);
        lista.addAll(Arrays.asList(regioesInt));

        lista.forEach(regiaInt -> {
            if(regiaInt.getUf()== null){
                Long i = regiaInt.getId() / 100;
                UF estado = estadoRepositorio.getReferenceById((long) i);
                regiaInt.setUf(estado);
            }
        });

        repositorio.saveAll(lista);


        return ResponseEntity.ok().build();
    }
}
