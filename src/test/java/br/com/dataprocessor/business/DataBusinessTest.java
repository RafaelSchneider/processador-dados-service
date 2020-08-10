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
                .buscarIdMaiorVenda(VendaModelStub.buildListVendaModelStub()).equals(1L));
    }

    @Test
    public void deveBuscarValorTotalDaVenda(){
       Assert.assertTrue(DataBusiness
               .buscarTotalVenda(ItemModelStub.buildItemModelList())
               .equals(new BigDecimal(34)));
    }

    @Test
    public void deveBuscarNomePiorVendedor(){
        Assert.assertTrue(DataBusiness
                .buscarNomePiorVendedor(VendaModelStub.buildListVendaModelStub()).equals("Jonelson"));
    }
}