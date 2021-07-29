package br.com.alura.aluraflixapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalhesDoVideoDto {

    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    private Long categoriaId;

}
