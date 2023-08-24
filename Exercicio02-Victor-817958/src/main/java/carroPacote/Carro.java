package carroPacote;
public class Carro {
	private int codigo;
	private String nome;
	private String motor;
	private int portas;
	private int ano;
	
	public Carro() {
		this.codigo = -1;
		this.nome = "";
		this.motor = "";
		this.portas = -1;
		this.ano = -1;	
		}
	
	public Carro(int codigo, String nome, String motor, int portas, int ano)
	{
		this.codigo = codigo;
		this.nome = nome;
		this.motor = motor;
		this.portas = portas;
		this.ano = ano;
	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}
	
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	@Override
	public String toString() {
		return "Carro [codigo=" + codigo + ", nome=" + nome + ", motor=" + motor + ", portas=" + portas + ", ano=" + ano + "]";
	}	
}
