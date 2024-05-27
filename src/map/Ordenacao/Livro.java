package map.Ordenacao;

import java.util.Comparator;
import java.util.Map;

public class Livro implements Comparable<Livro> {
    private String titulo;
    private String autor;
    private Double preco;

    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public int compareTo(Livro livro) {
        return preco.compareTo(livro.getPreco());
    }
}

class CompararPorPreco implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return Double.compare(l1.getValue().getPreco(), l2.getValue().getPreco());
    }
}

class CompararPorAutor implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> e1, Map.Entry<String, Livro> e2) {
        return e1.getValue().getAutor().compareToIgnoreCase(e2.getValue().getAutor());
    }
}
