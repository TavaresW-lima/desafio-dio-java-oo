package br.com.tavares.conta;

import java.math.BigDecimal;

import br.com.tavares.banco.Banco;
import br.com.tavares.cliente.Cliente;
import br.com.tavares.conta.transacao.TipoTransacaoEnum;
import br.com.tavares.conta.transacao.Transacao;

public abstract class Conta {
    public static int SEQUENCIAL = 1;
    public static int AGENCIA_PADRAO = 1;

    private int agencia;
    private int numero;
    private Cliente cliente;
    private BigDecimal saldo;
    private TipoContaEnum tipo;

    public Conta( Cliente cliente) {
        this.cliente = cliente;
        this.saldo = new BigDecimal(0);
        this.numero = SEQUENCIAL++;
        this.agencia = AGENCIA_PADRAO;
        this.tipo = TipoContaEnum.CORRENTE;
    }

    public Conta( Cliente cliente, TipoContaEnum tipo) {
        this.cliente = cliente;
        this.saldo = new BigDecimal(0);
        this.numero = SEQUENCIAL++;
        this.agencia = AGENCIA_PADRAO;
        this.tipo = tipo;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public TipoContaEnum getTipo() {
        return tipo;
    }

    public BigDecimal sacar(BigDecimal valor) {
        this.saldo = this.saldo.subtract(valor);

        this.registraTransacao(TipoTransacaoEnum.SAQUE, valor, this, null);
        return this.saldo;
    }

    public BigDecimal depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);

        this.registraTransacao(TipoTransacaoEnum.DEPOSITO, valor, null, this);
        return this.saldo;
    }

    public boolean tranferir(BigDecimal valor, Conta contaDestino) {
        try {
            if(contaDestino instanceof ContaSalario) {
                throw new Error("Não é possível transferir para uma conta salário dessa forma");
            }

            BigDecimal valorTransferido = this.sacar(valor);
            BigDecimal saldoAnteriorDestino = contaDestino.getSaldo();
            boolean saldoContaOrigemSubtraido = valor == valorTransferido;
            boolean saldoContaDestinoAcrescido = contaDestino.getSaldo() == saldoAnteriorDestino.add(valorTransferido);
            contaDestino.depositar(valorTransferido);
    
            this.registraTransacao(TipoTransacaoEnum.TRANSFERENCIA, valor, this, contaDestino);
            return ( saldoContaOrigemSubtraido & saldoContaDestinoAcrescido);
        } catch(Error e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void registraTransacao(TipoTransacaoEnum tipo, BigDecimal valor, Conta origem, Conta destino) {
        Transacao novaTransacao = new Transacao(tipo, valor, origem, destino);
        Banco.historicoTransacoes.add(novaTransacao);
    }

    @Override
    public String toString() {
        return agencia + " " + "000" + numero;
    }
}
