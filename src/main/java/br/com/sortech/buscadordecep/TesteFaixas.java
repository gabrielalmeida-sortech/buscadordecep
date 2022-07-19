package br.com.sortech.buscadordecep;

import br.com.sortech.buscadordecep.dominio.Faixa;
import br.com.sortech.buscadordecep.dominio.Regiao;
import br.com.sortech.buscadordecep.dominio.Uf;
import br.com.sortech.buscadordecep.servico.FaixaService;

import java.util.List;

public class TesteFaixas {

    public static void main(String[] args) {
        Uf uf = new Uf(0L, "DF");
        Regiao regiao = new Regiao(0L, "Cidades Satélite", uf);
        Faixa faixa = new Faixa(0L, regiao, 71000000L, 73699999L);

        System.out.println(faixa);
        List<Long> listaDeFaixas = new FaixaService().CalcularFaixasDeCep(faixa.getFaixaInicial(), faixa.getFaixaFinal());
        System.out.println(listaDeFaixas.get(0));
    }

}
