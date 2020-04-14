package ContaPOO;

public abstract class Conta {

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
	
	public abstract boolean sacar(float valor);
	
	public void adicionarSaldo(float valor) {
		this.saldo += valor;
	}

	public void removerSaldo(float valor) {
		this.saldo -= valor;
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public float getSaldo(){
		return this.saldo;
	}
	
	public boolean transferir(Conta destino,float valor) {
		if(this.saldo - valor >= 0) {
			this.saldo -= valor;
			destino.adicionarSaldo(valor);
			return true;
		}
		return false;
	}

	
}