package list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> listaNumeros;

    public SomaNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public List<Integer> exibirNumeros() {
        return listaNumeros;
    }

    public void adicionarNumero(int numero) {
        listaNumeros.add(numero);
    }

    public int calcularSoma() {
        int soma = 0;
        for (int n : listaNumeros) {
            soma += n;
        }
        return soma;
    }

    public int encontrarMaiorNumero() {
        int maior = listaNumeros.get(0);
        for (int n : listaNumeros) {
            if (n > maior) {
                maior = n;
            }
        }
        return maior;
    }

    public int encontrarMenorNumero() {
        int menor = listaNumeros.get(0);
        for (int n : listaNumeros) {
            if (n < menor) {
                menor = n;
            }
        }
        return menor;
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();
        int[] numerosParaAdicionar = {3,23,7,90,35,33,27,52,62,1,7,87,541};
        for (int n : numerosParaAdicionar) {
            somaNumeros.adicionarNumero(n);
        }
        System.out.println(somaNumeros.exibirNumeros());
        System.out.println("Soma: " + somaNumeros.calcularSoma());
        System.out.println("Maior: " + somaNumeros.encontrarMaiorNumero());
        System.out.println("Menor: " + somaNumeros.encontrarMenorNumero());
    }

}
