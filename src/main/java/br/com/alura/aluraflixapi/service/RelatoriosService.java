package br.com.alura.aluraflixapi.service;

import br.com.alura.aluraflixapi.dto.RelatorioDeCategoriasDto;
import br.com.alura.aluraflixapi.repository.CategoriasRepository;
import br.com.alura.aluraflixapi.repository.VideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatoriosService {

    @Autowired
    private VideosRepository repository;

    public List<RelatorioDeCategoriasDto> relatorioDeCategorias() {
        return repository.relatorioDeCategorias();
    }
}
