package br.com.alura.aluraflixapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CadastroCategoriaFormDto {

    @NotBlank
    private String titulo;
    @NotBlank
    private String cor;

}
