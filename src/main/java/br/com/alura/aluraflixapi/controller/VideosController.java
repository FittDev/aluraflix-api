package br.com.alura.aluraflixapi.controller;

import br.com.alura.aluraflixapi.dto.AtualizacaoVideoFormDto;
import br.com.alura.aluraflixapi.dto.CadastroVideoFormDto;
import br.com.alura.aluraflixapi.dto.DetalhesDoVideoDto;
import br.com.alura.aluraflixapi.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideosController {

    @Autowired
    private VideosService service;

    @GetMapping
    public List<DetalhesDoVideoDto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public DetalhesDoVideoDto detalhar(@PathVariable Long id) {
        return service.detalhar(id);
    }

    @PostMapping
    public ResponseEntity<DetalhesDoVideoDto> salvar(@RequestBody @Valid CadastroVideoFormDto formDto, UriComponentsBuilder uriBuilder) {
        DetalhesDoVideoDto dto = service.salvar(formDto);
        URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping
    public DetalhesDoVideoDto atualizar(@RequestBody @Valid AtualizacaoVideoFormDto formDto) {
        return service.atualizar(formDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

}
