import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.List;

import Conta.ContaComum;
import Conta.ContaEspecial;


public class Main {
	
	public static void main(String args[]) {
		
		int opcao = 0;
		int tipoConta = 0;
		
		String nomeUsuario;
		float valorInicial;
		float limite;

		
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

				System.out.println("Nome do usuário: ");
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
					System.out.println("Tipo de Conta inválido!");
				}
				
				break;
			}
			case 2: {
				break;
			}
			case 3: {
				break;
			}
			case 4: {
				break;
			}
			case 0: {
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
			
		}while(opcao !=0);
		
		
	}
	
}
