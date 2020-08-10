package br.com.dataprocessor.service;

import br.com.dataprocessor.inputdata.builder.ClienteModelBuilder;
import br.com.dataprocessor.inputdata.builder.VendaModelBuilder;
import br.com.dataprocessor.inputdata.builder.VendedorModelBuilder;
import br.com.dataprocessor.inputdata.extractor.DataExtractor;
import br.com.dataprocessor.inputdata.model.InputDataModel;

import java.util.function.Function;

public class DataInputService {

    /**
     * TODO
     * PASSAR PARA ENUM
     *
     * */
    private static final String IDENTIFICADOR_VENDEDOR = "001";
    private static final String IDENTIFICADOR_CLIENTE = "002";
    private static final String IDENTIFICADOR_VENDA = "003";

    public InputDataModel extractor(InputDataModel inputDataModel){
        for (String arquivo : DataExtractor.listAllFiles()){
            DataExtractor.extractDataFromArchive(arquivo)
                    .forEach(singleFile-> extrairDadosPorIdentificador(singleFile, inputDataModel));
        }
        return inputDataModel;
    }

    private void extrairDadosPorIdentificador(String data, InputDataModel inputDataModel){
                extrairVendedor(data)
                        .andThen(extrairCliente(data))
                        .andThen(extrairVenda(data))
                        .apply(inputDataModel);
    }

    private Function<InputDataModel, InputDataModel> extrairVendedor(String data){
        return (InputDataModel inputDataModel) -> {
            if (data.startsWith(IDENTIFICADOR_VENDEDOR)){
                inputDataModel
                        .getVendedores()
                        .add(VendedorModelBuilder.vendedorModelBuider(data));
            }
            return inputDataModel;
        };
    }

    private Function<InputDataModel, InputDataModel> extrairCliente(String data){
        return (InputDataModel inputDataModel) -> {
            if (data.startsWith(IDENTIFICADOR_CLIENTE)){
                inputDataModel
                        .getClientes()
                        .add(ClienteModelBuilder.clienteBuilder(data));
            }
            return inputDataModel;
        };
    }

    private Function< InputDataModel, InputDataModel> extrairVenda(String data){
        return (InputDataModel inputDataModel)-> {
            if (data.startsWith(IDENTIFICADOR_VENDA)) {
                  inputDataModel
                         .getVendas()
                         .add(VendaModelBuilder.vendaBuilder(data));
            }
            return inputDataModel;
        };
    }
}
