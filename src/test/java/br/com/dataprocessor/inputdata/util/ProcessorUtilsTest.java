package br.com.dataprocessor.inputdata.util;

import br.com.dataprocessor.type.IdentifierEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class ProcessorUtilsTest {

    @Test
    public void shouldValidadeCedillaCharacterInPersonalNamesInSalesmanLine(){
        String line = "001ç1234567891444çJonelson II Caçamba de Moçambiqueç50000";
        List<String> strings = ProcessorUtils.splitLine(line, 'ç');
        Assert.assertTrue(strings.get(0).equals(IdentifierEnum.SALESMAN.identifier));
        Assert.assertTrue(strings.get(1).equals("1234567891444"));
        Assert.assertTrue(strings.get(2).equals("Jonelson II Caçamba de Moçambique"));
        Assert.assertTrue(strings.get(3).equals("50000"));
    }

    @Test
    public void shouldValidadeCedillaCharacterInPersonalNamesInCustomerLine(){
        String line = "002ç2345675434544999çJonelson II Caçamba de MoçambiqueçRural";
        List<String> strings = ProcessorUtils.splitLine(line, 'ç');
        Assert.assertTrue(strings.get(0).equals(IdentifierEnum.CUSTOMER.identifier));
        Assert.assertTrue(strings.get(1).equals("2345675434544999"));
        Assert.assertTrue(strings.get(2).equals("Jonelson II Caçamba de Moçambique"));
        Assert.assertTrue(strings.get(3).equals("Rural"));
    }

    @Test
    public void shouldValidadeCedillaCharacterInPersonalNamesInSaleLine(){
        String line = "003ç05ç[1-34-10,2-33-1.50,3-40-0.10]çJonelson II Caçamba de Moçambique";
        List<String> strings = ProcessorUtils.splitLine(line, 'ç');
        Assert.assertTrue(strings.get(0).equals(IdentifierEnum.SALE.identifier));
        Assert.assertTrue(strings.get(1).equals("05"));
        Assert.assertTrue(strings.get(2).equals("[1-34-10,2-33-1.50,3-40-0.10]"));
        Assert.assertTrue(strings.get(3).equals("Jonelson II Caçamba de Moçambique"));
    }

}