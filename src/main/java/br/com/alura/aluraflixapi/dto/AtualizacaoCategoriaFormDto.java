package br.com.alura.aluraflixapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AtualizacaoCategoriaFormDto extends CadastroCategoriaFormDto {

    @NotNull
    private Long id;

}
