package br.com.dataprocessor.service;

import br.com.dataprocessor.business.DataBusiness;
import br.com.dataprocessor.inputdata.model.Customer;
import br.com.dataprocessor.inputdata.model.InputDataModel;
import br.com.dataprocessor.inputdata.model.Sale;
import br.com.dataprocessor.inputdata.model.Salesman;
import br.com.dataprocessor.outputdata.File;
import br.com.dataprocessor.outputdata.builder.DataOutputBuilder;
import br.com.dataprocessor.outputdata.model.OutputDataModel;

import java.io.IOException;
import java.util.List;
import java.util.function.UnaryOperator;

public class DataOutputService {

    public OutputDataModel processOutput(OutputDataModel outputDataModel, InputDataModel inputDataModel){

            return getTotalClients(inputDataModel.getCustomers())
                    .andThen(getTotalSalesman(inputDataModel.getSalesmen()))
                    .andThen(getBiggestSale(inputDataModel.getSales()))
                    .andThen(getWorstSalesman(inputDataModel.getSales()))
                    .apply(outputDataModel);
    }

    private UnaryOperator<OutputDataModel> getTotalClients(List<Customer> customers){
        return (OutputDataModel outputDataModel) ->{
            outputDataModel.setCustomerQuantity(customers.size());
            return outputDataModel;
        };
    }

    private UnaryOperator<OutputDataModel> getTotalSalesman(List<Salesman> salesmen){
        return (OutputDataModel outputDataModel) -> {
            outputDataModel.setSalesmanQuantity(salesmen.size());
            return outputDataModel;
        };
    }

    private UnaryOperator<OutputDataModel> getBiggestSale(List<Sale> sales){
        return (OutputDataModel outputDataModel) -> {
            outputDataModel.setIdBiggestSale(DataBusiness.getIdBiggestSale(sales));
            return outputDataModel;
        };
    }

    private UnaryOperator<OutputDataModel> getWorstSalesman(List<Sale> sales){
        return (OutputDataModel outputDataModel) -> {
            outputDataModel.setNameWorstSalesman(DataBusiness.getNameOfWorstSalesman(sales));
            return outputDataModel;
        };
    }

    public OutputDataModel save(OutputDataModel outputDataModel){
        try {
            File.save(DataOutputBuilder.buildStringToSave(outputDataModel));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputDataModel;
    }
}
