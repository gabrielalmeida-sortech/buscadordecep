package br.com.sortech.buscadordecep.servico;
import java.util.ArrayList;
import java.util.List;

public class FaixaService {

    public List<Long> CalcularFaixasDeCep (long faixaInicial, long faixaFinal) {
        List<Long> totalDeFaixas = new ArrayList<>();

        for (long i = faixaInicial; i <= faixaFinal; i++) {
            totalDeFaixas.add(i);
        }
        return totalDeFaixas;
    }

}
