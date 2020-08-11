package br.com.dataprocessor.service;

import br.com.dataprocessor.inputdata.builder.ClienteModelBuilder;
import br.com.dataprocessor.inputdata.builder.VendaModelBuilder;
import br.com.dataprocessor.inputdata.builder.VendedorModelBuilder;
import br.com.dataprocessor.inputdata.extractor.DataExtractor;
import br.com.dataprocessor.inputdata.model.InputDataModel;
import br.com.dataprocessor.type.IdentifierEnum;

import java.util.function.Function;

public class DataInputService {

    public InputDataModel extractor(InputDataModel inputDataModel){
        for (String file : DataExtractor.listAllFiles()){
            DataExtractor.extractDataFromArchive(file)
                    .forEach(singleFile-> extractDataByIdentifier(singleFile, inputDataModel));
        }
        return inputDataModel;
    }

    private void extractDataByIdentifier(String data, InputDataModel inputDataModel){
                extractSalesman(data)
                        .andThen(extractCustomer(data))
                        .andThen(extractSales(data))
                        .apply(inputDataModel);
    }

    private Function<InputDataModel, InputDataModel> extractSalesman(String data){
        return (InputDataModel inputDataModel) -> {
            if (data.startsWith(IdentifierEnum.SALESMAN.identifier)){
                inputDataModel
                        .getSalesmen()
                        .add(VendedorModelBuilder.vendedorModelBuider(data));
            }
            return inputDataModel;
        };
    }

    private Function<InputDataModel, InputDataModel> extractCustomer(String data){
        return (InputDataModel inputDataModel) -> {
            if (data.startsWith(IdentifierEnum.CUSTOMER.identifier)){
                inputDataModel
                        .getCustomers()
                        .add(ClienteModelBuilder.clienteBuilder(data));
            }
            return inputDataModel;
        };
    }

    private Function< InputDataModel, InputDataModel> extractSales(String data){
        return (InputDataModel inputDataModel)-> {
            if (data.startsWith(IdentifierEnum.SALE.identifier)) {
                  inputDataModel
                         .getSales()
                         .add(VendaModelBuilder.vendaBuilder(data));
            }
            return inputDataModel;
        };
    }
}
