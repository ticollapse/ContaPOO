package Conta;

public class Conta {

	private String nome;
	private int numero;
	protected float saldo;
	
	public Conta(String nome, int numero, float valorInicial) {
		this.nome = nome;
		this.numero = numero;
		this.saldo = valorInicial;
	}
	
	public void depositar(float valor) {
		this.saldo += valor;
	}
	
	
	public boolean transferePara(Conta c, float valor) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			c.adicionarSaldo(valor);
			return true;
		}
		return false;
	}
	
	public void adicionarSaldo(float valor) {
		this.saldo += valor;
	}
	
	
	
}
