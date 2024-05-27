package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> contatosMap;

    public AgendaContatos() {
        this.contatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        contatosMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!contatosMap.isEmpty()) {
            contatosMap.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(contatosMap);
    }

    public int pesquisarPorNome(String nome) {
        return contatosMap.get(nome);
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();
        agendaContatos.adicionarContato("Camila", 123456);
        agendaContatos.adicionarContato("João", 5665);
        agendaContatos.adicionarContato("Carlos", 1111111);
        agendaContatos.adicionarContato("Ana", 654987);
        agendaContatos.adicionarContato("Maria", 1111111);
        agendaContatos.adicionarContato("Camila", 44444);
        agendaContatos.exibirContatos();
        agendaContatos.removerContato("João");
        agendaContatos.exibirContatos();
        String nomeParaPesquisar = "Maria";
        System.out.println("Telefone de " + nomeParaPesquisar + ": " + agendaContatos.pesquisarPorNome(nomeParaPesquisar));
    }
}
