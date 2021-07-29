package br.com.alura.aluraflixapi.repository;

import br.com.alura.aluraflixapi.dto.RelatorioDeCategoriasDto;
import br.com.alura.aluraflixapi.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideosRepository extends JpaRepository<Video, Long> {

    @Query("select new br.com.alura.aluraflixapi.dto.RelatorioDeCategoriasDto(c.titulo, count(v.id)) from Video v join v.categoria c group by c.titulo")
    List<RelatorioDeCategoriasDto> relatorioDeCategorias();
}
