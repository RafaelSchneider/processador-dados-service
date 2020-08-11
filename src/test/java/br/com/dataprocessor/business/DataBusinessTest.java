package br.com.dataprocessor.business;

import org.junit.Assert;
import org.junit.Test;
import stub.ItemModelStub;
import stub.VendaModelStub;

import java.math.BigDecimal;

public class DataBusinessTest {


    @Test
    public void deveRetornarIdMaiorVenda(){
        Assert.assertTrue(DataBusiness
                .getIdBiggestSale(VendaModelStub.buildListVendaModelStub()).equals(1L));
    }

    @Test
    public void deveBuscarValorTotalDaVenda(){
       Assert.assertTrue(DataBusiness
               .getTotalSale(ItemModelStub.buildItemModelList())
               .equals(new BigDecimal(34)));
    }

    @Test
    public void deveBuscarNomePiorVendedor(){
        Assert.assertTrue(DataBusiness
                .getNameOfWorstSalesman(VendaModelStub.buildListVendaModelStub()).equals("Jonelson"));
    }
}