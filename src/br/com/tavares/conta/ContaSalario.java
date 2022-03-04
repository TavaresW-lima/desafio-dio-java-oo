package br.com.tavares.conta;

import java.math.BigDecimal;

import br.com.tavares.cliente.Cliente;

public class ContaSalario extends Conta {
    public ContaSalario(Cliente cliente) {
        super(cliente, TipoContaEnum.SALARIO);
    }

    @Override
    public BigDecimal depositar(BigDecimal valor) {
        throw new Error("Não é possível depositar nessa conta");
    }
}
