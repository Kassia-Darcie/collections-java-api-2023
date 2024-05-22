package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> listaTarefas;

    public ListaTarefas() {
        this.listaTarefas = new ArrayList<>();
    }

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public void adicionarTarefa(String descricao){
        listaTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> listaRemocao = new ArrayList<>();
        if (!listaTarefas.isEmpty()) {
            for (Tarefa t : listaTarefas) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    listaRemocao.add(t);
                }
            }
            listaTarefas.removeAll(listaRemocao);
        }
        else {
            System.out.println("A lista está vazia");
        }
    }

    public int obterNumeroTotaTarefas() {
        return listaTarefas.size();
    }

    public void obterDescricoesTarefas() {
        System.out.println(listaTarefas);
    }

    public static void main(String[] args) {
        ListaTarefas tarefas = new ListaTarefas();
        tarefas.adicionarTarefa("Tarefa 1");
        tarefas.adicionarTarefa("Tarefa 2");
        tarefas.adicionarTarefa("Tarefa 3");
        tarefas.adicionarTarefa("Tarefa 3");
        System.out.println("Numero de elementos na lista: " + tarefas.obterNumeroTotaTarefas());
        tarefas.obterDescricoesTarefas();
        tarefas.removerTarefa("Tarefa 3");
        tarefas.obterDescricoesTarefas();
    }
}
