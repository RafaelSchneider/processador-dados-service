package br.com.dataprocessor.business;

import br.com.dataprocessor.inputdata.model.ItemModel;
import br.com.dataprocessor.inputdata.model.VendaModel;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class DataBusiness {

    public static Long buscarIdMaiorVenda(List<VendaModel> vendas){
       return vendas.stream()
               .max(Comparator.comparing(VendaModel::getValorTotal))
               .map(VendaModel::getIdVenda)
               .get();

    }

    public static BigDecimal buscarTotalVenda(List<ItemModel> itens){
        return itens.stream()
                .map(item -> item.getValor().multiply(new BigDecimal(item.getQuantidade())))
                .reduce(BigDecimal::add)
                .get();
    }

    public static String buscarNomePiorVendedor(List<VendaModel> vendas){
        return vendas.stream()
                .min(Comparator.comparing(VendaModel::getValorTotal))
                .map(VendaModel::getVendedorNome)
                .get();

    }
}
