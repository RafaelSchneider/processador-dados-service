package br.com.dataprocessor.business;

import org.junit.Assert;
import org.junit.Test;
import stub.ItemModelStub;
import stub.SaleStub;

import java.math.BigDecimal;

public class DataBusinessTest {


    @Test
    public void shouldReturnIdBiggestSale(){
        Assert.assertTrue(DataBusiness
                .getIdBiggestSale(SaleStub.buildListSaleStub()).equals(1L));
    }

    @Test
    public void shouldReturnTotalOfSale(){
       Assert.assertTrue(DataBusiness
               .getTotalSale(ItemModelStub.buildItemList())
               .equals(new BigDecimal(34)));
    }

    @Test
    public void shouldReturnNameOfWorstSalesman(){
        Assert.assertTrue(DataBusiness
                .getNameOfWorstSalesman(SaleStub.buildListSaleStub()).equals("Jonelson"));
    }
}