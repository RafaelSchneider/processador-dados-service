package br.com.dataprocessor.inputdata.builder;

import br.com.dataprocessor.business.DataBusiness;
import br.com.dataprocessor.inputdata.model.Sale;
import br.com.dataprocessor.inputdata.util.ProcessorUtils;

import java.util.List;

public class VendaModelBuilder {

    public static Sale vendaBuilder(String data){
        List<String> resultList = ProcessorUtils.splitLine(data, 'ç');

        return Sale.builder()
                .idSale(Long.parseLong(resultList.get(1)))
                .items(ItemBuilder.buildListItems(resultList.get(2)))
                .salesmanName(resultList.get(3))
                .total(DataBusiness.getTotalSale(ItemBuilder.buildListItems(resultList.get(2))))
                .build();
    }
}
