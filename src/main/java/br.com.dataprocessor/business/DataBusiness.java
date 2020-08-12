package br.com.dataprocessor.business;

import br.com.dataprocessor.inputdata.model.Item;
import br.com.dataprocessor.inputdata.model.Sale;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class DataBusiness {

    public static Long getIdBiggestSale(List<Sale> sales){
       return sales.stream()
               .max(Comparator.comparing(Sale::getTotal))
               .map(Sale::getIdSale)
               .get();

    }

    public static BigDecimal getTotalSale(List<Item> items){
        return items.stream()
                .map(item -> item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal::add)
                .get();
    }

    public static String getNameOfWorstSalesman(List<Sale> sales){
        return sales.stream()
                .min(Comparator.comparing(Sale::getTotal))
                .map(Sale::getSalesmanName)
                .get();

    }
}
