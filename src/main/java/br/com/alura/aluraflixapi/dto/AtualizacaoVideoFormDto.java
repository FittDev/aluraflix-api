package br.com.alura.aluraflixapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AtualizacaoVideoFormDto extends CadastroVideoFormDto {

    @NotNull
    private Long id;

}
