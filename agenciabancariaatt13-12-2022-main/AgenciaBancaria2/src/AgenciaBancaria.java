import java.util.ArrayList;
import java.util.Scanner;
import java.util.ListIterator;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<ContaCorrente> contasBancarias;
    private static int numerodaConta;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<ContaCorrente>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("----------------------------------------");
        System.out.println("-                BANCO APK             -");
        System.out.println("-                ---------             -");
        System.out.println("-                                      -");
        System.out.println("-                                      -");
        System.out.println("-  O QUE PODEMOS FAZER POR VOCÊ HOJE?  -");
        System.out.println("-                                      -");
        System.out.println("- 1- Abra sua conta corrente;          -");
        System.out.println("- 2- Efetuar um depósito;              -");
        System.out.println("- 3- Realizar saque;                   -");
        System.out.println("- 4- Efetuar uma transferência;        -");
        System.out.println("- 5- Consultar conta corrente;         -");
        System.out.println("- 6- Encerrar conta                    -");
        System.out.println("- 7- Sair                              -");
        System.out.println("----------------------------------------");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarContacorrente();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                encontrarconta();
                break;
            case 6:
                encerrarconta();
                break;
            case 7:
                System.out.println("Obrigado usar nossa agência, volte sempre!!");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarContacorrente() {
        System.out.println("\nNome: ");
        String nome = input.next();
        input.nextLine();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Cliente cliente = new Cliente(nome, cpf, email);
        ContaCorrente contacorrente = new ContaCorrente(cliente);

        contasBancarias.add(contacorrente);
        System.out.println("Sua conta foi criada com sucesso seu número de conta é " + contacorrente);

        operacoes();

    }

    private static ContaCorrente encontrarConta(int numerodaConta) {
        ContaCorrente contacorrente = null;
        if (contasBancarias.size() > 0) {
            for (ContaCorrente a : contasBancarias) {
                if (a.getNumerodaConta() == numerodaConta) {
                    contacorrente = a;
                }
            }
        }
        return contacorrente;
    }

    public static void depositar() {
        System.out.println("Informe o número da conta: ");
        int numeroDaConta = input.nextInt();

        ContaCorrente contacorrente = encontrarConta(numeroDaConta);

        if (contacorrente != null) {
            System.out.println("Informe o valor para depósito: ");
            Double valorDeposito = input.nextDouble();
            contacorrente.depositar(valorDeposito);
            System.out.println("Valor foi depositado com sucesso, confira seu saldo!");
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Informe o número da conta: ");
        int numeroDaConta = input.nextInt();

        ContaCorrente contacorrente = encontrarConta(numeroDaConta);

        if (contacorrente != null) {
            System.out.println("Informe o valor que deseja sacar: ");
            Double valorSaque = input.nextDouble();
            contacorrente.sacar(valorSaque);
            System.out.println("Valor foi retirado com sucesso, retire no local indicado e confira seu saldo!");
        } else {
            System.out.println("Conta não encontrada, revise as informaçõe se tente novamente");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Informe a conta que fará a transferência: ");
        int numeroContaEnvia = input.nextInt();

        ContaCorrente contaEnvia = encontrarConta(numeroContaEnvia);
        if (contaEnvia != null) {
            System.out.println("Informe a conta que receberá a transferência: ");
            int numeroContaRecebe = input.nextInt();

            ContaCorrente contarecebe = encontrarConta(numeroContaEnvia);
            if (contarecebe != null) {
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();

                contarecebe.transferir(contarecebe, valor);
            } else {
                System.out.println("Conta para deposito não foi encontrada");
            }
        }
        operacoes();
    }

    public static void encontrarconta() {
        if (contasBancarias.size() > 0) {
            for (ContaCorrente contacorrente : contasBancarias) {
                System.out.println(contacorrente);

            }
        } else {
            System.out.println("Não existem contas cadastradas");
        }
        operacoes();

    }

    public static void encerrarconta() {
        System.out.println("Informe o numero da conta a ser encerrada");
        int numerodaconta = input.nextInt();

        ContaCorrente encerrarconta = encontrarConta(numerodaconta);
        if (encerrarconta != null) {
            int numeroContaRecebe = input.nextInt();
        } else {
            System.out.println("Conta encerrada");
        }
        operacoes();
    }

    /* public static void remove() {
        int numerodaConta = input.nextInt();
        if (numerodaconta != null){
            System.out.println();
        }
        ArrayList<ContaCorrente> List_Of_Array = null;
        ListIterator listIterator = List_Of_Array.listIterator();
        listIterator.next();
        listIterator.remove();
        operacoes();
    }*/

    public static void sair(){
    }
}
