package br.com.dataprocessor.inputdata.builder;

import br.com.dataprocessor.inputdata.model.VendedorModel;
import br.com.dataprocessor.inputdata.util.ProcessorUtils;

import java.math.BigDecimal;
import java.util.List;

public class VendedorModelBuilder {

    public static VendedorModel vendedorModelBuider(String data){
        List<String> resultList = ProcessorUtils.slitLine(data, 'ç');

        return VendedorModel.builder()
                .cpf(resultList.get(1))
                .nome(resultList.get(2))
                .salario(new BigDecimal(resultList.get(3)))
                .build();
    }
}
