package br.com.dataprocessor.service;

import br.com.dataprocessor.inputdata.extractor.DataExtractor;
import br.com.dataprocessor.inputdata.model.InputData;

public class DataInputService {

    private SalesmanService salesmanService;
    private CustomerService customerService;
    private SalesService salesService;

    public DataInputService() {
        this.salesmanService = new SalesmanService();
        this.customerService = new CustomerService();
        this.salesService = new SalesService();

    }

    public InputData extractor(InputData inputData){
        for (String file : DataExtractor.listAllFiles()){
            DataExtractor.extractDataFromFile(file)
                    .forEach(singleFile-> extractDataByIdentifier(singleFile, inputData));
        }
        return inputData;
    }

    private void extractDataByIdentifier(String data, InputData inputData){
        salesmanService.extractSalesman(data)
                        .andThen(customerService.extractCustomer(data))
                        .andThen(salesService.extractSales(data))
                        .apply(inputData);
    }

    public void clearList(InputData inputData){
        inputData.getCustomers().clear();
        inputData.getSales().clear();
        inputData.getSalesmen().clear();
    }
}
