package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    Set<String> setPalavras;

    public ConjuntoPalavrasUnicas() {
        this.setPalavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        setPalavras.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if (!setPalavras.isEmpty()) {
            setPalavras.remove(palavra);
        } else {
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public boolean verificarPalavra(String palavra) {
        if (!setPalavras.isEmpty()) {

            return setPalavras.contains(palavra);
        } else {
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public void exibirPalavrasUnicas() {
        if (!setPalavras.isEmpty()) {
            System.out.println(setPalavras);

        } else {
            throw new RuntimeException("O conjunto está vazio");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConjuntoPalavrasUnicas palavrasUnicas = new ConjuntoPalavrasUnicas();
        palavrasUnicas.adicionarPalavra("coisa");
        palavrasUnicas.adicionarPalavra("celular");
        palavrasUnicas.adicionarPalavra("mesa");
        palavrasUnicas.adicionarPalavra("garrafa");
        palavrasUnicas.exibirPalavrasUnicas();
        System.out.print("Digite uma palavra para remover: ");
        String palavraParaRemover = sc.next();
        palavrasUnicas.removerPalavra(palavraParaRemover);
        palavrasUnicas.exibirPalavrasUnicas();
        System.out.print("Digite uma palavra para verificar: ");
        String palavraParaVerificar = sc.next();
        System.out.println("A palavra " + palavraParaVerificar + (palavrasUnicas.verificarPalavra(palavraParaVerificar) ?
                " existe " : " não existe") + " no conjunto");
        sc.close();
    }
}
