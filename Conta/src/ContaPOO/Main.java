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
		
		List<ContaComum> listaContaComum = new ArrayList<ContaComum>();
		List<ContaEspecial> listaContaEspecial = new ArrayList<ContaEspecial>();
		
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
					listaContaEspecial.add(ce);
				}else if( tipoConta == 2 ){
					ContaComum cc = new ContaComum(nomeUsuario,numeroConta,valorInicial);
					listaContaComum.add(cc);
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
				System.out.print("Digite o n�mero da conta:");
				numeroConta = leitura.nextInt();
				System.out.println("1 - Conta Especial");
				System.out.println("2 - Conta Comum");
				tipoConta = leitura.nextInt();
				if(tipoConta == 1) {
					for(int i=0; i<listaContaEspecial.size(); i++) {
						if(listaContaEspecial.get(i).getNumero() == numeroConta) {
							System.out.println("Qual o valor do saque?");
							saque = leitura.nextFloat();
							if(listaContaEspecial.get(i).sacar(saque)) {
								System.out.println("Saque realizado com sucesso!!");
							}
							System.out.println("Erro ao realizar o saque.");
						}
					}
				}else if (tipoConta == 2) {
					for(int i=0;i<listaContaComum.size();i++) {
						if(listaContaComum.get(i).getNumero() == numeroConta) {
							System.out.println("Qual o valor do saque?");
							saque = leitura.nextFloat();
							if(listaContaComum.get(i).sacar(saque)) {
								System.out.println("Saque realizado com sucesso!!");
							}
							System.out.println("Erro ao realizar o saque.");
						}
					}
				}
				break;
			}
			case 3: {
				System.out.print("Digite o n�mero da conta:");
				numeroConta = leitura.nextInt();
				System.out.println("1 - Conta Especial");
				System.out.println("2 - Conta Comum");
				tipoConta = leitura.nextInt();
				if(tipoConta == 1) {
					for(int i=0; i<listaContaEspecial.size(); i++) {
						if(listaContaEspecial.get(i).getNumero() == numeroConta) {
							System.out.println("Qual o valor do dep�sito?");
							deposito = leitura.nextFloat();
							listaContaEspecial.get(i).depositar(deposito);
								System.out.println("Dep�sito realizado com sucesso!!");
						}
					}
				}else if (tipoConta == 2) {
					for(int i=0;i<listaContaComum.size();i++) {
						if(listaContaComum.get(i).getNumero() == numeroConta) {
							System.out.println("Qual o valor do deposito?");
							deposito = leitura.nextFloat();
							listaContaComum.get(i).depositar(deposito);
								System.out.println("Saque realizado com sucesso!!");
						}
					}
				}
				break;
			}
			case 4: {
				break;
			}
			case 0: {
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
			
		}while(opcao !=0);
		
		
	}

	
}