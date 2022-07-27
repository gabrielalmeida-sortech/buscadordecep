package br.com.sortech.buscadordecep.web.rest;


import br.com.sortech.buscadordecep.dominio.Municipio;
import br.com.sortech.buscadordecep.dominio.Subdistrito;
import br.com.sortech.buscadordecep.repositorio.MunicipioRepositorio;
import br.com.sortech.buscadordecep.repositorio.SubdistritosRepositorio;
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
@RequestMapping(value = "api/subdistrito")
public class SubdistritosRest {

    private final SubdistritosRepositorio subdistritosRepositorio;
    private  final MunicipioRepositorio municipioRepositorio;

    @GetMapping("/popular")
    public ResponseEntity<Subdistrito> popularTabelas() {
        List<Subdistrito> lista =  new ArrayList<>();

        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/subdistritos";
        RestTemplate restTemplate = new RestTemplate();

        Subdistrito[] subdistritos = restTemplate.getForObject(url, Subdistrito[].class);
        lista.addAll(Arrays.asList(subdistritos));


        subdistritosRepositorio.saveAll(lista);




        return ResponseEntity.ok().build();
    }
}
