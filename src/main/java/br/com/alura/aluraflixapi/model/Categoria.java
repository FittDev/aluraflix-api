package br.com.alura.aluraflixapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String cor;

    public void atualizarInformacoes(String titulo, String cor) {
        this.titulo = titulo;
        this.cor = cor;
    }

}
