package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        if (!tarefaSet.isEmpty()) {
            Tarefa tarefaParaRemover = null;
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = t;
                    tarefaSet.remove(tarefaParaRemover);
                    break;
                }
            }
        } else {
            throw new RuntimeException("A lista de tarefas está vazia!");
        }
    }

    public void exibirTarefas() {
        System.out.println(tarefaSet);
    }

    public int contarTarefas() {
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.isConcluida()) {
                    tarefasConcluidas.add(t);
                }
            }
            return tarefasConcluidas;
        } else {
            throw new RuntimeException("A lista de tarefas está vazia!");
        }
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (!t.isConcluida()) {
                    tarefasPendentes.add(t);
                }
            }
            return tarefasPendentes;
        } else {
            throw new RuntimeException("A lista de tarefas está vazia!");
        }
    }

    public Tarefa marcarTarefaConcluida(String descricao) {
        Tarefa tarefaAtualizada = null;
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(true);
                    tarefaAtualizada = t;
                }
            }
            if (tarefaAtualizada != null) {
                return tarefaAtualizada;
            } else {
                throw new RuntimeException("Tarefa não encontrada!");
            }
        } else {
            throw new RuntimeException("A lista de tarefas está vazia!");
        }
    }

    public Tarefa marcarTarefaPendente(String descricao) {
        Tarefa tarefaAtualizada = null;
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(false);
                    tarefaAtualizada = t;
                }
            }
            if (tarefaAtualizada != null) {
                return tarefaAtualizada;
            } else {
                throw new RuntimeException("Tarefa não encontrada!");
            }
        } else {
            throw new RuntimeException("A lista de tarefas está vazia!");
        }
    }

    public void limparListaTarefas() {
        tarefaSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas tarefas = new ListaTarefas();
        tarefas.adicionarTarefa("Tarefa 1");
        tarefas.adicionarTarefa("Tarefa 2");
        tarefas.adicionarTarefa("Tarefa 3");
        tarefas.adicionarTarefa("Tarefa 4");
        tarefas.adicionarTarefa("Tarefa 5");
        tarefas.exibirTarefas();
        tarefas.removerTarefa("Tarefa 5");
        tarefas.exibirTarefas();
        System.out.println("Numero de tarefas na lista: " + tarefas.contarTarefas());
        tarefas.marcarTarefaConcluida("Tarefa 4");
        System.out.println("TAREFAS CONCLUIDAS:");
        System.out.println(tarefas.obterTarefasConcluidas());
        System.out.println("TAREFAS PENDENTES:");
        System.out.println(tarefas.obterTarefasPendentes());
        tarefas.limparListaTarefas();
        tarefas.exibirTarefas();
    }
}
