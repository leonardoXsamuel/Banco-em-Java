import java.util.Scanner;

public class Cliente {

    private String nome;
    private String CPF;
    private String endereco;

    // Construtor
    public Cliente(String nome, String CPF, String endereco) {
        this.nome = nome;
        this.CPF = CPF;
        this.endereco = endereco;
    }

    public void exibirDados() {
        System.out.println("DADOS DO CLIENTE");
        System.out.println("NOME: " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println("ENDEREÇO: " + endereco);
    }

    public void atualizarEndereco(Scanner lerEnt) {
        System.out.print("Digite o novo endereço: ");
        this.endereco = lerEnt.nextLine();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEndereco() {
        return endereco;
    }
}
