package br.com.dataprocessor.business;

import br.com.dataprocessor.inputdata.model.ItemModel;
import br.com.dataprocessor.inputdata.model.Sale;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class DataBusiness {

    public static Long getIdBiggestSale(List<Sale> vendas){
       return vendas.stream()
               .max(Comparator.comparing(Sale::getTotal))
               .map(Sale::getIdSale)
               .get();

    }

    public static BigDecimal getTotalSale(List<ItemModel> itens){
        return itens.stream()
                .map(item -> item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal::add)
                .get();
    }

    public static String getNameOfWorstSalesman(List<Sale> vendas){
        return vendas.stream()
                .min(Comparator.comparing(Sale::getTotal))
                .map(Sale::getSalesmanName)
                .get();

    }
}
