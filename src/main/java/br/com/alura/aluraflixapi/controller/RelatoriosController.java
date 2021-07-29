package br.com.alura.aluraflixapi.controller;

import br.com.alura.aluraflixapi.dto.AtualizacaoVideoFormDto;
import br.com.alura.aluraflixapi.dto.CadastroVideoFormDto;
import br.com.alura.aluraflixapi.dto.DetalhesDoVideoDto;
import br.com.alura.aluraflixapi.dto.RelatorioDeCategoriasDto;
import br.com.alura.aluraflixapi.service.RelatoriosService;
import br.com.alura.aluraflixapi.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {

    @Autowired
    private RelatoriosService service;

    @GetMapping("/categorias")
    public List<RelatorioDeCategoriasDto> relatorioDeCategorias() {
        return service.relatorioDeCategorias();
    }

}
