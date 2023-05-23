import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ex1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Quantidade de passos");
		final JTextField input1 = new JTextField();
		final JTextField input2 = new JTextField();
		final JTextField input3 = new JTextField();

		JLabel label1 = new JLabel("Digite o valor x.");
		JLabel label2 = new JLabel("Digite o valor y.");
		JLabel label3 = new JLabel("Digite o valor z.");
		JButton button = new JButton("Clique aqui");

		label1.setBounds(20, 10, 100, 30);
		input1.setBounds(20, 40, 150, 20);
		label2.setBounds(20, 60, 100, 30);
		input2.setBounds(20, 90, 150, 20);
		label3.setBounds(20, 110, 100, 30);
		input3.setBounds(20, 130, 150, 20);
		button.setBounds(20, 150, 130, 30);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atravessaRua(input1, input2, input3, frame);
			}

		});
		frame.add(button);
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

	static void atravessaRua(JTextField input1, JTextField input2, JTextField input3, JFrame frame) {
		int x = Integer.parseInt(input1.getText());
		int y = Integer.parseInt(input2.getText());
		int z = Integer.parseInt(input3.getText());
		int contador = 0;
		
		while (x < y) {
			x = x + z;
			contador++;
			
		}
		if(contador%z != 0) {
			contador++;
		}
		JOptionPane.showMessageDialog(frame, "Foi necessário: " + contador + " passos");

	}

}
