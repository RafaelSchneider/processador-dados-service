package br.com.dataprocessor.service;

import br.com.dataprocessor.inputdata.builder.CustomerBuilder;
import br.com.dataprocessor.inputdata.builder.VendaModelBuilder;
import br.com.dataprocessor.inputdata.builder.VendedorModelBuilder;
import br.com.dataprocessor.inputdata.extractor.DataExtractor;
import br.com.dataprocessor.inputdata.model.InputData;
import br.com.dataprocessor.type.IdentifierEnum;

import java.util.function.Function;

public class DataInputService {

    public InputData extractor(InputData inputData){
        for (String file : DataExtractor.listAllFiles()){
            DataExtractor.extractDataFromArchive(file)
                    .forEach(singleFile-> extractDataByIdentifier(singleFile, inputData));
        }
        return inputData;
    }

    private void extractDataByIdentifier(String data, InputData inputData){
                extractSalesman(data)
                        .andThen(extractCustomer(data))
                        .andThen(extractSales(data))
                        .apply(inputData);
    }

    private Function<InputData, InputData> extractSalesman(String data){
        return (InputData inputData) -> {
            if (data.startsWith(IdentifierEnum.SALESMAN.identifier)){
                inputData
                        .getSalesmen()
                        .add(VendedorModelBuilder.vendedorModelBuider(data));
            }
            return inputData;
        };
    }

    private Function<InputData, InputData> extractCustomer(String data){
        return (InputData inputData) -> {
            if (data.startsWith(IdentifierEnum.CUSTOMER.identifier)){
                inputData
                        .getCustomers()
                        .add(CustomerBuilder.build(data));
            }
            return inputData;
        };
    }

    private Function<InputData, InputData> extractSales(String data){
        return (InputData inputData)-> {
            if (data.startsWith(IdentifierEnum.SALE.identifier)) {
                  inputData
                         .getSales()
                         .add(VendaModelBuilder.vendaBuilder(data));
            }
            return inputData;
        };
    }
}
