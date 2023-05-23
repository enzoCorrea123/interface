package exercicio3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Fatura");
		final JTextField input1 = new JTextField();
		final JTextField input2 = new JTextField();
		final JTextField input3 = new JTextField();
		final JTextField input4 = new JTextField();

		JLabel label1 = new JLabel("Digite o número do produto");
		JLabel label2 = new JLabel("Digite a descrição do produto");
		JLabel label3 = new JLabel("Digite a quantidade do produto");
		JLabel label4 = new JLabel("Digite a o valor do item");
		JButton button1 = new JButton("confirmar");

		label1.setBounds(20, 10, 160, 30);
		input1.setBounds(20, 40, 180, 20);
		label2.setBounds(20, 60, 200, 30);
		input2.setBounds(20, 90, 180, 20);
		label3.setBounds(20, 110, 200, 30);
		input3.setBounds(20, 130, 180, 20);
		label4.setBounds(20, 150, 200, 30);
		input4.setBounds(20, 180, 180, 20);
		button1.setBounds(20, 210, 130, 30);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fatura fatura1 = new Fatura(input1.getText(), input2.getText(), Integer.parseInt(input3.getText()),
						Double.parseDouble(input4.getText()));
				
				JOptionPane.showMessageDialog(frame, "Número do produto: " + fatura1.getNumero() + "\nDescrição: "+fatura1.getDescricao() + 
						"\nValor total: " + fatura1.getTotalFatura());
			}

		});
		frame.add(button1);
		frame.add(input1);
		frame.add(input2);
		frame.add(input3);
		frame.add(input4);
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);

		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);

	}

}
