package list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> listaNumeros;

    public OrdenacaoNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        listaNumeros.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosAscendente = new ArrayList<>(listaNumeros);
        if (!listaNumeros.isEmpty()) {
            Collections.sort(numerosAscendente);
            return numerosAscendente;
        } else {
            throw new RuntimeException();
        }

    }

    public List<Integer> ordenarDescendente() {
        List<Integer> numerosDescendente = new ArrayList<>(listaNumeros);
        if (!listaNumeros.isEmpty()) {
            numerosDescendente.sort(Collections.reverseOrder());
            return numerosDescendente;
        } else {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();
        int[] numerosParaAdicionar = {3, 23, 7, 90, 35, 33, 27, 52, 62, 1, 7, 87, 541};
        for (int n : numerosParaAdicionar) {
            numeros.adicionarNumero(n);
        }
        System.out.println("--- ORDEM ASCENDENTE ---");
        System.out.println(numeros.ordenarAscendente());
        System.out.println("\n--- ORDEM DESCENDENTE ---");
        System.out.println(numeros.ordenarDescendente());
    }
}
