package br.com.dataprocessor.inputdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class InputDataModel {
    private List<ClienteModel> clientes;
    private List<VendaModel> vendas;
    private List<VendedorModel> vendedores;

    public InputDataModel(){
        clientes = new ArrayList<>();
        vendas = new ArrayList<>();
        vendedores = new ArrayList<>();
    }
}
