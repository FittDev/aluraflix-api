package br.com.alura.aluraflixapi.repository;

import br.com.alura.aluraflixapi.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideosRepository extends JpaRepository<Video, Long> {
}
