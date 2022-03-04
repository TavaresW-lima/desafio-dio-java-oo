package br.com.tavares.banco;

import java.util.ArrayList;
import java.util.List;

import br.com.tavares.conta.Conta;
import br.com.tavares.conta.transacao.Transacao;

public class Banco {
    public String nome;
    public static List<Conta> contaList;
    public static List<Transacao> historicoTransacoes = new ArrayList<Transacao>();

    public static void imprimeHistoricoTransacoes() {
        System.out.println("\n");
        System.out.println("**** Histórico de Transações ****");
        Banco.historicoTransacoes.forEach(transacao -> {
            System.out.println(transacao);
        });
    }
}
