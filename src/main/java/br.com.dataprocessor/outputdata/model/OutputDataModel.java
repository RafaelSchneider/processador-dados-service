package br.com.dataprocessor.outputdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutputDataModel {
    private Integer quantidadeCliente;
    private Integer quantidadeVendedores;
    private Long idVendaMaisCara;
    private String nomePiorVendedor;
}
