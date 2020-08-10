package br.com.dataprocessor.inputdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {
    private String cnpj;
    private String nome;
    private String areaAtuacao;
}
