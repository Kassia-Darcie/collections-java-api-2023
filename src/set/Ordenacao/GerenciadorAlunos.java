package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    Set<Aluno> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunosSet.add(new Aluno(matricula, nome, media));
    }

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;
        if (!alunosSet.isEmpty()) {
            for (Aluno a : alunosSet) {
                if (a.getMatricula().equals(matricula)) {
                    alunoParaRemover = a;
                    break;
                }
            }
            if (alunoParaRemover != null) {
                alunosSet.remove(alunoParaRemover);
            } else {
                System.out.println("Matrícula não encontrada!");
            }
        } else {
            throw new RuntimeException("A lista de alunos está vazia!");
        }
    }

    public void exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunosSet);
        for (Aluno a : alunosPorNome) {
            System.out.println(a);
        }
    }

    public void exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new CompararAlunoPorNota());
        alunosPorNota.addAll(alunosSet);
        for (Aluno a : alunosPorNota) {
            System.out.println(a);
        }
    }

    public void exibirAlunos() {
        for (Aluno a : alunosSet) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos alunos = new GerenciadorAlunos();
        alunos.adicionarAluno("Maria", 46478L, 7.5);
        alunos.adicionarAluno("Marcos", 213512L, 5.5);
        alunos.adicionarAluno("Sofia", 1235L, 9.5);
        alunos.adicionarAluno("Pedro", 64221L, 3.5);
        System.out.println("ALUNOS POR NOME:");
        alunos.exibirAlunosPorNome();
        System.out.println("ALUNOS POR NOTA:");
        alunos.exibirAlunosPorNota();
        System.out.println("---------------------");
        alunos.removerAluno(64221L);
        alunos.exibirAlunos();

    }
}
