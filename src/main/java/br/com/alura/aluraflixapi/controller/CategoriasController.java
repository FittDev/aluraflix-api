package br.com.alura.aluraflixapi.controller;

import br.com.alura.aluraflixapi.dto.*;
import br.com.alura.aluraflixapi.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService service;

    @GetMapping
    public List<DetalhesDaCategoriaDto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public DetalhesDaCategoriaDto detalhar(@PathVariable Long id) {
        return service.detalhar(id);
    }

    @PostMapping
    public ResponseEntity<DetalhesDaCategoriaDto> salvar(@RequestBody @Valid CadastroCategoriaFormDto formDto, UriComponentsBuilder uriBuilder) {
        DetalhesDaCategoriaDto dto = service.salvar(formDto);
        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping
    public DetalhesDaCategoriaDto atualizar(@RequestBody @Valid AtualizacaoCategoriaFormDto formDto) {
        return service.atualizar(formDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

}
