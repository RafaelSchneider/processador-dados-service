package br.com.dataprocessor.outputdata.builder;

import br.com.dataprocessor.outputdata.model.OutputDataModel;

public class DataOutputBuilder {

    public static String buildStringToSave(OutputDataModel outputDataModel){
        StringBuilder sb = new StringBuilder();
        sb.append(outputDataModel.getQuantidadeCliente().toString()).append("ç");
        sb.append(outputDataModel.getQuantidadeVendedores()).append("ç");
        sb.append(outputDataModel.getIdVendaMaisCara()).append("ç");
        sb.append(outputDataModel.getNomePiorVendedor());
        return sb.toString();
    }
}
