import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		while (true) {

			String ip = JOptionPane.showInputDialog("Digite o endereço ip");
			int tipoMascara = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo da máscara"));
			String mascara = null;
			String mascaraBinario = "";
			String ipBinario = "";
			String binarioBoolean = "";
			String[] ipVetor = new String[4];
			String[] ipVetor2 = new String[4];
			String enderecoRede = "";
			String enderecoBroadcast = "";

			ipVetor = ip.split("\\.");

			if (tipoMascara == 8) {
				mascara = "255.0.0.0";

			} else if (tipoMascara == 16) {
				mascara = "255.255.0.0";

			} else if (tipoMascara == 24) {
				mascara = "255.255.255.0";

			} else if (tipoMascara == 30) {
				mascara = "255.255.255.252";

			} else {
				if (tipoMascara < 8) {
					mascaraBinario = binarioMascara(1, 8, mascaraBinario, tipoMascara);
					ipBinario = binarioIp(ipVetor[0]);
					binarioBoolean = binarioLogica(ipBinario, mascaraBinario);
					ipVetor[0] = enderecoRede(binarioBoolean);

					for (int contador = 1; contador < ipVetor.length; contador++) {
						ipVetor[contador].equals("0");
					}

					for (int contador = 0; contador < ipVetor.length; contador++) {
						ipVetor2[contador] = ipVetor[contador];
					}

					ipVetor2[0] = enderecoBroadcast(binarioBoolean, mascaraBinario, ipVetor2[0]);
					for (int contador = 1; contador < ipVetor.length; contador++) {
						ipVetor2[contador] = "255";
					}

					mascara = mascara(mascaraBinario) + ".0.0.0";

				} else if (tipoMascara < 16) {
					mascaraBinario = binarioMascara(8, 16, mascaraBinario, tipoMascara);
					ipBinario = binarioIp(ipVetor[1]);
					binarioBoolean = binarioLogica(ipBinario, mascaraBinario);
					ipVetor[1] = enderecoRede(binarioBoolean);

					ipVetor[2] = "0";
					ipVetor[3] = "0";

					for (int contador = 0; contador < ipVetor.length; contador++) {
						ipVetor2[contador] = ipVetor[contador];
					}

					ipVetor2[1] = enderecoBroadcast(binarioBoolean, mascaraBinario, ipVetor2[1]);
					ipVetor2[2] = "255";
					ipVetor2[3] = "255";

					mascara = "255." + mascara(mascaraBinario) + ".0.0";

				} else if (tipoMascara < 24) {
					mascaraBinario = binarioMascara(16, 24, mascaraBinario, tipoMascara);
					ipBinario = binarioIp(ipVetor[2]);
					binarioBoolean = binarioLogica(ipBinario, mascaraBinario);
					ipVetor[2] = enderecoRede(binarioBoolean);

					ipVetor[3] = "0";

					for (int contador = 0; contador < ipVetor.length; contador++) {
						ipVetor2[contador] = ipVetor[contador];
					}
					ipVetor2[2] = enderecoBroadcast(binarioBoolean, mascaraBinario, ipVetor2[2]);
					ipVetor2[3] = "255";

					mascara = "255.255." + mascara(mascaraBinario) + ".0";

				} else if (tipoMascara < 32) {
					mascaraBinario = binarioMascara(24, 32, mascaraBinario, tipoMascara);
					ipBinario = binarioIp(ipVetor[3]);
					binarioBoolean = binarioLogica(ipBinario, mascaraBinario);
					ipVetor[3] = enderecoRede(binarioBoolean);

					for (int contador = 0; contador < ipVetor.length; contador++) {
						ipVetor2[contador] = ipVetor[contador];
					}

					ipVetor2[3] = enderecoBroadcast(binarioBoolean, mascaraBinario, ipVetor2[3]);

					mascara = "255.255.255." + mascara(mascaraBinario);

				}

				for (int contador = 0; contador < ipVetor.length; contador++) {
					enderecoRede += ipVetor[contador];
					enderecoBroadcast += ipVetor2[contador];
					
					if(contador != ipVetor.length-1) {
						enderecoRede += ".";
						enderecoBroadcast += ".";
					}
				}
				JOptionPane.showMessageDialog(null,"endereço de rede: "+ enderecoRede + "\nendereço broadcast: " + enderecoBroadcast + "\nmascara: " + mascara);

			}
		}

	}

	public static String binarioMascara(int contadorInicial, int contadorFinal, String mascaraBinario,
			int tipoMascara) {
		for (int contador = contadorInicial; contador < contadorFinal; contador++) {
			if (mascaraBinario.indexOf("0") > 0) {
				mascaraBinario += "0";

			} else {
				if (contador != tipoMascara) {
					mascaraBinario += "1";

				} else {
					mascaraBinario += "0";

				}
			}

		}
		return mascaraBinario;

	}

	public static String binarioIp(String ip) {
		String ipBinario = "";
		int ipInt = Integer.parseInt(ip);

		for (int contador = 128; contador > 0; contador = contador / 2) {
			if (ipInt - contador >= 0) {
				ipBinario += "1";
				ipInt -= contador;

			} else {
				ipBinario += "0";

			}
		}

		return ipBinario;
	}

	public static String binarioLogica(String ipBinario, String mascaraBinario) {
		String binarioBoolean = "";

		for (int contador = 0; contador < ipBinario.length(); contador++) {
			if (ipBinario.charAt(contador) == '1' && mascaraBinario.charAt(contador) == '1') {
				binarioBoolean += "1";

			} else {
				binarioBoolean += "0";

			}
		}
		return binarioBoolean;
	}

	public static String enderecoRede(String binarioBoolean) {
		int[] vetorDecimal = { 128, 64, 32, 16, 8, 4, 2, 1 };
		int soma = 0;
		String novoIp = "";
		for (int contador = 0; contador < binarioBoolean.length(); contador++) {
			if (binarioBoolean.charAt(contador) == '1') {
				soma = soma + vetorDecimal[contador];
			}

		}

		novoIp += soma;

		return novoIp;
	}

	public static String enderecoBroadcast(String binarioBoolean, String mascaraBinario, String ip) {
		int[] vetorDecimal = { 128, 64, 32, 16, 8, 4, 2, 1 };
		int soma = 0;
		for (int contador = 0; contador < binarioBoolean.length(); contador++) {
			if (mascaraBinario.charAt(contador) == '0') {
				soma = soma + vetorDecimal[contador];
			}

		}
		soma += Integer.parseInt(ip);
		String novoIp = "";
		novoIp += soma;
		return novoIp;

	}

	public static String mascara(String binarioMascara) {
		int[] vetorDecimal = { 128, 64, 32, 16, 8, 4, 2, 1 };
		int soma = 0;
		for (int contador = 0; contador < binarioMascara.length(); contador++) {
			if (binarioMascara.charAt(contador) == '1') {
				soma = soma + vetorDecimal[contador];
			}

		}
		String novaMascara = "";
		novaMascara += soma;

		return novaMascara;
	}

}
