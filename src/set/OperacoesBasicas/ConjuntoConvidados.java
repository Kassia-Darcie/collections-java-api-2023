package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    Set<Convidado> setConvidados;

    public ConjuntoConvidados() {
        this.setConvidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        setConvidados.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;
        if (!setConvidados.isEmpty()) {
            for (Convidado c : setConvidados) {
                if (c.getCodigoConvite() == codigoConvite) {
                    convidadoParaRemover = c;
                    break;
                }
            }
            setConvidados.remove(convidadoParaRemover);
        } else {
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public int contarConvidados() {
        return setConvidados.size();
    }

    public void exibirConvidados() {
        System.out.println(setConvidados);
    }

    public static void main(String[] args) {
        ConjuntoConvidados convidados = new ConjuntoConvidados();
        convidados.adicionarConvidado("Kassia", 1234);
        convidados.adicionarConvidado("Fulano", 12345);
        convidados.adicionarConvidado("Cicrano", 1233);
        convidados.adicionarConvidado("Beltrano", 1234);
        convidados.removerConvidadoPorCodigoConvite(12345);
        convidados.exibirConvidados();
        System.out.println(convidados.contarConvidados());
    }
}
