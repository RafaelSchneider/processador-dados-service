package stub;

import br.com.dataprocessor.inputdata.model.Sale;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class SaleStub {

    public static List<Sale> buildListSaleStub(){
        return Arrays.asList(buildSaleStub(), buildSaleTwoStub(), buildSaleThreeStub());
    }
    public static Sale buildSaleStub(){
        return Sale.builder()
                .idSale(1L)
                .total(new BigDecimal(34.00))
                .items(ItemModelStub.buildItemList())
                .salesmanName("Inerina")
                .build();
    }

    public static Sale buildSaleTwoStub(){
        return Sale.builder()
                .idSale(2L)
                .total(new BigDecimal(32.00))
                .items(Arrays.asList(ItemModelStub.buildItemNumberTwo(), ItemModelStub.buildItemNumberOne()))
                .salesmanName("Jadilson")
                .build();
    }

    public static Sale buildSaleThreeStub(){
        return Sale.builder()
                .idSale(3L)
                .total(new BigDecimal(12.00))
                .items(Arrays.asList(ItemModelStub.buildItemNumberTwo()))
                .salesmanName("Jonelson")
                .build();
    }
}
