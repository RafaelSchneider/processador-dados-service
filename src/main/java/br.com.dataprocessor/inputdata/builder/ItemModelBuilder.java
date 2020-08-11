package br.com.dataprocessor.inputdata.builder;

import br.com.dataprocessor.inputdata.model.ItemModel;
import br.com.dataprocessor.inputdata.util.ProcessorUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ItemModelBuilder {

    public static List<ItemModel> buildListItens(String data){
        data = ProcessorUtils.removeSquareBrackets(data);
        List<String> resultList = ProcessorUtils.splitLine(data, ',');

        return resultList.stream()
                    .map(ItemModelBuilder::buildItemModel)
                    .collect(Collectors.toList());
    }

    private static ItemModel buildItemModel(String data){
        List<String> resultList = ProcessorUtils.splitLine(data, '-');

        return ItemModel.builder()
                .idItem(Long.parseLong(resultList.get(0)))
                .quantity(Integer.parseInt(resultList.get(1)))
                .price(new BigDecimal(resultList.get(2)))
                .build();
    }


}
