package br.com.dataprocessor.inputdata.builder;

import br.com.dataprocessor.inputdata.model.ClienteModel;
import br.com.dataprocessor.inputdata.util.ProcessorUtils;

import java.util.List;

public class ClienteModelBuilder {

    public static ClienteModel clienteBuilder(String data){
        List<String> resultList = ProcessorUtils.slitLine(data, 'ç');
        return ClienteModel.builder()
                .cnpj(resultList.get(1))
                .nome(resultList.get(2))
                .areaAtuacao(resultList.get(3))
                .build();
    }
}
