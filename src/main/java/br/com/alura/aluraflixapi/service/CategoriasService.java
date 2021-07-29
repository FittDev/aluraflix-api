package br.com.alura.aluraflixapi.service;

import br.com.alura.aluraflixapi.dto.*;
import br.com.alura.aluraflixapi.model.Categoria;
import br.com.alura.aluraflixapi.model.Video;
import br.com.alura.aluraflixapi.repository.CategoriasRepository;
import br.com.alura.aluraflixapi.repository.VideosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public DetalhesDaCategoriaDto salvar(CadastroCategoriaFormDto dto) {
        Categoria nova = modelMapper.map(dto, Categoria.class);
        repository.save(nova);
        return modelMapper.map(nova, DetalhesDaCategoriaDto.class);
    }

    @Transactional
    public DetalhesDaCategoriaDto atualizar(AtualizacaoCategoriaFormDto dto) {
        Categoria atual = repository.getById(dto.getId());
        atual.atualizarInformacoes(dto.getTitulo(), dto.getCor());
        return modelMapper.map(atual, DetalhesDaCategoriaDto.class);
    }

    @Transactional
    public void remover(Long id) {
        repository.deleteById(id);
    }

    public List<DetalhesDaCategoriaDto> listarTodos() {
        List<Categoria> todas = repository.findAll();
        return todas
                .stream()
                .map(v -> modelMapper.map(v, DetalhesDaCategoriaDto.class))
                .collect(Collectors.toList());
    }

    public DetalhesDaCategoriaDto detalhar(Long id) {
        Categoria detalhada = repository.getById(id);
        return modelMapper.map(detalhada, DetalhesDaCategoriaDto.class);
    }

}
