package br.com.tavares.conta;

import java.math.BigDecimal;

import br.com.tavares.cliente.Cliente;

public class ContaUniversitaria extends Conta {

    private double limiteSaque;
    
    public double getLimiteSaque() {
        return limiteSaque;
    }

    public ContaUniversitaria(Cliente cliente) {
        super(cliente, TipoContaEnum.UNIVERSITARIA);
        this.limiteSaque = 500.00;
    }

    public ContaUniversitaria(Cliente cliente, double limiteSaque) {
        super(cliente, TipoContaEnum.UNIVERSITARIA);
        this.limiteSaque = limiteSaque;
    }

    @Override
    public BigDecimal sacar(BigDecimal valor) {
        try {
            if(valor.doubleValue() <= this.limiteSaque) {
                return super.sacar(valor);
            } else {
                throw new Error("Valor de saque excede o permitido");
            }
        } catch(Error e) {
            System.out.println(e.getMessage());
            return new BigDecimal(0);
        }
    }

}
