
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		int[] numeroVoo = new int[10];
		int[] tipoVoo = new int[10];
		int[] quantidadeLugares = new int[10];
		double[] precoVoo = new double[10];
		double[] precoVooTotal = new double[10];
		double somaPreco = 0;
		int identidadePassageiro;
		int numeroVooPassageiro;

		for (int contador = 0; contador < 10; contador++) {
			numeroVoo[contador] = Integer
					.parseInt(JOptionPane.showInputDialog("Digite o número do voo " + (contador + 1)));
			tipoVoo[contador] = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo do voo(707,727,737)"));
			precoVoo[contador] = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço da passagem:"));
			precoVooTotal[contador] = 0;
			switch (tipoVoo[contador]) {
			case 707:
				quantidadeLugares[contador] = 200;
				break;
			case 727:
				quantidadeLugares[contador] = 170;
				break;
			case 737:
				quantidadeLugares[contador] = 120;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Tipo de voo inválido", "Alerta", JOptionPane.WARNING_MESSAGE);
				contador--;
			}

		}

		while (true) {
			identidadePassageiro = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da identidade"));
			if (identidadePassageiro == 0) {
				break;
			}
			numeroVooPassageiro = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do vôo"));

			for (int contador = 0; contador < 10; contador++) {
				if (numeroVooPassageiro == numeroVoo[contador]) {
					quantidadeLugares[contador]--;
					if (quantidadeLugares[contador] > 0) {
						somaPreco += precoVoo[contador];
						precoVooTotal[contador] += precoVoo[contador];
						JOptionPane.showMessageDialog(null,
								"Identidade: " + identidadePassageiro + "\nNúmero do vôo:" + numeroVooPassageiro
										+ "\nPreço da passagem: " + precoVoo[contador] + "\nRESERVA CONFIRMADA");
					} else {
						JOptionPane.showMessageDialog(null, "VÔO LOTADO", "Alerta", JOptionPane.WARNING_MESSAGE);
					}

				}
			}

		}

		for (int contador = 0; contador < 10; contador++) {
			if (tipoVoo[contador] == 707) {
				if ((200-quantidadeLugares[contador]) > (200 * 0.6)) {
					JOptionPane.showMessageDialog(null, "Vôo número " + numeroVoo[contador] + " tipo "
							+ tipoVoo[contador] + " obteve " + precoVooTotal[contador] + "\nStatus: Lucro");
				} else if ((200-quantidadeLugares[contador]) < (200 * 0.6)) {
					JOptionPane.showMessageDialog(null, "Vôo número " + numeroVoo[contador] + " tipo "
							+ tipoVoo[contador] + " obteve " + precoVooTotal[contador] + "\nStatus: Prejuízo");
				}else {
					JOptionPane.showMessageDialog(null, "Vôo número " + numeroVoo[contador] + " tipo "
							+ tipoVoo[contador] + " obteve " + precoVooTotal[contador] + "\nStatus: pago");
				}
				
			}else if(tipoVoo[contador] == 727) {
				if ((170-quantidadeLugares[contador]) > (170 * 0.6)) {
					JOptionPane.showMessageDialog(null, "Vôo número " + numeroVoo[contador] + " tipo "
							+ tipoVoo[contador] + " obteve " + precoVooTotal[contador] + "\nStatus: Lucro");
				} else if ((170-quantidadeLugares[contador]) < (170 * 0.6)) {
					JOptionPane.showMessageDialog(null, "Vôo número " + numeroVoo[contador] + " tipo "
							+ tipoVoo[contador] + " obteve " + precoVooTotal[contador] + "\nStatus: Prejuízo");
				}else {
					JOptionPane.showMessageDialog(null, "Vôo número " + numeroVoo[contador] + " tipo "
							+ tipoVoo[contador] + " obteve " + precoVooTotal[contador] + "\nStatus: pago");
				}
				
			}else if(tipoVoo[contador] == 737){
				if ((120-quantidadeLugares[contador]) > (120 * 0.6)) {
					JOptionPane.showMessageDialog(null, "Vôo número " + numeroVoo[contador] + " tipo "
							+ tipoVoo[contador] + " obteve " + precoVooTotal[contador] + "\nStatus: Lucro");
				} else if ((120-quantidadeLugares[contador]) < (120 * 0.6)) {
					JOptionPane.showMessageDialog(null, "Vôo número " + numeroVoo[contador] + " tipo "
							+ tipoVoo[contador] + " obteve " + precoVooTotal[contador] + "\nStatus: Prejuízo");
				}else {
					JOptionPane.showMessageDialog(null, "Vôo número " + numeroVoo[contador] + " tipo "
							+ tipoVoo[contador] + " obteve " + precoVooTotal[contador] + "\nStatus: pago");
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "Total dos vôos " + somaPreco);
		
	}

}
