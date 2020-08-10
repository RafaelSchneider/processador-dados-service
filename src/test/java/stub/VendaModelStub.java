package stub;

import br.com.dataprocessor.inputdata.model.VendaModel;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class VendaModelStub {

    public static List<VendaModel> buildListVendaModelStub(){
        return Arrays.asList(buildVendaStub(), buildVendaDoisStub(), buildVendaTresStub());
    }
    public static VendaModel buildVendaStub(){
        return VendaModel.builder()
                .idVenda(1L)
                .valorTotal(new BigDecimal(34.00))
                .itens(ItemModelStub.buildItemModelList())
                .vendedorNome("Inerina")
                .build();
    }

    public static VendaModel buildVendaDoisStub(){
        return VendaModel.builder()
                .idVenda(2L)
                .valorTotal(new BigDecimal(32.00))
                .itens(Arrays.asList(ItemModelStub.buildItemNumeroDois(), ItemModelStub.buildItemNumeroUm()))
                .vendedorNome("Jadilson")
                .build();
    }

    public static VendaModel buildVendaTresStub(){
        return VendaModel.builder()
                .idVenda(3L)
                .valorTotal(new BigDecimal(12.00))
                .itens(Arrays.asList(ItemModelStub.buildItemNumeroDois()))
                .vendedorNome("Jonelson")
                .build();
    }
}
