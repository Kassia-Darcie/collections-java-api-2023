package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(palavra);
        }
    }

    public void exibirPalavras() {
        System.out.println(dicionarioMap);
    }

    public String pesquisarPorPalavra(String palavra) {
        String definicao = dicionarioMap.get(palavra);
        return definicao;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("palavra 1", "descrição 1");
        dicionario.adicionarPalavra("palavra 2", "descrição 2");
        dicionario.adicionarPalavra("palavra 3", "descrição 3");
        dicionario.adicionarPalavra("palavra 4", "descrição 4");
        dicionario.adicionarPalavra("palavra 5", "descrição 5");
        dicionario.adicionarPalavra("palavra 6", "descrição 6");

        String remover = "palavra 5";
        System.out.println("Removendo a palavra: " + remover);
        dicionario.removerPalavra(remover);
        dicionario.exibirPalavras();
        String pesquisar = "palavra 6";
        System.out.println("Definição de " + pesquisar + ": " + dicionario.pesquisarPorPalavra(pesquisar));
    }
}
