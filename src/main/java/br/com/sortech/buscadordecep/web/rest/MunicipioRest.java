package br.com.sortech.buscadordecep.web.rest;


import br.com.sortech.buscadordecep.dominio.Municipio;
import br.com.sortech.buscadordecep.dominio.RegiaoImediata;
import br.com.sortech.buscadordecep.repositorio.MicrorregiaoRepositorio;
import br.com.sortech.buscadordecep.repositorio.MunicipioRepositorio;
import br.com.sortech.buscadordecep.repositorio.RegiaoImediataRepositorio;
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
@RequestMapping(value = "api/municipios")
public class MunicipioRest {

    private final MunicipioRepositorio municipioRepositorio;
    private final RegiaoImediataRepositorio regiaoImediataRepositorio;
    private final MicrorregiaoRepositorio microrregiaoRepositorio;


    @GetMapping("/popular")
    public ResponseEntity<Municipio> popularTabelas() {
        List<Municipio> lista =  new ArrayList<>();

        regiaoImediataRepositorio.findAll().forEach( regiaoImediata  ->{
            String url = "https://servicodados.ibge.gov.br/api/v1/localidades/regioes-imediatas/"+ regiaoImediata.getId() +"/municipios";
            RestTemplate restTemplate = new RestTemplate();

            Municipio[] municipios = restTemplate.getForObject(url, Municipio[].class);
            lista.addAll(Arrays.asList(municipios));

            lista.forEach(municipio -> {
                if (municipio.getRegiaoImediata() == null) {
                    municipio.setRegiaoImediata(regiaoImediata);
                }
            });
        });

        municipioRepositorio.saveAll(lista);




        return ResponseEntity.ok().build();
    }

}
