package stub;

import br.com.dataprocessor.inputdata.model.Item;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ItemModelStub {

    public static List<Item> buildItemList(){
        return Arrays.asList(buildItemNumberOne(), buildItemNumberTwo(), buildItemNumberThree());
    }

    public static Item buildItemNumberOne(){
        return Item.builder()
                .price(new BigDecimal(10))
                .quantity(2)
                .idItem(1L)
                .build();
    }

    public static Item buildItemNumberTwo(){
        return Item.builder()
                .idItem(2L)
                .quantity(1)
                .price(new BigDecimal(12))
                .build();
    }

    private static Item buildItemNumberThree(){
        return Item.builder()
                .idItem(3L)
                .quantity(1)
                .price(new BigDecimal(2))
                .build();
    }
}
