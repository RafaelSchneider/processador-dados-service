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
public class VendedorModel {
    private String cpf;
    private String nome;
    private BigDecimal salario;
}
