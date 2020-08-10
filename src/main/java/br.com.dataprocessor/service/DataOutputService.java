package br.com.dataprocessor.service;

import br.com.dataprocessor.business.DataBusiness;
import br.com.dataprocessor.inputdata.model.ClienteModel;
import br.com.dataprocessor.inputdata.model.InputDataModel;
import br.com.dataprocessor.inputdata.model.VendaModel;
import br.com.dataprocessor.inputdata.model.VendedorModel;
import br.com.dataprocessor.outputdata.SaveFile;
import br.com.dataprocessor.outputdata.builder.DataOutputBuilder;
import br.com.dataprocessor.outputdata.model.OutputDataModel;

import java.io.IOException;
import java.util.List;
import java.util.function.UnaryOperator;

public class DataOutputService {

    public OutputDataModel processaSaida(OutputDataModel outputDataModel, InputDataModel inputDataModel){

            return buscarTotalClientes(inputDataModel.getClientes())
                    .andThen(buscarTotalVendedores(inputDataModel.getVendedores()))
                    .andThen(buscarMaiorVenda(inputDataModel.getVendas()))
                    .andThen(buscarPiorVendedor(inputDataModel.getVendas()))
                    .apply(outputDataModel);
    }

    private UnaryOperator<OutputDataModel> buscarTotalClientes(List<ClienteModel> clientes){
        return (OutputDataModel outputDataModel) ->{
            outputDataModel.setQuantidadeCliente(clientes.size());
            return outputDataModel;
        };
    }

    private UnaryOperator<OutputDataModel> buscarTotalVendedores(List<VendedorModel> vendedores){
        return (OutputDataModel outputDataModel) -> {
            outputDataModel.setQuantidadeVendedores(vendedores.size());
            return outputDataModel;
        };
    }

    private UnaryOperator<OutputDataModel> buscarMaiorVenda(List<VendaModel> vendas){
        return (OutputDataModel outputDataModel) -> {
            outputDataModel.setIdVendaMaisCara(DataBusiness.buscarIdMaiorVenda(vendas));
            return outputDataModel;
        };
    }

    private UnaryOperator<OutputDataModel> buscarPiorVendedor(List<VendaModel> vendas){
        return (OutputDataModel outputDataModel) -> {
            outputDataModel.setNomePiorVendedor(DataBusiness.buscarNomePiorVendedor(vendas));
            return outputDataModel;
        };
    }

    public OutputDataModel save(OutputDataModel outputDataModel){
        try {
            SaveFile.saveFile(DataOutputBuilder.buildStringToSave(outputDataModel));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputDataModel;
    }
}
