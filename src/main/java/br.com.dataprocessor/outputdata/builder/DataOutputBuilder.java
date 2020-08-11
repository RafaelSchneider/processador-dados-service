package br.com.dataprocessor.outputdata.builder;

import br.com.dataprocessor.outputdata.model.OutputDataModel;

public class DataOutputBuilder {

    private static final String SEPARATOR = "ç";

    public static String buildStringToSave(OutputDataModel outputDataModel){
        StringBuilder sb = new StringBuilder();
        sb.append(outputDataModel.getCustomerQuantity().toString()).append(SEPARATOR);
        sb.append(outputDataModel.getSalesmanQuantity()).append(SEPARATOR);
        sb.append(outputDataModel.getIdBiggestSale()).append(SEPARATOR);
        sb.append(outputDataModel.getNameWorstSalesman());
        return sb.toString();
    }
}
