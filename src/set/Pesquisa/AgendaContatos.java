package set.Pesquisa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AgendaContatos {
    Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        if (!contatoSet.isEmpty()) {
            for (Contato c : contatoSet) {
                if (c.getNome().startsWith(nome)) {
                    contatosPorNome.add(c);
                }
            }
            return contatosPorNome;
        } else {
            throw new RuntimeException("A lista de contatos está vazia");
        }
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        if (!contatoSet.isEmpty()) {
            for (Contato c : contatoSet) {
                if (c.getNome().equalsIgnoreCase(nome)) {
                    c.setNumero(novoNumero);
                    contatoAtualizado = c;
                    break;
                }
            }
            if (contatoAtualizado == null)
                throw new RuntimeException("Não foram encontrados contatos com esse nome");
            return contatoAtualizado;
        } else {
            throw new RuntimeException("A lista de contatos está vazia");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AgendaContatos contatos = new AgendaContatos();
        contatos.adicionarContato("Kassia", 981484556);
        contatos.adicionarContato("João", 981486123);
        contatos.adicionarContato("Pedro", 982724960);
        contatos.adicionarContato("Maria", 983217132);
        contatos.adicionarContato("Maria Eduarda", 981231271);
        contatos.adicionarContato("Maria Clara", 982953113);
        System.out.println("CONTATOS:");
        contatos.exibirContatos();
        System.out.print("\nDigite um nome para pesquisar: ");
        String nomeParaPesquisar = sc.nextLine();
        System.out.println("CONTATOS ENCONTRADOS:");
        System.out.println(contatos.pesquisarPorNome(nomeParaPesquisar));
        System.out.println(contatos.atualizarNumeroContato("Kassiaa", 912345678));
    }

}
