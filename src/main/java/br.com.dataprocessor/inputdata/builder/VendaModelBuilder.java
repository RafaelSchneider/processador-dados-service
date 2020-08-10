package br.com.dataprocessor.inputdata.builder;

import br.com.dataprocessor.business.DataBusiness;
import br.com.dataprocessor.inputdata.model.VendaModel;
import br.com.dataprocessor.inputdata.util.ProcessorUtils;

import java.util.List;

public class VendaModelBuilder {

    public static VendaModel vendaBuilder(String data){
        List<String> resultList = ProcessorUtils.slitLine(data, 'ç');

        return VendaModel.builder()
                .idVenda(Long.parseLong(resultList.get(1)))
                .itens(ItemModelBuilder.buildListItens(resultList.get(2)))
                .vendedorNome(resultList.get(3))
                .valorTotal(DataBusiness.buscarTotalVenda(ItemModelBuilder.buildListItens(resultList.get(2))))
                .build();
    }
}
