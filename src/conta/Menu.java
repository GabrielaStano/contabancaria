package conta;

import java.util.Scanner;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		int opcao;

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
		
		if(opcao ==9) {
			System.out.println("\nBanco do Brazil com Z - O Futuro começa aqui!");
			sobre();
			leia.close();
			System.exit(0);
		}
			
			switch(opcao) {
			case 1: 
				System.out.println(Cores.TEXT_WHITE_BOLD+"Criar Conta \n\n");
				
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Listar todas as contas\n\n");
				
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Consultar dados da Conta - por número\n\n");
				
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Atualizar dados conta\n\n");
				
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar a Conta\n\n");
				
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Saque\n\n");
				
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Depósito\n\n");
				
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Tranferência entre Contas\n\n");
				
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD+"\nOpção Inválida!\n");
				break;
			}
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

