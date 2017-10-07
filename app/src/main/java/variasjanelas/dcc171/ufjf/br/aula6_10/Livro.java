package variasjanelas.dcc171.ufjf.br.aula6_10;

/**
 * Created by ice on 06/10/17.
 */

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano;
    private  Float  preco;

    public Livro(String titulo, String autor, String editora, Integer ano, Float preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.preco = preco;
    }

    public Livro() {
       this(null,null,null,null,null);
    }

    public String getAutor() {

        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


}
