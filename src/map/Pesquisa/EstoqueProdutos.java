package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> produtosMap;

    public EstoqueProdutos() {
        this.produtosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        produtosMap.put(cod, new Produto(nome, quantidade, preco));
        System.out.println("Produto adicionado!");
    }

    public void exibirProdutos() {
        System.out.println(produtosMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEmEstoque = 0d;
        if (!produtosMap.isEmpty()) {
            for (Produto p : produtosMap.values()) {
                valorTotalEmEstoque += p.valorTotal();
            }
            return valorTotalEmEstoque;
        } else {
            throw new RuntimeException("O map está vazio");
        }
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        if (!produtosMap.isEmpty()) {
            double maisCaro = Double.MIN_VALUE;
            for (Produto p : produtosMap.values()) {
                if (p.getPreco() > maisCaro) {
                    maisCaro = p.getPreco();
                    produtoMaisCaro = p;
                }
            }
            return produtoMaisCaro;
        } else {
            throw new RuntimeException("O map está vazio");
        }
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        if (!produtosMap.isEmpty()) {
            double maisBarato = Double.MAX_VALUE;
            for (Produto p : produtosMap.values()) {
                if (p.getPreco() < maisBarato) {
                    maisBarato = p.getPreco();
                    produtoMaisBarato = p;
                }
            }
            return produtoMaisBarato;
        } else {
            throw new RuntimeException("O map está vazio");
        }
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorValorTotal = null;
        if (!produtosMap.isEmpty()) {
            double maiorValorTotal = Double.MIN_VALUE;
            for (Produto p : produtosMap.values()) {
                if (p.valorTotal() > maiorValorTotal) {
                    maiorValorTotal = p.valorTotal();
                    produtoMaiorValorTotal = p;
                }
            }
            return produtoMaiorValorTotal;
        } else {
            throw new RuntimeException("O map está vazio");
        }
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
        estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
        estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
        estoque.adicionarProduto(4L, "Teclado", 2, 40.0);
        estoque.exibirProdutos();
        System.out.println("Valor total em estoque: R$ " + String.format("%.2f", estoque.calcularValorTotalEstoque()));
        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("Produto mais caro: " + produtoMaisCaro);
        Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("Produto mais barato: " + produtoMaisBarato);
        Produto produtoComMaiorValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("Produto com maior valor total: " + produtoComMaiorValorTotal + "total: R$ " + String.format("%.2f", produtoComMaiorValorTotal.valorTotal()));
    }
}
