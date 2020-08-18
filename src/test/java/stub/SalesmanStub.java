package stub;

import br.com.dataprocessor.inputdata.model.Salesman;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalesmanStub {

    public static Salesman buildSalesman1(){
        return Salesman.builder()
                .cpf("1234567891444")
                .name("Jonelson II")
                .salary(new BigDecimal("50000"))
                .build();
    }

    public static Salesman buildSalesman2(){
        return Salesman.builder()
                .cpf("3245678865555")
                .name("Laudelino")
                .salary(new BigDecimal("40000.98"))
                .build();
    }

    public static List<Salesman> buildList(){
        List<Salesman> salesmen = new ArrayList<>();
        salesmen.add(buildSalesman1());
        salesmen.add(buildSalesman2());
        return salesmen;
    }
}

//001ç1234567891444çJonelson IIç50000
//        001ç3245678865555çLaudelinoç40000.98
//        002ç2345675434544999çCliente 999çRural
//        002ç2345675433444888çCliente 888çRural
//        003ç04ç[1-10-100,2-30-2.50,3-40-3.10]çLaudelino
//        003ç05ç[1-34-10,2-33-1.50,3-40-0.10]çJonelson II