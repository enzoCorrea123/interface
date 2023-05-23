package exercicio4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exercicio3.Fatura;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Fatura");
		final JTextField input1 = new JTextField();

		JLabel label1 = new JLabel("Digite a nota do aluno:");
		JButton button1 = new JButton("confirmar");

		label1.setBounds(20, 10, 160, 30);
		input1.setBounds(20, 40, 180, 20);
		button1.setBounds(20, 60, 130, 30);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Conceito: " + classificarNota(input1));
			}

		});
		frame.add(button1);
		frame.add(input1);
		frame.add(label1);

		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	public static char classificarNota(JTextField input1) {
		double nota = Double.parseDouble(input1.getText());
		if (nota <= 6) {
			return 'E';
		} else if (nota <= 7) {
			return 'D';
		} else if (nota <= 8) {
			return 'C';
		} else if (nota <= 9) {
			return 'B';
		} else if (nota <= 10) {
			return 'A';
		} else {
			return ' ';
		}

	}
}
