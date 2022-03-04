package br.com.tavares.conta.transacao;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.tavares.conta.Conta;

public class Transacao {

    private LocalDate dataTransacao;
    private Conta contaOrigem;
    private Conta contaDestino;
    private BigDecimal valor;
    private TipoTransacaoEnum tipo;

    public Transacao(){}

    public Transacao(
        TipoTransacaoEnum tipo,
        BigDecimal valor,
        Conta origem, 
        Conta destino
    ) {
        this.dataTransacao = LocalDate.now();
        this.contaDestino = destino;
        this.contaOrigem = origem;
        this.valor = valor;
        this.tipo = tipo;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoTransacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacaoEnum tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Transacao [contaDestino = " + contaDestino + ", contaOrigem = " + contaOrigem + ", dataTransacao = "
                + dataTransacao + ", tipo = " + tipo + ", valor = " + valor + "]";
    }
}
