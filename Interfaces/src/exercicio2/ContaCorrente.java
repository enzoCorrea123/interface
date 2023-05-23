package exercicio2;

public class ContaCorrente {
	public float saldo;

	public void definirSaldoInicial(float saldo) {
		this.saldo = saldo;
	}

	public void depositar(float valor) {
		this.saldo += valor;
	}

	public boolean sacar(float valor) {
		if (valor <= saldo) {
			this.saldo -= valor;
			return true;
		} else {
			return false;
		}

	}
}
