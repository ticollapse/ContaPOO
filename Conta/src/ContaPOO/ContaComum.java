
package ContaPOO;

public class ContaComum extends Conta {
	
	public ContaComum(String nome,int numero, float valorInicial) {
		super(nome,numero,valorInicial);
	}

	@Override
	public boolean sacar(float valor) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}
	
}
