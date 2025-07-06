import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner lerEnt = new Scanner(System.in);
        Banco banco = new Banco("Banco INX");

        while (true) {
            System.out.println("\n------MENU------");
            System.out.println("1) Adicionar cliente");
            System.out.println("2) Criar conta");
            System.out.println("3) Depósito");
            System.out.println("4) Saque");
            System.out.println("5) Transferência");
            System.out.println("6) Listar clientes");
            System.out.println("7) Listar contas");
            System.out.println("0)------SAIR------");
            System.out.print("Escolha: ");

            int opcao = lerEnt.nextInt();
            lerEnt.nextLine();

            switch (opcao) {
                case 1: // Adicionar cliente
                    adicionarCliente(banco, lerEnt);
                    break;

                case 2: // Criar conta
                    criarConta(banco, lerEnt);
                    break;

                case 3: // Depositar
                    System.out.print("Número da conta: ");
                    String numeroConta = lerEnt.nextLine();

                    Conta conta = banco.procurarConta(numeroConta);

                    if (conta != null) {
                        System.out.print("Valor do depósito: ");
                        double valor = lerEnt.nextDouble();
                        lerEnt.nextLine();

                        conta.depositar(valor);
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4: // Saque
                    System.out.print("Número da conta: ");
                    String numeroContaSaque = lerEnt.nextLine();

                    System.out.print("Valor de saque: ");
                    double valor = lerEnt.nextDouble();
                    lerEnt.nextLine();

                    Conta contaSaque = banco.procurarConta(numeroContaSaque);

                    if (contaSaque != null) {
                        contaSaque.sacar(valor);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5: // transferência
                    System.out.print("Número da Conta de origem: ");
                    String numeroContaOrigem = lerEnt.nextLine();

                    System.out.print("Número da Conta de destino: ");
                    String numeroContaDestino = lerEnt.nextLine();

                    System.out.print("Valor de transferência: ");
                    double valorTransfer = lerEnt.nextDouble();
                    lerEnt.nextLine();

                    Conta contaOrigem = banco.procurarConta(numeroContaOrigem);
                    Conta contaDestino = banco.procurarConta(numeroContaDestino);

                    if (contaOrigem != null && contaDestino != null) {
                        contaOrigem.transferir(contaDestino, valorTransfer);
                    } else {
                        System.out.println("Conta origem ou destino não encontrada.");
                    }
                    break;

                case 6: //
                    banco.listarClientes();
                    break;
                case 7:
                    banco.listarContas();
                    break;
                case 0:
                    System.out.println("Finalizando execução do programa!");
                    break;
                default:
                    System.out.println("Insira uma opção válida!");
                    break;
            }

        }

    }

    public static void adicionarCliente(Banco banco, Scanner lerEnt) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String CPF = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        Cliente novo = new Cliente(nome, CPF, endereco);
        banco.adicionarCliente(novo);

        System.out.println("Cliente adicionado com sucesso");

        sc.close();
    }

    public static void criarConta(Banco banco, Scanner lerEnt) {
        Cliente novo = new Cliente("Sarah Rabetti", "4574872645", "Estrada das Lágrimas, 3117");
        banco.adicionarCliente(novo);
    }

}
