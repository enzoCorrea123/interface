import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		ContaCorrente conta1 = new ContaCorrente();
		ContaCorrenteEspecial conta2 = new ContaCorrenteEspecial();

		conta1.deposito(1200);
		double valor1 = conta1.getSaldo();
		conta1.saque(500);
		double valor2 = conta1.getSaldo();

		JOptionPane.showMessageDialog(null, "Valor depositado da conta 1: " + valor1 + "\nValor do saque: " + valor2);
		conta2.deposito(1200);
		valor1 = conta2.getSaldo();
		conta2.saque(500);
		valor2 = conta2.getSaldo();
		
		JOptionPane.showMessageDialog(null, "Valor depositado da conta 2: " + valor1 + "\nValor do saque: " + valor2);

	}

}
