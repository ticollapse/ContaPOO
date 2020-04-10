package Conta;

public class ContaEspecial extends Conta{
	
	private float limiteCredito;
	
	public ContaEspecial(String nome,int numero, float valorInicial, float limite) {
		super(nome,numero,valorInicial);
		this.limiteCredito = limite;
	}

	public boolean sacar(float valor) {
		if(this.saldo  + limiteCredito >= valor) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}
}