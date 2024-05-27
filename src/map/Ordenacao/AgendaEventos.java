package map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        eventoMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> ordenadoPorData = new TreeMap<>(eventoMap);
        if (!eventoMap.isEmpty()) {
            for (Map.Entry<LocalDate, Evento> entry : ordenadoPorData.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        } else {
            System.out.println("Não há eventos na agenda!");
        }
    }

    public Map.Entry<LocalDate, Evento> obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        Map.Entry<LocalDate, Evento> proximoEvento = null;
        if (!eventoMap.isEmpty()) {
            Map<LocalDate, Evento> ordenadoPorData = new TreeMap<>(eventoMap);
            for (Map.Entry<LocalDate, Evento> entry : ordenadoPorData.entrySet()) {
                if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                    proximoEvento = entry;
                    break;
                }
            }

        } else {
            System.out.println("Não há eventos na agenda!");
        }
        return proximoEvento;
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        // Adiciona eventos à agenda
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.AUGUST, 28), "Hackathon de Inovação", "Competição de soluções criativas");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");
        System.out.println("Eventos na agenda");
        agendaEventos.exibirAgenda();
        System.out.println("\nProximo evento:");
        System.out.println(agendaEventos.obterProximoEvento());
    }
}
