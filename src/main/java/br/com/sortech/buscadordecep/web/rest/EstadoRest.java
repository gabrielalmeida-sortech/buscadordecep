package br.com.sortech.buscadordecep.web.rest;

import br.com.sortech.buscadordecep.dominio.UF;
import br.com.sortech.buscadordecep.repositorio.EstadoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@CrossOrigin()
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/estados")
public class EstadoRest {

    private final EstadoRepositorio estadoRepositorio;

    @GetMapping("/popular")
    public ResponseEntity<UF> salvar(){
        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";
        RestTemplate restTemplate = new RestTemplate();

        UF[] UFs = restTemplate.getForObject(url, UF[].class);
        List<UF> lista = Arrays.asList(UFs);

        estadoRepositorio.saveAll(lista);

        return ResponseEntity.ok().build();
    }
}
