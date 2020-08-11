package stub;

import br.com.dataprocessor.inputdata.model.Sale;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class VendaModelStub {

    public static List<Sale> buildListVendaModelStub(){
        return Arrays.asList(buildVendaStub(), buildVendaDoisStub(), buildVendaTresStub());
    }
    public static Sale buildVendaStub(){
        return Sale.builder()
                .idSale(1L)
                .total(new BigDecimal(34.00))
                .items(ItemModelStub.buildItemModelList())
                .salesmanName("Inerina")
                .build();
    }

    public static Sale buildVendaDoisStub(){
        return Sale.builder()
                .idSale(2L)
                .total(new BigDecimal(32.00))
                .items(Arrays.asList(ItemModelStub.buildItemNumeroDois(), ItemModelStub.buildItemNumeroUm()))
                .salesmanName("Jadilson")
                .build();
    }

    public static Sale buildVendaTresStub(){
        return Sale.builder()
                .idSale(3L)
                .total(new BigDecimal(12.00))
                .items(Arrays.asList(ItemModelStub.buildItemNumeroDois()))
                .salesmanName("Jonelson")
                .build();
    }
}
