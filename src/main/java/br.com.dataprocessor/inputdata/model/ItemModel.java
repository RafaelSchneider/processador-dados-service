package br.com.dataprocessor.inputdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {
    private Long idItem;
    private Integer quantidade;
    private BigDecimal valor;


}
