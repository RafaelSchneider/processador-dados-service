package br.com.dataprocessor.service;

import br.com.dataprocessor.business.DataBusiness;
import br.com.dataprocessor.inputdata.builder.VendaModelBuilder;
import br.com.dataprocessor.inputdata.model.InputData;
import br.com.dataprocessor.inputdata.model.Sale;
import br.com.dataprocessor.outputdata.model.OutputData;
import br.com.dataprocessor.type.IdentifierEnum;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class SalesService {

    public Function<InputData, InputData> extractSales(String data){
        return (InputData inputData)-> {
            if (data.startsWith(IdentifierEnum.SALE.identifier)) {
                inputData
                        .getSales()
                        .add(VendaModelBuilder.vendaBuilder(data));
            }
            return inputData;
        };
    }

    public UnaryOperator<OutputData> getBiggestSale(List<Sale> sales){
        return (OutputData outputData) -> {
            outputData.setIdBiggestSale(DataBusiness.getIdBiggestSale(sales));
            return outputData;
        };
    }
}
