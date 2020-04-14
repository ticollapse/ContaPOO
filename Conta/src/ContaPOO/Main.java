package ContaPOO;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.List;


public class Main {
	
	public static void main(String args[]) {
		
		int opcao = 0;
		int tipoConta = 0;
		
		String nomeUsuario;
		float valorInicial;
		float limite;
		float saque;
		float deposito;

		
		int numeroConta = 1;
		
		List<Conta> listaConta = new ArrayList<Conta>();
		
		/*
		List<ContaComum> listaContaComum = new ArrayList<ContaComum>();
		List<ContaEspecial> listaContaEspecial = new ArrayList<ContaEspecial>();*/
		
		do {
			System.out.println("1 - Criar Conta");
			System.out.println("2 - Sacar");
			System.out.println("3 - Depositar");
			System.out.println("4 - Transferir");
			System.out.println("0 - Sair");
			
			Scanner leitura = new Scanner(System.in);
			opcao = leitura.nextInt();
			
			switch (opcao) {
			case 1: {

				System.out.println("Nome do usu�rio: ");
				nomeUsuario = leitura.next();
				
				System.out.println("Valor inicial: ");
				valorInicial = leitura.nextFloat();
				
				System.out.println("1 - Conta Especial");
				System.out.println("2 - Conta Comum");
				tipoConta = leitura.nextInt();
				
				if(tipoConta == 1) {
					System.out.println("Limite de credito: ");
					limite = leitura.nextFloat();
			
					ContaEspecial ce = new ContaEspecial(nomeUsuario,numeroConta,valorInicial,limite);
					listaConta.add(ce);
				}else if( tipoConta == 2 ){
					ContaComum cc = new ContaComum(nomeUsuario,numeroConta,valorInicial);
					listaConta.add(cc);
				}
				
				if (tipoConta == 1 || tipoConta == 2) {
					numeroConta++;
					System.out.println("Conta criada com sucesso!\nNumero da conta"+numeroConta);
				}else {
					System.out.println("Tipo de Conta inv�lido!");
				}
				
				break;
			}
			case 2: {
				int numeroContaAux = 0;
				System.out.print("Digite o n�mero da conta:");
				numeroContaAux = leitura.nextInt();
				for(int i=0; i<listaConta.size(); i++) {
					if(listaConta.get(i).getNumero() == numeroContaAux) {
						System.out.println("Qual o valor do saque?");
						saque = leitura.nextFloat();
						if(listaConta.get(i).sacar(saque)) {
							System.out.println("Saque realizado com sucesso!!");
						}
						System.out.println("Erro ao realizar o saque.");
					}
				}
				break;
			}
			case 3: {
				int numeroContaAux = 0;
				System.out.print("Digite o n�mero da conta:");
				numeroContaAux = leitura.nextInt();
				for(int i=0; i<listaConta.size(); i++) {
					if(listaConta.get(i).getNumero() == numeroContaAux) {
						System.out.println("Qual o valor do dep�sito?");
						deposito = leitura.nextFloat();
						listaConta.get(i).depositar(deposito);
						System.out.println("Dep�sito realizado com sucesso!!");
					}
				}
				
				break;
			}
			case 4: {
				int numeroContaOrigem = 0;
				int numeroContaDestino = 0;
				float valor = 0;
				
				Conta contaOrigem = null;
				Conta contaDestino = null;
				
				System.out.print("Digite o n�mero da conta origem:");
				numeroContaOrigem = leitura.nextInt();
				System.out.print("Digite o n�mero da conta destino:");
				numeroContaDestino = leitura.nextInt();

				for(int i=0; i<listaConta.size(); i++) {
					if(listaConta.get(i).getNumero() == numeroContaOrigem) {
						System.out.println("Qual o valor da transferencia");
						valor = leitura.nextFloat();
						contaOrigem = listaConta.get(i);
					}
					if(listaConta.get(i).getNumero() == numeroContaDestino) {
						contaDestino = listaConta.get(i);
					}
				}
				if(contaOrigem != null && contaDestino != null) {
					contaOrigem.transferir(contaDestino, valor);
					System.out.println("Sucesso ao realizar a transferencia!");
				}else {
					System.out.println("Erro ao realizar a transferencia.");
				}
				
				break;
			}
			case 0: {
				break;
			}
			default:
				throw new IllegalArgumentException("Valor inesperado: " + opcao);
			}
			
		}while(opcao !=0);
		
		
	}

	
}