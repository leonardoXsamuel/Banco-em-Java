public class Conta {

    private String numeroConta;
    private double saldo;
    private Cliente cliente;
    //private String tipoConta;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.numeroConta = gerarNumeroConta();
        this.saldo = 0;
    }

    private String gerarNumeroConta() {
        return String.valueOf((int) (Math.random() * 100000));
    }

    public double depositar(double valor) {
        saldo += valor;
        return saldo;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado. Novo saldo: R$" + saldo);
        } else {
            System.out.println("SALDO INSUFICIENTE!");
        }
    }

    public void transferir(Conta destino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada para a conta " + destino.getNumeroConta());
        } else {
            System.out.println("SALDO INSUFICIENTE!");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void exibirDadosConta() {
        System.out.println("CONTA: " + numeroConta);
        System.out.println("TITULAR: " + cliente.getNome());
        System.out.println("SALDO: R$" + saldo);
    }

}
