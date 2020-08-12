package br.com.dataprocessor.service;

import br.com.dataprocessor.business.DataBusiness;
import br.com.dataprocessor.inputdata.builder.VendedorModelBuilder;
import br.com.dataprocessor.inputdata.model.InputData;
import br.com.dataprocessor.inputdata.model.Sale;
import br.com.dataprocessor.outputdata.model.OutputData;
import br.com.dataprocessor.type.IdentifierEnum;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class SalesmanService {

    public Function<InputData, InputData> extractSalesman(String data){
        return (InputData inputData) -> {
            if (data.startsWith(IdentifierEnum.SALESMAN.identifier)){
                inputData
                        .getSalesmen()
                        .add(VendedorModelBuilder.vendedorModelBuider(data));
            }
            return inputData;
        };
    }

    public UnaryOperator<OutputData> getWorstSalesman(List<Sale> sales){
        return (OutputData outputData) -> {
            outputData.setNameWorstSalesman(DataBusiness.getNameOfWorstSalesman(sales));
            return outputData;
        };
    }
}
