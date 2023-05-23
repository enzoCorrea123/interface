
public class ContaCorrenteEspecial {
	private double saldo = 0;

	public void deposito(double valor) {
		this.saldo += valor;
	}

	public void saque(double valor) {
		this.saldo -= valor * 1.001;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	
}
