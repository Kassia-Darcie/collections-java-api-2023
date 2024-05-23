package list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> listaLivros;

    public CatalogoLivros() {
        this.listaLivros = new ArrayList<>();
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        listaLivros.add(new Livro(titulo,autor,anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        for (Livro l : listaLivros) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                livrosPorAutor.add(l);
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> listaPorAno = new ArrayList<>();
        for (Livro l : listaLivros) {
            if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                listaPorAno.add(l);
            }
        }

        return listaPorAno;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livro = null;
        for (Livro l : listaLivros){
            if (l.getTitulo().equalsIgnoreCase(titulo)){
                livro = l;
                break;
            }
        }
        return livro;
    }

    public static void main(String[] args) {
        CatalogoLivros livros = new CatalogoLivros();
        livros.adicionarLivro("Como manipular humanos para servir você, e ainda ficarem felizes por isso",
                "Neguinho Darcie", 2024);
        livros.adicionarLivro("O segredo do miado irresistível",
                "Neguinho Darcie", 2024);
        livros.adicionarLivro("A Sociedade do Anel",
                "J.R.R. Tolkien", 1954);
        livros.adicionarLivro("As Duas Torres",
                "J.R.R. Tolkien", 1954);
        livros.adicionarLivro("O Retorno do Rei",
                "J.R.R. Tolkien", 1955);
        livros.adicionarLivro("Harry Potter e a Pedra Filosofal",
                "J.K. Rowling", 1997);
        livros.adicionarLivro("Harry Potter e a Pedra Filosofal",
                "J.K. Rowling", 1997);

        String autor = "Neguinho Darcie";
        System.out.println("Livros do autor: " + autor);
        for (Livro l : livros.pesquisarPorAutor(autor)){
            System.out.println(l);
        }
        System.out.println("----------------");
        System.out.println(livros.pesquisarPorIntervaloAnos(1900,1990));
        System.out.println("----------------");
        System.out.println(livros.pesquisarPorTitulo("Harry Potter e a Pedra Filosofal"));



    }
}
