package exercicio3;

public class Fatura {
	private String numero, descricao;
	private int quantidadeComprada;
	private double item;

	public Fatura(String numero, String descricao, int quantidadeComprada, double item) {
		this.numero = numero;
		this.descricao = descricao;
		this.quantidadeComprada = quantidadeComprada;
		this.item = item;
	}

	public double getTotalFatura() {
		return quantidadeComprada * item;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidadeComprada() {
		return quantidadeComprada;
	}

	public void setQuantidadeComprada(int quantidadeComprada) {
		this.quantidadeComprada = quantidadeComprada;
	}

	public double getItem() {
		return item;
	}

	public void setItem(double item) {
		this.item = item;
	}

}
