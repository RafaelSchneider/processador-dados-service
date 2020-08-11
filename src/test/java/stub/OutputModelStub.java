package stub;

import br.com.dataprocessor.outputdata.model.OutputDataModel;

public class OutputModelStub {

    public static OutputDataModel buildOutputModel(){
        return OutputDataModel.builder()
                .idBiggestSale(2L)
                .nameWorstSalesman("Jonelson")
                .customerQuantity(3)
                .salesmanQuantity(3)
                .build();
    }
}
