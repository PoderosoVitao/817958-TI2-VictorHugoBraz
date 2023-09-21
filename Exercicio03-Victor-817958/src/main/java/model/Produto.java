package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Produto {
	private int id;
	private String descricao;
	private float preco;
	private int quantidade;
	private LocalDateTime dataFabricacao;	
	private String motor;
	
	public Produto() {
		id = -1;
		descricao = "";
		preco = 0.00F;
		quantidade = 0;
		dataFabricacao = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
		motor = "V8";
	}

	public Produto(int id, String descricao, float preco, int quantidade, LocalDateTime fabricacao, String motor) {
		setId(id);
		setDescricao(descricao);
		setPreco(preco);
		setQuantidade(quantidade);
		setDataFabricacao(fabricacao);
		setMotor(motor);
	}		
	
	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getMotor() {
		return motor;
	}

	public LocalDateTime getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDateTime dataFabricacao) {
		// Pega a Data Atual
		LocalDateTime agora = LocalDateTime.now();
		// Garante que a data de fabricação não pode ser futura
		if (agora.compareTo(dataFabricacao) >= 0)
			this.dataFabricacao = dataFabricacao;
	}

	public void setMotor(String Motor) {
			this.motor = Motor;
	}

	/**
	 * Método sobreposto da classe Object. É executado quando um objeto precisa
	 * ser exibido na forma de String.
	 */
	@Override
	public String toString() {
		return "Produto: " + descricao + "   Preço: R$" + preco + "   Quantidade.: " + quantidade +  "Motor: " + motor + "   Fabricação: "
				+ dataFabricacao;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getID() == ((Produto) obj).getID());
	}	
}