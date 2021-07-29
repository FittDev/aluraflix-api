package br.com.alura.aluraflixapi.repository;

import br.com.alura.aluraflixapi.model.Categoria;
import br.com.alura.aluraflixapi.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {
}
