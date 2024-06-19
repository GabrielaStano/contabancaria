package conta;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupança;
public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			ContaController contas = new ContaController();
			
			
		Scanner leia = new Scanner(System.in);
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		
		System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaPoupança cp1 = new ContaPoupança(contas.gerarNumero(), 125, 2, "Maria dos Santos", 4000f, 12);
		contas.cadastrar(cc1);
		
		ContaPoupança cp2 = new ContaPoupança(contas.gerarNumero(), 126, 2, "Juliana Ramos", 800f, 15);
		contas.cadastrar(cc1);
		
		contas.listarTodas();
		
		while(true) {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND +
					"*******************************************************");
			System.out.println("                                                       ");
			System.out.println("               BANCO DO BRAZIL COM Z                   ");
			System.out.println("*******************************************************");
			System.out.println("                                                       ");
			System.out.println("             1- Criar conta                            ");
			System.out.println("             2- listar todas as contas                 ");
			System.out.println("             3- Buscar conta por número                ");
			System.out.println("             4- Atualizar dados da conta               ");
			System.out.println("             5- Apagar conta                           ");
			System.out.println("             6- Sacar                                  ");
			System.out.println("             7- Depositar                              ");
			System.out.println("             8- Transferir valores entre contas        ");
			System.out.println("             9- Sair                                   ");
			System.out.println("                                                       ");
			System.out.println("*******************************************************");
			System.out.println("                                                       ");
			System.out.println("Entre com a opção desejada:                            ");
			System.out.println("                                                       "+ Cores.TEXT_RESET);
			opcao = leia.nextInt();
		
				try {
					opcao = leia.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nDigite valores inteiros!");
					leia.nextLine();
					opcao = 0;
				}
		if(opcao ==9) {
			System.out.println("\nBanco do Brazil com Z - O Futuro começa aqui!");
			sobre();
			leia.close();
			System.exit(0);
		}
			
			switch(opcao) {
			case 1: 
				System.out.println(Cores.TEXT_WHITE_BOLD+"Criar Conta \n\n");
				
				System.out.println("Digite o Numero da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o tipo de conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				}while(tipo<1 && tipo > 2);
				
				System.out.println("Digite o saldo da Conta (R$): ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
				case 1 ->{
					System.out.println("Digite o limite do Crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					 }
				case 2 ->{
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupança(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Listar todas as contas\n\n");
				contas.listarTodas();
				
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Atualizar dados conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o Numero da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					titular = leia.next();
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					
					switch(tipo) {
					case 1 -> 
					{
					System.out.println("Digite o limite de Crédito(R$): ");
					limite = leia.nextFloat();
					
					contas.atualizar(new ContaCorrente(numero, agencia,tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversario da Conta: ");
						aniversario = leia.nextInt();
						
						contas.atualizar(new ContaPoupança(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválida!");
						}
					}
				}else{
						System.out.println("A conta não foi encontrada!");
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar a Conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Saque\n\n");
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Depósito\n\n");
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Tranferência entre Contas\n\n");
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD+"\nOpção Inválida!\n");
				
				keyPress();
				break;
			}
		}
	}
	
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Eter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

	public static void sobre() {
		System.out.println("*******************************************************");
		System.out.println("Projeto Desenvolvido por: Gabriela Stano ");
		System.out.println("https://github.com/GabrielaStano/contabancaria.git");
		System.out.println("Generation Brasil - gabiarriaga01@gmail.com");
		System.out.println("*******************************************************");
	}
	
}

