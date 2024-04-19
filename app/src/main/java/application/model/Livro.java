package application.model;

import jakarta.persistence.Entity; // annotation para definir uma classe como Entidade (Tabela)
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // annotation para definir que um atributo é um ID
import jakarta.persistence.Table;


@Entity
@Table(name = "livros")
public class Livro {
    private long id;
    private String titulo;
    private String genero;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}