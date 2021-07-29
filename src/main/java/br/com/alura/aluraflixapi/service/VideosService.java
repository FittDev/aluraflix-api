package br.com.alura.aluraflixapi.service;

import br.com.alura.aluraflixapi.dto.AtualizacaoVideoFormDto;
import br.com.alura.aluraflixapi.dto.CadastroVideoFormDto;
import br.com.alura.aluraflixapi.dto.DetalhesDoVideoDto;

import br.com.alura.aluraflixapi.model.Video;
import br.com.alura.aluraflixapi.repository.VideosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideosService {

    @Autowired
    private VideosRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public DetalhesDoVideoDto salvar(CadastroVideoFormDto dto) {
        Video novo = modelMapper.map(dto, Video.class);
        repository.save(novo);
        return modelMapper.map(novo, DetalhesDoVideoDto.class);
    }

    @Transactional
    public DetalhesDoVideoDto atualizar(AtualizacaoVideoFormDto dto) {
        Video atual = repository.getById(dto.getId());
        atual.atualizarInformacoes(dto.getTitulo(), dto.getDescricao(), dto.getUrl());
        return modelMapper.map(atual, DetalhesDoVideoDto.class);
    }

    @Transactional
    public void remover(Long id) {
        repository.deleteById(id);
    }

    public List<DetalhesDoVideoDto> listarTodos() {
        List<Video> todos = repository.findAll();
        return todos
                .stream()
                .map(v -> modelMapper.map(v, DetalhesDoVideoDto.class))
                .collect(Collectors.toList());
    }

    public DetalhesDoVideoDto detalhar(Long id) {
        Video detalhado = repository.getById(id);
        return modelMapper.map(detalhado, DetalhesDoVideoDto.class);
    }

}
