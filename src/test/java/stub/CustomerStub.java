package stub;

import br.com.dataprocessor.inputdata.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerStub {

    public static Customer buildCustomer1(){
        return Customer.builder()
                .name("Cliente 999")
                .businessArea("Rural")
                .cnpj("2345675434544999")
                .build();

    }

    public static Customer buildCustomer2(){
        return Customer.builder()
                .name("Cliente 888")
                .businessArea("Rural")
                .cnpj("2345675433444888")
                .build();

    }

    public static List<Customer> buildList(){
        List<Customer> customers = new ArrayList<>();
        customers.add(buildCustomer1());
        customers.add(buildCustomer2());
        return customers;
    }
}

//001ç1234567891444çJonelson IIç50000
//        001ç3245678865555çLaudelinoç40000.98
//        002ç2345675434544999çCliente 999çRural
//        002ç2345675433444888çCliente 888çRural
//        003ç04ç[1-10-100,2-30-2.50,3-40-3.10]çLaudelino
//        003ç05ç[1-34-10,2-33-1.50,3-40-0.10]çJonelson II