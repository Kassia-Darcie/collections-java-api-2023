package map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livrosMap;

    public LivrariaOnline() {
        this.livrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        livrosMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {
        Map.Entry<String, Livro> livroParaRemover = null;
        if (!livrosMap.isEmpty()) {
            for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    livroParaRemover = entry;
                }
            }
            livrosMap.remove(livroParaRemover.getKey());
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> listaParaordenar = new ArrayList<>(livrosMap.entrySet());
        Collections.sort(listaParaordenar, new CompararPorPreco());
        Map<String, Livro> listaOrdenada = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : listaParaordenar) {
            listaOrdenada.put(entry.getKey(), entry.getValue());
        }
        return listaOrdenada;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        List<Map.Entry<String, Livro>> listaParaordenar = new ArrayList<>(livrosMap.entrySet());
        Collections.sort(listaParaordenar, new CompararPorAutor());
        Map<String, Livro> listaOrdenada = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : listaParaordenar) {
            if (entry.getValue().getAutor().equalsIgnoreCase(autor)) {
                listaOrdenada.put(entry.getKey(), entry.getValue());
            }
        }
        return listaOrdenada;
    }

    public Map.Entry<String, Livro> obterLivroMaisCaro() {
        double precoMaisCaro = Double.MIN_VALUE;
        Map.Entry<String, Livro> livroMaisCaro = null;
        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if (entry.getValue().getPreco() > precoMaisCaro) {
                livroMaisCaro = entry;
                precoMaisCaro = entry.getValue().getPreco();
            }
        }
        return livroMaisCaro;
    }

    public Map.Entry<String, Livro> obterLivroMaisBarato() {
        double precoMaisBarato = Double.MAX_VALUE;
        Map.Entry<String, Livro> livroMaisBarato = null;
        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if (entry.getValue().getPreco() < precoMaisBarato) {
                livroMaisBarato = entry;
                precoMaisBarato = entry.getValue().getPreco();
            }
        }
        return livroMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", "1984", "George Orwell", 50d);
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", "A Revolução dos Bichos", "George Orwell", 7.05d);
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", "Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d);
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", "Malorie", "Josh Malerman", 5d);
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", "E Não Sobrou Nenhum", "Agatha Christie", 50d);
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", "Assassinato no Expresso do Oriente", "Agatha Christie", 5d);
        System.out.println("Ordenados por preço:");
        for (Map.Entry<String, Livro> entry : livrariaOnline.exibirLivrosOrdenadosPorPreco().entrySet()) {
            System.out.println(entry);
        }
        String autor = "Agatha Christie";
        System.out.println("Livros de " + autor + ":");
        for (Map.Entry<String, Livro> entry : livrariaOnline.pesquisarLivrosPorAutor(autor).entrySet()) {
            System.out.println(entry);
        }
        System.out.println("Livro mais caro:");
        System.out.println(livrariaOnline.obterLivroMaisCaro());
        System.out.println("Livro mais barato:");
        System.out.println(livrariaOnline.obterLivroMaisBarato());
        System.out.println();
        livrariaOnline.removerLivro("Malorie");
        for (Map.Entry<String, Livro> entry : livrariaOnline.exibirLivrosOrdenadosPorPreco().entrySet()) {
            System.out.println(entry);
        }
    }
}
