import java.math.BigDecimal;

import br.com.tavares.banco.Banco;
import br.com.tavares.cliente.Cliente;
import br.com.tavares.conta.Conta;
import br.com.tavares.conta.ContaCorrente;
import br.com.tavares.conta.ContaPoupanca;
import br.com.tavares.conta.ContaSalario;
import br.com.tavares.conta.ContaUniversitaria;

public class App {
    public static void main(String[] args) throws Exception {
        Cliente william = new Cliente("William Tavares", "Rua Tal", "21999999999");
        
        Conta corrente1 = new ContaCorrente(william);
        Conta universitaria1 = new ContaUniversitaria(william);
        Conta salario1 = new ContaSalario(william);
        Conta poupanca1 = new ContaPoupanca(william);

        corrente1.depositar(new BigDecimal(600.00));
        corrente1.tranferir(new BigDecimal(550.00), universitaria1);
        corrente1.tranferir(new BigDecimal(50.00), poupanca1);
        universitaria1.sacar(new BigDecimal(510.00));
        universitaria1.tranferir(new BigDecimal(40.00), salario1);

        try {
            salario1.depositar(new BigDecimal(150.00));
        } catch(Error e) {
            System.out.println(e.getMessage());
        }
        
        poupanca1.sacar(new BigDecimal(50.00));
        Banco.imprimeHistoricoTransacoes();
    }
}
