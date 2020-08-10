package stub;

import br.com.dataprocessor.outputdata.model.OutputDataModel;

public class OutputModelStub {

    public static OutputDataModel buildOutputModel(){
        return OutputDataModel.builder()
                .idVendaMaisCara(2L)
                .nomePiorVendedor("Jonelson")
                .quantidadeCliente(3)
                .quantidadeVendedores(3)
                .build();
    }
}
