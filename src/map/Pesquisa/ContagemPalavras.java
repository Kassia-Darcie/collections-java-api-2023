package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> palavrasMap;

    public ContagemPalavras() {
        this.palavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        palavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!palavrasMap.isEmpty()) {
            palavrasMap.remove(palavra);
            System.out.println(palavra + " foi removida");
        }
    }

    public void exibirContagemPalavras() {
        System.out.println(palavrasMap);
    }

    public Map.Entry<String, Integer> encontrarPalavraMaisFrequente() {
        int maisfrequente = 0;
        Map.Entry<String, Integer> palavraMaisFrequente = null;
        if (!palavrasMap.isEmpty()) {
            for (Map.Entry<String, Integer> entry : palavrasMap.entrySet()) {
                if (entry.getValue() > maisfrequente) {
                    maisfrequente = entry.getValue();
                    palavraMaisFrequente = entry;
                }
            }

        }
        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        // Adiciona linguagens e suas contagens
        contagemLinguagens.adicionarPalavra("Java", 2);
        contagemLinguagens.adicionarPalavra("Python", 8);
        contagemLinguagens.adicionarPalavra("JavaScript", 1);
        contagemLinguagens.adicionarPalavra("C#", 6);
        contagemLinguagens.exibirContagemPalavras();
        contagemLinguagens.removerPalavra("JavaScript");
        contagemLinguagens.exibirContagemPalavras();
        System.out.println("Palavra mais frequente:");
        System.out.println(contagemLinguagens.encontrarPalavraMaisFrequente());
    }
}
