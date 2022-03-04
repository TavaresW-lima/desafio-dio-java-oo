package br.com.tavares.conta;

import br.com.tavares.cliente.Cliente;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente, TipoContaEnum.POUPANCA);
    }
}
