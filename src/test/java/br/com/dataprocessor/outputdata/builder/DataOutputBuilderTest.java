package br.com.dataprocessor.outputdata.builder;

import org.junit.Assert;
import org.junit.Test;
import stub.OutputModelStub;

public class DataOutputBuilderTest {

    @Test
    public void deveMontarStringParaGravarEmArquivo(){

        String out = "3ç3ç2çJonelson";

        Assert.assertTrue(DataOutputBuilder.buildStringToSave(OutputModelStub.buildOutputModel()).equals(out));

    }
}