package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CarrinhoDeCompras {
    private List<Item> listaItems;

    public CarrinhoDeCompras() {
        this.listaItems = new ArrayList<>();
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        listaItems.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> listaParaRemover = new ArrayList<>();
        if (!listaItems.isEmpty()) {
            for (Item item : listaItems) {
                if (item.getNome().equalsIgnoreCase(nome)) {
                    listaParaRemover.add(item);
                }
            }
            listaItems.removeAll(listaParaRemover);
        }
        else {
            System.out.println("O carrinho está vazio");
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : listaItems) {
            total += item.getPreco() * item.getQuantidade();
        }

        return total;
    }

    public void exibirItems() {
        for (Item item : listaItems) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        CarrinhoDeCompras items = new CarrinhoDeCompras();

        items.adicionarItem("Arroz", 10.00, 1);
        items.adicionarItem("Ração", 60.00, 1);
        items.adicionarItem("Sache", 3.49, 10);
        items.adicionarItem("Miojo", 1.95, 5);

        items.exibirItems();
        System.out.println("Total: " + items.calcularValorTotal());
        System.out.println("-----------------");
        items.removerItem("sache");
        items.exibirItems();
        System.out.println("Total: " + items.calcularValorTotal());
    }
}
