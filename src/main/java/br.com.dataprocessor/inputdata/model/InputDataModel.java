package br.com.dataprocessor.inputdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class InputDataModel {
    private List<Customer> customers;
    private List<Sale> sales;
    private List<Salesman> salesmen;

    public InputDataModel(){
        customers = new ArrayList<>();
        sales = new ArrayList<>();
        salesmen = new ArrayList<>();
    }
}