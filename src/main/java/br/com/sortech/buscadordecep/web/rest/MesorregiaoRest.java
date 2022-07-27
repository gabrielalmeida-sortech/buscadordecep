package br.com.sortech.buscadordecep.web.rest;


import br.com.sortech.buscadordecep.dominio.Mesorregiao;
import br.com.sortech.buscadordecep.dominio.Microrregiao;
import br.com.sortech.buscadordecep.dominio.Municipio;
import br.com.sortech.buscadordecep.dominio.UF;
import br.com.sortech.buscadordecep.repositorio.EstadoRepositorio;
import br.com.sortech.buscadordecep.repositorio.MesorregiaoRepositorio;
import br.com.sortech.buscadordecep.repositorio.MicrorregiaoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin()
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/mesorregiao")
public class MesorregiaoRest {

    private final MesorregiaoRepositorio mesorregiaoRepositorio;
    private final EstadoRepositorio estadoRepositorio;

    @GetMapping("/popular")
    public ResponseEntity<Mesorregiao> popularTabelas() {
        List<Mesorregiao> lista = new ArrayList<>();

        for (int i = 11; i < 54; i++) {

            String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + i + "/mesorregioes";
            RestTemplate restTemplate = new RestTemplate();

            Mesorregiao[] mesorregioes = restTemplate.getForObject(url, Mesorregiao[].class);
            lista.addAll(Arrays.asList(mesorregioes));

            UF estado = estadoRepositorio.getReferenceById((long) i);

            lista.forEach(mesorregiao -> {
                if(mesorregiao.getUF() == null){
                    mesorregiao.setUF(estado);
                }
            });
        }

        mesorregiaoRepositorio.saveAll(lista);

        return ResponseEntity.ok().build();
    }
}
