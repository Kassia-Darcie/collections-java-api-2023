package list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> listaPessoas;

    public OrdenacaoPessoas() {
        this.listaPessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        listaPessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(listaPessoas);
        Collections.sort(pessoasPorIdade);

        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(listaPessoas);
        Collections.sort(pessoasPorAltura, new ComparatorAltura());
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas pessoas = new OrdenacaoPessoas();
        pessoas.adicionarPessoa("Fulano", 23, 1.67);
        pessoas.adicionarPessoa("Raimunda", 104, 1.47);
        pessoas.adicionarPessoa("Antonio", 53, 1.87);
        pessoas.adicionarPessoa("Enzo", 5, 1.05);
        pessoas.adicionarPessoa("Manuela", 1, 1.57);
        pessoas.adicionarPessoa("Mateus", 13, 1.60);
        pessoas.adicionarPessoa("Maria", 62, 1.62);

        System.out.println("--- Pessoas por idade ---");
        for (Pessoa p : pessoas.ordenarPorIdade()) {
            System.out.println(p);
        }
        System.out.println("\n--- Pessoas por altura ---");
        for (Pessoa p : pessoas.ordenarPorAltura()) {
            System.out.println(p);
        }
    }
}
