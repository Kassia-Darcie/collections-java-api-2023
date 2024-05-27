package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    Set<Produto> produtosSet;

    public CadastroProdutos() {
        this.produtosSet = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        produtosSet.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(produtosSet);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new CompararPorPreco());
        produtosPorPreco.addAll(produtosSet);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos produtos = new CadastroProdutos();
        produtos.adicionarProduto(12345, "Produto 1", 10d, 2);
        produtos.adicionarProduto(123456, "Produto 2", 1d, 10);
        produtos.adicionarProduto(1234567, "Produto 3", 8d, 3);
        produtos.adicionarProduto(12345678, "Produto 4", 100d, 2);
        produtos.adicionarProduto(12344, "Produto 5", 5d, 20);
        produtos.adicionarProduto(12341, "Produto 6", 23d, 1);
        System.out.println("PRODUTOS POR NOME:");
        for (Produto p : produtos.exibirProdutosPorNome()) {
            System.out.println(p);
        }
        System.out.println("PRODUTOS POR PREÇO:");
        for (Produto p : produtos.exibirProdutosPorPreco()) {
            System.out.println(p);
        }

    }
}
