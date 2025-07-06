import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Cliente> listaDeClientes = new ArrayList<>();
    private List<Conta> listaDeContas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void adicionarCliente(Cliente cliente) {
        listaDeClientes.add(cliente);
    }

    public void criarConta(Cliente cliente) {
        Conta novaConta = new Conta(cliente);
        listaDeContas.add(novaConta);
    }

    public Conta procurarConta(String numeroConta) {
        for (Conta conta : listaDeContas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void listarClientes() {
        for (Cliente c : listaDeClientes) {
            c.exibirDados();
            System.out.println("---------------");
        }
    }

    public void listarContas() {
        for (Conta c : listaDeContas) {
            c.exibirDadosConta();
            System.out.println("---------------");
        }
    }

    public String getNome() {
        return nome;
    }
}
