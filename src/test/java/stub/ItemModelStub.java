package stub;

import br.com.dataprocessor.inputdata.model.ItemModel;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ItemModelStub {

    public static List<ItemModel> buildItemList(){
        return Arrays.asList(buildItemNumberOne(), buildItemNumberTwo(), buildItemNumberThree());
    }

    public static ItemModel buildItemNumberOne(){
        return ItemModel.builder()
                .price(new BigDecimal(10))
                .quantity(2)
                .idItem(1L)
                .build();
    }

    public static ItemModel buildItemNumberTwo(){
        return ItemModel.builder()
                .idItem(2L)
                .quantity(1)
                .price(new BigDecimal(12))
                .build();
    }

    private static ItemModel buildItemNumberThree(){
        return ItemModel.builder()
                .idItem(3L)
                .quantity(1)
                .price(new BigDecimal(2))
                .build();
    }
}
