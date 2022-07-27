package br.com.sortech.buscadordecep.web.rest;

import br.com.sortech.buscadordecep.dominio.Municipio;
import br.com.sortech.buscadordecep.dominio.RegiaoImediata;
import br.com.sortech.buscadordecep.dominio.RegiaoIntermediaria;
import br.com.sortech.buscadordecep.dominio.UF;
import br.com.sortech.buscadordecep.repositorio.EstadoRepositorio;
import br.com.sortech.buscadordecep.repositorio.RegiaoImediataRepositorio;
import br.com.sortech.buscadordecep.repositorio.RegiaoIntermediariaRepositorio;
import lombok.RequiredArgsConstructor;
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
@RequestMapping(value = "api/regiaoImediata")
public class RegiaoImediataRest {
    private final RegiaoImediataRepositorio repositorio;
    private final RegiaoIntermediariaRepositorio regiaoIntermediariaRepositorio;


    @GetMapping("/popular")
    public ResponseEntity<RegiaoImediata> popularTabelas() {

        List<RegiaoImediata> lista =  new ArrayList<>();
        regiaoIntermediariaRepositorio.findAll().forEach((intermediaria) ->{
            String url = "https://servicodados.ibge.gov.br/api/v1/localidades/regioes-intermediarias/"+ intermediaria.getId() + "/regioes-imediatas";
            RestTemplate restTemplate = new RestTemplate();

            RegiaoImediata[] regioesIm = restTemplate.getForObject(url, RegiaoImediata[].class);
            lista.addAll(Arrays.asList(regioesIm));

            lista.forEach(regiaIm -> {
                if (regiaIm.getRegiaoIntermediaria() == null) {
                    regiaIm.setRegiaoIntermediaria(intermediaria);
                }
            });
        });


        repositorio.saveAll(lista);


        return ResponseEntity.ok().build();
    }
}
