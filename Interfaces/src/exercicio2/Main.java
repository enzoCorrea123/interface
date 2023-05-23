package exercicio2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		ContaCorrente conta1 = new ContaCorrente();

		JFrame frame = new JFrame("Banco");
		final JTextField input1 = new JTextField();
		final JTextField input2 = new JTextField();
		final JTextField input3 = new JTextField();

		JLabel label1 = new JLabel("Digite o saldo inicial");
		JLabel label2 = new JLabel("Digite o quanto queres depositar");
		JLabel label3 = new JLabel("Digite o quanto queres sacar");
		JButton button1 = new JButton("confirmar");

		label1.setBounds(20, 10, 160, 30);
		input1.setBounds(20, 40, 180, 20);
		label2.setBounds(20, 60, 200, 30);
		input2.setBounds(20, 90, 180, 20);
		label3.setBounds(20, 110, 200, 30);
		input3.setBounds(20, 130, 180, 20);
		button1.setBounds(20, 150, 130, 30);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conta1.definirSaldoInicial(Float.parseFloat(input1.getText()));
				
				conta1.depositar(Float.parseFloat(input2.getText()));
				
				conta1.sacar(Float.parseFloat(input3.getText()));
				
				if(conta1.sacar(Float.parseFloat(input3.getText())) == true) {
					JOptionPane.showMessageDialog(frame, "Valor da conta: " + conta1.saldo);
				}else {

					JOptionPane.showMessageDialog(frame, "Erro");
				}
				
			}

		});
		frame.add(button1);
		frame.add(input1);
		frame.add(input2);
		frame.add(input3);
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);

		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);

	}

}
