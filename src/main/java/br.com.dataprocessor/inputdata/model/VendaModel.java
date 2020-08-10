package br.com.dataprocessor.inputdata.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendaModel {
    private Long idVenda;
    private List<ItemModel> itens;
    private String vendedorNome;
    private BigDecimal valorTotal;

}
