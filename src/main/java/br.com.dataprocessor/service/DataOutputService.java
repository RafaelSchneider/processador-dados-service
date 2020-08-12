package br.com.dataprocessor.service;

import br.com.dataprocessor.business.DataBusiness;
import br.com.dataprocessor.inputdata.model.Customer;
import br.com.dataprocessor.inputdata.model.InputData;
import br.com.dataprocessor.inputdata.model.Sale;
import br.com.dataprocessor.inputdata.model.Salesman;
import br.com.dataprocessor.outputdata.File;
import br.com.dataprocessor.outputdata.builder.DataOutputBuilder;
import br.com.dataprocessor.outputdata.model.OutputData;

import java.io.IOException;
import java.util.List;
import java.util.function.UnaryOperator;

public class DataOutputService {

    public OutputData processOutput(OutputData outputData, InputData inputData){

            return getTotalClients(inputData.getCustomers())
                    .andThen(getTotalSalesman(inputData.getSalesmen()))
                    .andThen(getBiggestSale(inputData.getSales()))
                    .andThen(getWorstSalesman(inputData.getSales()))
                    .apply(outputData);
    }

    private UnaryOperator<OutputData> getTotalClients(List<Customer> customers){
        return (OutputData outputData) ->{
            outputData.setCustomerQuantity(customers.size());
            return outputData;
        };
    }

    private UnaryOperator<OutputData> getTotalSalesman(List<Salesman> salesmen){
        return (OutputData outputData) -> {
            outputData.setSalesmanQuantity(salesmen.size());
            return outputData;
        };
    }

    private UnaryOperator<OutputData> getBiggestSale(List<Sale> sales){
        return (OutputData outputData) -> {
            outputData.setIdBiggestSale(DataBusiness.getIdBiggestSale(sales));
            return outputData;
        };
    }

    private UnaryOperator<OutputData> getWorstSalesman(List<Sale> sales){
        return (OutputData outputData) -> {
            outputData.setNameWorstSalesman(DataBusiness.getNameOfWorstSalesman(sales));
            return outputData;
        };
    }

    public OutputData save(OutputData outputData){
        try {
            File.save(DataOutputBuilder.buildStringToSave(outputData));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputData;
    }
}
