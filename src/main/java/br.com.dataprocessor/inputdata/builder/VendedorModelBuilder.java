package br.com.dataprocessor.inputdata.builder;

import br.com.dataprocessor.inputdata.model.Salesman;
import br.com.dataprocessor.inputdata.util.ProcessorUtils;

import java.math.BigDecimal;
import java.util.List;

public class VendedorModelBuilder {

    public static Salesman vendedorModelBuider(String data){
        List<String> resultList = ProcessorUtils.splitLine(data, 'ç');

        return Salesman.builder()
                .cpf(resultList.get(1))
                .name(resultList.get(2))
                .salary(new BigDecimal(resultList.get(3)))
                .build();
    }
}
